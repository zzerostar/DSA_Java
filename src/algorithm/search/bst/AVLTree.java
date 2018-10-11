package algorithm.search.bst;

/**
 * @author zz
 * @date 2018/2/28
 */
public class AVLTree {
    
    private BiTNode root;

    public BiTNode rotateLeft() {
        return singleRotateLeft(root);
    }
    
    private BiTNode singleRotateLeft(BiTNode root) {
        BiTNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        return newRoot;
    }

    private BiTNode singleRotateRight(BiTNode root) {
        BiTNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        return newRoot;
    }

    private BiTNode doubleRotateWithLeft(BiTNode root) {
        root.leftChild = singleRotateRight(root.leftChild);
        return singleRotateLeft(root);
    }

    private BiTNode doubleRotateWithRight(BiTNode root) {
        root.rightChild = singleRotateLeft(root.rightChild);
        return singleRotateRight(root);
    }

    public void insert(int key) {
        this.root = insert(key, root);
    }

    private BiTNode insert(int key, BiTNode p) {
        if (p == null) {
            p = new BiTNode();
            p.data = key;
        } else if (key < p.data) {
            p.leftChild = insert(key, p.leftChild);

            if (height(p.leftChild) - height(p.rightChild) == 2) {
                if (key < p.leftChild.data) {
                    p = singleRotateLeft(p);
                } else {
                    p = doubleRotateWithLeft(p);
                }
            }
        } else if (key > p.data) {
            p.rightChild = insert(key, p.rightChild);

            if (height(p.rightChild) - height(p.leftChild) == 2) {
                if (key < p.rightChild.data) {
                    p = doubleRotateWithRight(p);
                } else {
                    p = singleRotateRight(p);
                }
            }
        }
        p.bf = Math.max(height(p.leftChild), height(p.rightChild)) + 1;
        return p;
    }


    // FIXME: 2018/2/28 
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

    public int height() {
        return height(root);
    }

    public int height(BiTNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.leftChild);
            int right = height(node.rightChild);
            return left > right ? left + 1 : right + 1;
        }
    }
}
