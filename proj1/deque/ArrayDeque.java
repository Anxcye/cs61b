package deque;

public class ArrayDeque<T> {
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

    public void addFirst(T item) {
        if (size == arr.length) {
            resize(size * 2);
        }
        arr[first] = item;
        first = (first - 1 + arr.length) % arr.length;
        size++;

    }

    public void addLast(T item) {
        if (size == arr.length) {
            resize(2 * size);
        }
        arr[last] = item;
        last = (last + 1 + arr.length) % arr.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = (first + 1 + arr.length) % arr.length; i != last; i = (i + 1 + arr.length) % arr.length) {
            System.out.print(arr[i].toString() + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size <= 0){
            return null;
        }
        size--;
        first = (first + 1 + arr.length) % arr.length;
        T ret = arr[first];
        if ((size < arr.length / 4 )&& size >= 16) {
            resize(arr.length / 2);
        }
        return ret;
    }

    public T removeLast() {
        if (size <= 0){
            return null;
        }
        size--;
        last = (last - 1 + arr.length) % arr.length;
        T ret = arr[last];
        if ((size < arr.length / 4 )&& size >= 16) {
            resize(arr.length / 2);
        }
        return ret;
    }

    public T get(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return arr[(first + 1 + index) % arr.length];
    }



}
