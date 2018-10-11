package structure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import util.LogUtil;

/**
 * 哈夫曼树
 * @author zz
 * @date 2018/2/23
 */
public class HuffmanTree {

    private static final String TAG = "HuffmanTree";

    private BiNode root;

    private int nodeCount;

    private List<BiNode> biNodeList;

    public class HuffmanCode {
        public char c;

        public String code;

        @Override
        public String toString() {
            return "("+ c + ": " + code + ")";
        }
    }


    private List<BiNode> setUp(BiNode[] biNodes) {
        return Arrays.asList(biNodes);
    }

    public BiNode buildTree(List<BiNode> nodeList) {
        PriorityQueue<BiNode> priorityQueue = new PriorityQueue<>(nodeList);
        while (priorityQueue.size() != 1) {
            BiNode left = priorityQueue.remove();
            BiNode right = priorityQueue.remove();
            BiNode parent = new BiNode('#', left.weight + right.weight, null, left, right);
            left.parent = parent;
            right.parent = parent;
            priorityQueue.add(parent);
        }
        root = priorityQueue.remove();
        return root;
    }

    public BiNode buildTree(BiNode[] biNodes) {
        biNodeList = setUp(biNodes);
        LogUtil.d(TAG, biNodeList.toString());
        return buildTree(biNodeList);
    }

    public List<HuffmanCode> huffmanEncode() {
        if (biNodeList == null) {
            LogUtil.d(TAG, "node list is not setup");
            return null;
        }

        List<HuffmanCode> huffmanCodeList = new ArrayList<>();
        for (BiNode biNode : biNodeList) {
            BiNode current = biNode;
            StringBuilder stringBuilder = new StringBuilder();
            while (current != root) {
                if (current.isLeftChild()) {
                    stringBuilder.insert(0, "0");
                } else {
                    stringBuilder.insert(0, "1");
                }
                current = current.parent;
            }
            HuffmanCode huffmanCode = new HuffmanCode();
            huffmanCode.code = stringBuilder.toString();
            huffmanCode.c = biNode.c;
            huffmanCodeList.add(huffmanCode);

        }
        return huffmanCodeList;
    }

    public List<HuffmanCode> huffmanDecode(String code) {

        List<HuffmanCode> huffmanCodeList = new ArrayList<>();
        BiNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            stringBuilder.append(c);
            if (c == '0') {
                temp = temp.leftChild;
            } else {
                temp = temp.rightChild;
            }

            if (temp.leftChild == null && temp.rightChild == null) {
                HuffmanCode huffmanCode = new HuffmanCode();
                huffmanCode.code = stringBuilder.toString();
                huffmanCode.c = temp.c;
                huffmanCodeList.add(huffmanCode);
                stringBuilder.delete(0, stringBuilder.length());
                temp = root;
            }
        }
        return huffmanCodeList;
    }

}
