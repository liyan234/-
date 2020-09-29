package topK;

public class Test {

    public static void main(String[] args) {
        TopK topK = new TopK(4);

        int[] array = {1,23,5,6,3,9,48,57,34,56100,23,44,98,102,89,123,342,111};
        for (int num:array
             ) {
            topK.offer(num);
        }
        while(!topK.isEmpty()) {
            System.out.print(topK.poll() + " ");
        }
    }

}
