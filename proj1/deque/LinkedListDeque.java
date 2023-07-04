package deque;


import java.util.Iterator;

//public class LinkedListDeque<T> implements Iterable<T> {

public class LinkedListDeque<T> {
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


//public Iterator<T> iterator() {
//  // 创建一个新的迭代器对象
//  Iterator<T> iter = new Iterator<T>() {
//    // 定义一个当前索引变量
//    private int index = 0;
//
//    // 实现hasNext方法，判断是否有下一个元素
//    public boolean hasNext() {
//      // 如果当前索引小于数组的长度，说明还有下一个元素
//      return index < size;
//    }
//
//    // 实现next方法，返回下一个元素
//    public T next() {
//      // 如果没有下一个元素，抛出异常
//      if (!hasNext()) {
////        throw new NoSuchElementException();
//      }
//      // 返回当前索引对应的元素，并将索引加一
//      return get(index++);
//    }
//  };
//  // 返回迭代器对象
//  return iter;
//}


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
        if (index > size || index < 0)
            return null;
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node p) {
        if (index == 0)
            return p.item;
        return getRecursiveHelper(index - 1, p.next);
    }

}
