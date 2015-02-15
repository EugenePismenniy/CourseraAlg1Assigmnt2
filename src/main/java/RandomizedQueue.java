import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by eugene on 14.02.15.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private LinkedList<Item> list = new LinkedList<Item>();

    public RandomizedQueue() {
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        list.add(item);
    }

    public Item dequeue() {

        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        int i = randomIndex();
        return list.remove(i);
    }

    public Item sample() {

        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }

        return list.get(randomIndex());
    }

    private int randomIndex() {
        return StdRandom.uniform(0, list.size());
    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {
            {
                Object[] tmp = list.toArray();
                StdRandom.shuffle(tmp);
                array = tmp;
            }
            private int i = 0;
            private Object[] array;

            @Override
            public boolean hasNext() {
                return i < array.length;
            }

            @Override
            public Item next() {

                if (hasNext())
                    return (Item) array[i++];

                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {


        RandomizedQueue<String> list = new RandomizedQueue<String>();

        list.enqueue("A");
        list.enqueue("B");
        list.enqueue("C");
        list.enqueue("D");


        System.out.println("----------- " + list.size() + "-------------");

        for (String e : list) {
            System.out.println(e);
        }


        System.out.println("--------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println(list.sample());
        }

        System.out.println("-----------" + list.size() + "----------");
        int n = list.size();
        for (int i = 0; i < n+1; i++) {
            System.out.println(list.dequeue());
        }

        //System.out.println(list.dequeue());
    }
}
