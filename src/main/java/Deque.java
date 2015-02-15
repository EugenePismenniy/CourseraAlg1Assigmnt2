import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by eugene on 14.02.15.
 */
public class Deque<Item> implements Iterable<Item> {

    private LinkedList<Item> list = new LinkedList<Item>();

    public Deque() {
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        list.addFirst(item);
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        list.addLast(item);
    }

    public Item removeFirst() {
        return list.removeFirst();
    }

    public Item removeLast() {
        return list.removeLast();
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Iterator<Item> iterator = list.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Item next() {
                return iterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {

    }

}
