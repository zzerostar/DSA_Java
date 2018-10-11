package structure.list;

import structure.Elem;

/**
 * @author zz
 * @date 2018/5/30
 */
public class DoublyLinkedList {

    private Node header;

    public DoublyLinkedList() {
        this.header = new Node();
        this.header.data = new Elem(-99, "header");
    }

    public class Node {

        public Elem data;

        public Node prev;

        public Node next;
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
        s.prev = p;
        s.next = p.next;
        if (p.next != null) {
            p.next.prev = s;
        }
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
        if (p.next != null) {
            p.next.prev = p.prev;
        }
        p.prev.next = p.next;
    }

    public void print() {
        Node p = header;
        while (p.next != null) {
            System.out.print(p.data.toString());
            p = p.next;
        }
    }
}
