package structure.list;

import structure.Elem;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/18
 */
public class LinkedList {
    private static final String TAG = "ArrayList";

    private Node header;

    private class Node {
        public Elem data;

        public Node next;
    }

    public LinkedList() {
        this.header = new Node();
        this.header.data = new Elem(-99, "header");
    }

    public void insert(Elem data, int index) {
        if (index < 0 || data == null) {
            throw new NullPointerException("index < 0 || data == null");
        }
        Node p = header;
        int i = 0;
        while (i < index && p.next != null) {
            p = p.next;
            i++;
        }
        if (p == null) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        Node s = new Node();
        s.data = data;
        s.next = p.next;
        p.next = s;
    }

    public void delete(int index) {
        if (index < 0) {
            throw new IllegalStateException("index < 0");
        }
        Node p = header;
        int i = 0;
        while (i <= index && p != null) {
            p = p.next;
            i++;
        }
        if (p == null) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        p.next = p.next.next;
    }

    public void print() {
        Node p = header;
        while (p.next != null) {
            System.out.print(p.data.toString());
            p = p.next;
        }
    }

    public void clear() {
        Node temp;
        while (header != null) {
            temp = header;
            header = header.next;
            temp = null;
        }
    }

    public Elem get(int index) {
        if (header == null) {
            LogUtil.d(TAG, "LinkedList header is empty, can not get");
            return null;
        } else {
            Node temp = header;
            int i = 0;
            while (i < index && temp != null) {
                temp = temp.next;
                i++;
            }
            if (temp == null) {
                LogUtil.d(TAG, "Get index out of bounds");
                return null;
            } else {
                return temp.data;
            }
        }
    }


    public String toString() {
        if (header != null) {
            Node temp = header;
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
