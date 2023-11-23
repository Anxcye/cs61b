package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private int size;

    private Node sentinel = new Node(null);

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node p = sentinel.next;

        @Override
        public boolean hasNext() {
            return p != sentinel;
        }

        @Override
        public T next() {
            T ret = p.item;
            p = p.next;
            return ret;
        }
    }

    /**
     * node of this list
     */
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        Node(T x) {
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

    @Override
    public void addFirst(T item) {

        Node tmp = new Node(item);
        tmp.next = sentinel.next;
        tmp.prev = sentinel;
        sentinel.next = tmp;
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node tmp = new Node(item);
        tmp.prev = sentinel.prev;
        tmp.next = sentinel;
        sentinel.prev = tmp;
        sentinel.prev.prev.next = sentinel.prev;

        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item.toString() + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
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

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        T ret = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return ret;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        Node p = sentinel.next;
        while (p != sentinel) {
            if (index > 0) {
                p = p.next;
                index--;
            } else if (index == 0) {
                return p.item;
            }
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(index - 1, p.next);
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (this.size != other.size) {
            return false;
        }
        Node p = this.sentinel.next;
        Node q = other.sentinel.next;
        while (p != this.sentinel) {
            if (!p.item.equals(q.item)) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

}
