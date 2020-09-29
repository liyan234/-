

public class MyPriorityQueueMIn {

    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x) {
        this.array[this.size]  = x;
        this.size++;

        shiftUp(this.array,this.size,this.size-1);
    }

    public Integer poll() {
        if(this.size <= 0) {
            return null;
        }

        int ret = this.array[0];
        this.array[0] = this.array[this.size - 1];
        this.size--;
        shiftDown(this.array,this.size,0);
        return ret;

    }

    public  boolean isEmpty() {
        return this.size == 0;
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = (parent*2) + 1;

        while(child < size) {
            if(child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            if(array[child] < array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = (parent*2) + 1;
        }
    }

    private void shiftUp(int[] array, int size, int index) {

        int child = index;
        int parent = (child - 1) / 2;

        while(child > 0) {
            if(array[child] < array[parent]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }


    public static void main(String[] args) {
        MyPriorityQueueMIn queue = new MyPriorityQueueMIn();

        queue.offer(4);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        queue.offer(6);
        queue.offer(9);
        queue.offer(8);

        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");
        }
    }


}
