import java.util.PriorityQueue;

public class TestPriorityQueueThree {

    public static void main(String[] args) {

        PriorityQueue<Integer> pQ  = new PriorityQueue<>((Integer o1,Integer o2) -> {
            return o2 - o1;
        });

        PriorityQueue<Integer> pQ1  = new PriorityQueue<>((Integer o1,Integer o2) -> o2 - o1);

        PriorityQueue<Integer> pQ2  = new PriorityQueue<>((o1,o2) -> o2 - o1);
    }
}
