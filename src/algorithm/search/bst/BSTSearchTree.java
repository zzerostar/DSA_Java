package algorithm.search.bst;

import java.util.Stack;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/27
 */
public class BSTSearchTree {

    private static final String TAG = "BSTSearchTree";

    private BiTNode root;

    private long size;


    public boolean addNode(int key) {
        if (root == null) {
            root = new BiTNode();
            root.data = key;
            return true;
        } else {
            BiTNode temp = root;
            BiTNode parent = root;

            while (temp != null) {
                if (key > temp.data) {
                    parent = temp;
                    temp = temp.rightChild;
                } else if (key < temp.data) {
                    parent = temp;
                    temp = temp.leftChild;
                } else {
                    return false;
                }
            }
            BiTNode biTNode = new BiTNode();
            biTNode.data = key;
            if (key > parent.data) {
                parent.rightChild = biTNode;
            } else {
                parent.leftChild = biTNode;
            }
            return true;
        }
    }

    public boolean deleteNode(int key) {
        BiTNode current = root;
        BiTNode parent = root;

        boolean isLeft = true;
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeft = true;
                current = current.leftChild;
            } else if (current.data < key) {
                isLeft = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        //要删除的为叶子结点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            }
            if (isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
        } else if (current.leftChild == null) { //要删除的结点只有右孩子
            if (current == root) {
                root = current.rightChild;
            }
            if (isLeft) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
        } else if (current.rightChild == null) { //要删除的结点只有左孩子
            if (current == root) {
                root = current.leftChild;
            }

            if (isLeft) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {

            BiTNode tempParent = current;
            BiTNode temp = current.leftChild;
            while (temp.rightChild != null) {
                tempParent = temp;
                temp = temp.rightChild;
            }

            if (current == root) {
                root.data = temp.data;

            } else {
                if (isLeft) {
                    parent.leftChild.data = temp.data;
                } else {
                    parent.rightChild.data = temp.data;
                }

            }

            if (temp == current.leftChild) {
                current.leftChild = current.leftChild.leftChild;
            } else {
                tempParent.rightChild = temp.leftChild;
            }
            return true;
        }
    }

    public BiTNode findNode(int key) {
        if (root == null) {
            return null;
        }

        BiTNode temp = root;
        while (temp != null) {
            if (key == temp.data) {
                return temp;
            } else if (key > temp.data) {
                temp = temp.rightChild;
            } else {
                temp = temp.leftChild;
            }
        }
        return null;
    }


    /**
     * 中序非递归遍历
     */
    public void inOrderTraverseNonRecursive() {
        LogUtil.d(TAG, "inOrderTraverseNonRecursive -- >");

        Stack<BiTNode> stack = new Stack<BiTNode>();
        BiTNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.leftChild;
            } else {
                p = stack.pop();
                LogUtil.d(TAG, p.data + ",");
                p = p.rightChild;
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraverse() {
        LogUtil.d(TAG, "inOrderTraverse -- >");
        inOrderTraverse(root);

    }

    private void inOrderTraverse(BiTNode biTNode) {
        if (biTNode == null) {
            return;
        }

        inOrderTraverse(biTNode.leftChild);
        LogUtil.d(TAG, biTNode.data + ",");
        inOrderTraverse(biTNode.rightChild);
    }
}
