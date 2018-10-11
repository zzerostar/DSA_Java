package structure.queue;

import structure.Elem;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/22
 */
public class LinkQueue implements Queue {

    private static final String TAG = "LinkQueue";

    private class Node {

        public Elem data;

        public Node next;
    }

    private int length = 0;

    private Node front;

    private Node rear;

    public LinkQueue() {
        front = null;
        rear = null;
    }


    @Override
    public Elem deQueue() {
        if (front == null) {
            LogUtil.d(TAG, "Queue is empty, can not deQueue");
            return null;
        }
        Node temp = front;
        front = front.next;
        length --;
        return temp.data;
    }

    @Override
    public void enQueue(Elem e) {
        Node node = new Node();
        node.data = e;

        if (front == null) {
            rear = node;
            front = node;
        } else {
            rear.next = node;
            rear = node;
        }
        length++;
    }

    @Override
    public int length() {
        return length;
    }
}
