package lab4;

public class LinkedList  <T extends Comparable<T>>{
    static class Node<V> {
        Node<V> next;
        V val;

        public Node(V val) {
            this.val = val;
            next = null;
        }
    }

    Node<T> first;

    public LinkedList() {
        first = null;
    }

    public void add(T val) {
        if (first == null) {
            first = new Node<>(val);
            return;
        }
        first = first.next;
        add(val);
    }

    public void add(T val, int index) {

    }
}
