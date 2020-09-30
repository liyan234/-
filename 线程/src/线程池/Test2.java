package 线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test2 {

    class Worker extends Thread{
        private int id;
        private BlockingQueue<Runnable> queue = null;

        public Worker(int id, BlockingQueue<Runnable> queue) {
            this.id = id;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {

                try {
                    Runnable runnable = queue.take();
                    System.out.println(id + "Running");
                    runnable.run();
                } catch (InterruptedException e) {
                    System.out.println("线程被终止");
                }

            }
        }
    }


    class MyThreadPool {
        //阻塞队列组织若干个货物、
        private BlockingQueue queue = new LinkedBlockingQueue();

        //一个list组织若干个
        private List<Worker>  list = new ArrayList();

        private static final int maxThreads = 10;

        public void execute(Runnable runnable) throws InterruptedException {
            if (list.size() < maxThreads) {
                Worker worker = new Worker(list.size(), queue);
                worker.start();
                list.add(worker);
            }
            queue.put(runnable);
        }

        public void shutDown() throws InterruptedException {
            for (Worker worker: list) {
                worker.interrupt();
            }

            for (Worker worker: list) {
                worker.join();
            }
        }
    }
}
