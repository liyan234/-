public class MyPriorityQueue {

    private int[] array = new int[100];
    private int size = 0;

    public void offer( int x) {
        this.array[this.size] = x;
        this.size++;

        shiftUp(this.array,this.size,this.size-1);

        //shiftDown(this.array,this.size,0);

    }

    //向上调整，构成大堆
    private void shiftUp(int[] array, int size, int index) {

        int child = index;
        int parent = (child - 1) / 2;

        while(child > 0) {
            if(array[parent] < array[child]) {
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

    public Integer poll() {
        if(this.size <= 0) {
            return null;
        }
        int ret = this.array[0];
        this.array[0] = array[this.size - 1];
        this.size--;
        shiftDown(this.array,this.size,0);
        return ret;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    //向下调整,构成大堆
    //调整一次,为堆的输出做准备
    private void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = (parent * 2) + 1;

        while(child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            parent = child;
            child = (parent * 2) + 1;
        }
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.offer(7);
        myPriorityQueue.offer(9);
        myPriorityQueue.offer(8);
        myPriorityQueue.offer(4);
        myPriorityQueue.offer(6);
        myPriorityQueue.offer(5);

        while(!myPriorityQueue.isEmpty()) {
            Integer cur = myPriorityQueue.poll();
            System.out.print(cur + " ");
        }

    }

}
