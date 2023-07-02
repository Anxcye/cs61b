package deque;


import java.util.Iterator;

public class LinkedListDeque<T>  {

    private int size = 0;

    private class Node {
        public T item;
        public Node next;

        public Node prev;

        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }

        public String toString() {
            if (item == null)
                return null;
            else
                return item.toString();
        }
    }

    private Node sentinel = new Node(null, null, null);


    public LinkedListDeque(T item) {

        sentinel.next = new Node(item, sentinel, sentinel);
        size = 1;
    }

    public void addFirst(T item) {

        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;

        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;

        size += 1;
    }

    public boolean isEmpty() {

        return size == 0;

    }

    public int size() {

        return size;
    }

    public void printDeque() {
        String[] items = new String[size];
        Node p = sentinel.next;
        int i = 0;
        while (p != sentinel) {
            items[i] = p.item.toString();
            i += 1;
            p = p.next;
        }
        System.out.println(String.join(" ", items));
    }

    public T removeFirst() {
        if (size == 0)
            return null;

        T tmp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return tmp;
    }

    public T removeLast() {
        if (size == 0)
            return null;

        T tmp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return tmp;
    }

    public T get(int index) {
        if (index > size || index < 0)
            return null;
        Node p = sentinel.next;

        for (int i = 0; i < index; i++)
            p = p.next;

        return p.item;
    }

//    public Iterator<T> iterator() {
//
//        return new LinkedListDequeIterator();
//    }
//
//    private class LinkedListDequeIterator implements Iterator<T> {
//        private Node<T> p;
//
//        LinkedListDequeIterator() {
//            p = head.next;
//        }
//
//        public boolean hasNext() {
//            return p == head;
//        }
//
//        public T next() {
//            T item = p.item;
//            p = p.next;
//            return item;
//        }
//    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque))
            return false;
        LinkedListDeque<?> tmp = (LinkedListDeque<?>) o;
        if (tmp.size != size)
            return false;

        for (int i = 0; i < size; i++) {
            if (tmp.get(i) != this.get(i))
                return false;

        }

        return true;
    }

    public LinkedListDeque() {

        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public T getRecursive(int index) {

        return null;
    }

}
