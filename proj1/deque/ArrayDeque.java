package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size = 0;
    private int nextFirst = 0;
    private int nextLast = 1;


    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
//        System.arraycopy(items, 0, a, 0, size);
        System.arraycopy(items, (nextFirst + 1 + items.length) % items.length,
                a, 0, size);
        items = a;
    }

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }
    public ArrayDeque(T item) {
        items = (T[]) new Object[8];
        items[0] = item;
        size = 1;
        nextFirst = items.length - 1;
        nextLast = 1;


    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + items.length) % items.length;
        size += 1;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {

        return size;
    }

    public void printDeque() {
        String[] a = new String[size];
        for (int i = 0; i < size; i++) {
            a[i] = items[(nextFirst + 1 + i) % items.length].toString();
        }
        System.out.println(String.join(" ", a));


    }

    public T removeFirst() {
        items[(nextFirst + 1 + items.length) % items.length] = null;
        nextFirst = (nextFirst + 1 + items.length) % items.length;
        size -= 1;
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
        return null;
    }

    public T removeLast() {
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        size -= 1;
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
        return null;
    }

    public T get(int index) {

        return items[(nextFirst + 1 + index) % items.length];
    }

//    public Iterator<T> iterator() {
//
//    }

    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (other.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args)
//	{
//		ArrayDeque<Integer> a = new ArrayDeque<Integer>();
//        a.addFirst(1);
//        a.addFirst(2);
//        a.addFirst(3);
//        a.addFirst(4);
//        a.printDeque();
//	}


}
