package structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import structure.Elem;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/23
 */
public class BiTree {

    private static final String TAG = "BiTree";

    private BiNode root;

    private class BiNode {

        public Elem data;

        public BiNode leftChild;

        public BiNode rightChild;

    }

    private static int counter;

    public BiTree() {
        root = new BiNode();
    }

    public BiTree createBiTree(Elem[] elems) {
        counter = 0;
        createBiTreeNode(root, elems, counter++);
        return this;
    }

    public BiNode createBiTreeNode(BiNode root, Elem[] elems, int i) {
        if (i < elems.length) {
            if (elems[i] == null || elems[i].id == -1 || elems[i].name.equals("#")) {
                root = null;
            } else {
                BiNode left = new BiNode();
                BiNode right = new BiNode();
                root.data = elems[i];
                root.leftChild = createBiTreeNode(left, elems, counter++);
                root.rightChild = createBiTreeNode(right, elems, counter++);

            }
        }
        return root;
    }

    /**
     * 前序非递归遍历
     */
    public void preOrderTraverseNonRecursive() {
        LogUtil.d(TAG, "preOrderTraverseNonRecursive -- >");

        Stack<BiNode> stack = new Stack<BiNode>();

        BiNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {

                LogUtil.d(TAG, p.data.toString());
                stack.push(p);
                p = p.leftChild;
            } else {
                p = stack.pop();
                p = p.rightChild;
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraverse() {
        LogUtil.d(TAG, "preOrderTraverse -- >");
        preOrderTraverse(root);

    }

    private void preOrderTraverse(BiNode biNode) {
        if (biNode == null) {
            return;
        }

        System.out.print(biNode.data.toString());
        preOrderTraverse(biNode.leftChild);
        preOrderTraverse(biNode.rightChild);
    }

    /**
     * 中序非递归遍历
     */
    public void inOrderTraverseNonRecursive() {
        LogUtil.d(TAG, "inOrderTraverseNonRecursive -- >");

        Stack<BiNode> stack = new Stack<BiNode>();
        BiNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.leftChild;
            } else {
                p = stack.pop();
                LogUtil.d(TAG, p.data.toString());
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

    public void inOrderTraverse(BiNode biNode) {
        if (biNode == null) {
            return;
        }

        inOrderTraverse(biNode.leftChild);
        System.out.print(biNode.data.toString());
        inOrderTraverse(biNode.rightChild);
    }


    /**
     * 后序非递归遍历
     */
    public void postOrderTraverseNonRecursive() {
        LogUtil.d(TAG, "postOrderTraverseNonRecursive -- >");

        Stack<BiNode> stack = new Stack<BiNode>();
        Stack<BiNode> output = new Stack<BiNode>();

        BiNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                output.push(p);
                p = p.rightChild;
            } else {
                p = stack.pop();
                p = p.leftChild;
            }
        }
        while (!output.empty()) {
            BiNode biNode = output.pop();
            LogUtil.d(TAG, biNode.data.toString());
        }

    }

    /**
     * 后序遍历
     */
    public void postOrderTraverse() {
        LogUtil.d(TAG, "postOrderTraverse -- >");
        postOrderTraverse(root);

    }

    private void postOrderTraverse(BiNode biNode) {
        if (biNode == null) {
            return;
        }
        postOrderTraverse(biNode.leftChild);
        postOrderTraverse(biNode.rightChild);

        System.out.print(biNode.data.toString());
    }

    public void levelOrderTraversal(BiNode biNode) {
        if (biNode == null) {
            return;
        }

        Queue<BiNode> queue = new ArrayDeque<>();
        queue.add(biNode);

        BiNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.peek();

            System.out.print(curNode.data.toString());

            if (curNode.leftChild != null) {
                queue.add(curNode.leftChild);
            }
            if (curNode.rightChild != null) {
                queue.add(curNode.rightChild);
            }

            queue.poll();
        }
    }
}
