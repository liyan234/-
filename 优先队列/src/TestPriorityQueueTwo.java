import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueueTwo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        pQ.offer(5);
        pQ.offer(3);
        pQ.offer(7);
        pQ.offer(0);
        pQ.offer(2);

        while (!pQ.isEmpty()) {
            System.out.print(pQ.poll() + " ");
        }

    }
}
