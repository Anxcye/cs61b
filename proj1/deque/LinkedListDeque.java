package deque;

public class LinkedListDeque<T> {
    private int size;

    private Node sentinel = new Node(null);

    /**
     * node of this list
     */
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T x) {
            item = x;
        }
    }

    /**
     * Constructor of LinkList
     */
    public LinkedListDeque() {
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        Node tmp = new Node(item);
        tmp.next = sentinel.next;
        tmp.prev = sentinel;
        sentinel.next = tmp;
        size++;
    }

    public void addLast(T item) {
        Node tmp = new Node(item);
        tmp.prev = sentinel.prev;
        tmp.next = sentinel;
        sentinel.prev = tmp;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while(p.next != sentinel){
            System.out.print(p.item + " ");

        }
        System.out.println();
    }

    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        T ret = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        T ret = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return ret;
    }

    public T get(int index) {
        Node p = sentinel.next;
        while(index >= 0) {
            if (p != sentinel) {
                p = p.next;
                index --;
            }
            return null;
        }

        return p.item;
    }

    public T getRecursive(int index) {
        return null;
    }
}
