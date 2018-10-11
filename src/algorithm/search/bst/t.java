//package algorithm.search.bst;
//
//import javax.swing.tree.TreeNode;
//
///**
// * @author zz
// * @date 2018/2/27
// */
//public class t {
//    public static boolean DeleteNode(TreeNode root, int data) {
//        TreeNode current = root;
//        TreeNode parent = root;
//        TreeNode tempParent = root;
//        boolean isLeft = true;
//        while (current.data != data) {
//            parent = current;
//            if (current.data > data) {
//                isLeft = true;
//                current = current.left;
//            } else if (current.data < data) {
//                isLeft = false;
//                current = current.right;
//            }
//            if (current == null)
//                return false;
//        }
//        if (current.left == null && current.right == null) {
//            if (current == root)
//                root = null;
//            if (isLeft) {
//                parent.left = null;
//            } else {
//                parent.right = null;
//            }
//            return true;
//        } else if (current.right == null) {
//            if (current == root)
//                root = current.left;
//            else if (isLeft)
//                parent.left = current.left;
//            else
//                parent.right = current.left;
//            return true;
//        } else if (current.left == null) {
//            if (current == root)
//                root = current.right;
//            else if (isLeft)
//                parent.left = current.right;
//            else
//                parent.right = current.right;
//            return true;
//        } else {
//            if (current == root) {
//                root = root.left;
//            }
//            TreeNode tempNode = current.left;
//            if (tempNode.right == null) {
//                if (isLeft)
//                    parent.left = tempNode;
//                else
//                    parent.right = tempNode;
//            } else {
//                while (tempNode.right != null) {
//                    tempParent = tempNode;
//                    tempNode = tempNode.right;
//                }
//                if (isLeft) {
//                    parent.left = tempNode;
//                    parent.left.left = current.left;
//                } else {
//                    parent.right = tempNode;
//                    parent.right.left = current.left;
//                }
//                if (tempNode.left == null)
//                    tempParent.right = null;
//                else
//                    tempParent.right = tempNode.left;
//            }
//            return true;
//        }
//    }
//}
