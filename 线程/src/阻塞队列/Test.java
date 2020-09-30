package 阻塞队列;

public class Test {
    static class BlockingQueue {
        private int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;
        private volatile int size = 0;

        public void put (int value) {
            //入队列
            synchronized (this) {
                if (size == array.length) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;
                notify();
            }
        }

        public int take() {
            int ret = -1;

            synchronized (this) {
                if (size == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;
                notify();
            }
            return ret;
        }
    }

}
