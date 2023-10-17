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
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        Node tmp = new Node(item);
        tmp.prev = sentinel.prev;
        tmp.next = sentinel;
        sentinel.prev = tmp;
        sentinel.prev.prev.next = sentinel.prev;

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
        while (p != sentinel) {
            System.out.print(p.item.toString() + " ");
            p = p.next;
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
        size--;
        return ret;
    }

    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        Node p = sentinel.next;
        while (p != sentinel) {
            if (index > 0) {
                p = p.next;
                index--;
            }else if (index == 0){
                return p.item;
            }
        }
            return null;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public T getRecursiveHelper(int index, Node p){
        if (index == 0){
            return p.item;
        }
        else{
            return getRecursiveHelper(index - 1, p.next);
        }
    }
//
//    public Iterator<T> iterator(){
//
//    }
//    public boolean equals(Object o){
//
//    }
}
