package structure.stack;

import structure.Elem;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/20
 */
public class LinkStack implements Stack {

    private static final String TAG = "LinkStack";


    private int length = 0;

    private Node top;

    private class Node {
        public Elem data;

        public Node next;
    }

    @Override
    public Elem pop() {
        if (top == null) {
            LogUtil.d(TAG, "Stack is empty, can not pop");
            return null;
        }
        Node temp = top;
        top = top.next;

        length--;
        return temp.data;
    }

    @Override
    public void push(Elem e) {
        Node node = new Node();
        node.data = e;
        node.next = top;
        top = node;

        length++;

    }

    public int length() {
        return length;
    }

    public String toString() {
        if (top != null) {
            Node temp = top;
            StringBuilder stringBuilder = new StringBuilder();
            while (temp != null) {
                stringBuilder.append(temp.data.toString()).append(",");
                temp = temp.next;
            }
            return stringBuilder.toString();
        } else {
            return "Empty LinkedList";
        }
    }

}
