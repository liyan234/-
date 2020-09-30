public class Test8 {

    static class counter {
        public int count = 0;

        synchronized public void increase() {
            count++;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        counter c = new counter();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    c.increase();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    c.increase();
                }
            }
        };

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        System.out.println(c.count);

    }
}
