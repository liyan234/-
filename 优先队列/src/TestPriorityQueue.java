import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {

    static class A implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new A());


        pQ.offer(4);
        pQ.offer(1);
        pQ.offer(5);
        pQ.offer(7);
        pQ.offer(8);

        while(!pQ.isEmpty()) {
            System.out.print(pQ.poll() + " ");
        }
    }
}
