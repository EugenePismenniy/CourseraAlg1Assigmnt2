/**
 * Created by eugene on 16.02.15.
 */
public class Subset {

    public static void main(String[] args) {

        //args = new String[]{"5"};

        final int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> q = new RandomizedQueue<String>();

        for (int i = 0; i < k; i++) {
            String s = StdIn.readString();
            q.enqueue(s);
        }

        for (String s : q) {
            System.out.println(s);
        }

    }
}
