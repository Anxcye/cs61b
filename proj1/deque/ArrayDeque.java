package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] arr;
    private int first;
    private int last;
    private int size;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        first = 0;
        last = 1;
        size = 0;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        int index = 0;

        int i = (first + 1 + arr.length) % arr.length;
        do {
            tmp[index++] = arr[i];
            i = (i + 1 + arr.length) % arr.length;
        } while (i != last);
        first = tmp.length - 1;
        last = size;
        arr = tmp;
    }

    @Override
    public void addFirst(T item) {
        if (size == arr.length) {
            resize(size * 2);
        }
        arr[first] = item;
        first = (first - 1 + arr.length) % arr.length;
        size++;

    }

    @Override
    public void addLast(T item) {
        if (size == arr.length) {
            resize(2 * size);
        }
        arr[last] = item;
        last = (last + 1 + arr.length) % arr.length;
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = (first + 1 + arr.length) % arr.length;
             i != last; i = (i + 1 + arr.length) % arr.length) {
            System.out.print(arr[i].toString() + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        size--;
        first = (first + 1 + arr.length) % arr.length;
        T ret = arr[first];
        if ((size < arr.length / 2) && size >= 16) {
            resize(arr.length / 2);
        }
        return ret;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        size--;
        last = (last - 1 + arr.length) % arr.length;
        T ret = arr[last];
        if ((size < arr.length / 2) && size >= 16) {
            resize(arr.length / 2);
        }
        return ret;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return arr[(first + 1 + index) % arr.length];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        ArrayDequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T ret = get(index);
            index++;
            return ret;
        }

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!other.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }


}
