package structure.tree;

/**
 * @author zz
 * @date 2018/2/23
 */
public class BiNode implements Comparable<BiNode>{
    public BiNode(char c, int weight, BiNode parent, BiNode leftChild, BiNode rightChild) {
        this(c, weight);
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BiNode(char c, int weight) {
        this.c = c;
        this.weight = weight;
    }

    public char c;

    public int weight;

    public BiNode parent;

    public BiNode leftChild;

    public BiNode rightChild;

    @Override
    public int compareTo(BiNode biNode) {
        return weight - biNode.weight;
    }

    public boolean isLeftChild() {
        return parent != null && parent.leftChild == this;
    }

    public boolean isRightChild() {
        return parent != null && parent.rightChild == this;
    }

    @Override
    public String toString() {
        return "("+ c + ": " + weight + ")";
    }
}
