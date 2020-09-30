package 阻塞队列;

public class Test2 {

    static class BlockingQueue {
        private int[] array = new int[100];
        private volatile int head = 0;
        private volatile int tail = 0;
        private volatile int size = 0;


        public void put(int v) throws InterruptedException {

            synchronized (this) {
                while (size == array.length) {
                    wait();
                }
                array[tail] = v;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;
                notifyAll();
            }

        }

        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                while (size == 0) {
                    wait();
                }
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;
                notifyAll();
            }
            return ret;
        }
    }
}
