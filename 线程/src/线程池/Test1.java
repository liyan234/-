package 线程池;
//包含一些线程，避免我们去频繁创建/销毁线程的开销

//核心操作 execute 把一个任务加到线程池中
//        shutdown 销毁线程池中的所有线程


//组成部分
//     管理两个内容，要执行的任务，执行任务的线程们
//     有一个类，来描述具体线程要做的工作是啥
//     一个数据结构组织任务，阻塞队列
//     一个类，表示工作线程
//     一个数据结构，组织若干个线程

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test1 {

    //使用这个类来描述当前的工作线程
    static class Worker extends Thread {
        private  int id = 0;
        private  BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable c = queue.take();
                    System.out.println("Thread" + id + "Running");
                    c.run();
                } catch (InterruptedException e) {
                    //线程被结束
                    System.out.println("线程被终止");
                }
            }
        }
    }

    static class MyThreadPool {
        //一个阻塞队列用来组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        //一个list用来组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();

        //定义线程池内应该有多少个线程，随便定义
        private static final int maxThread = 10;

        //相当于往线程池中添加线程
        public void execute(Runnable c) throws InterruptedException {
            if (workers.size() < maxThread) {
                Worker worker = new Worker(queue, workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(c);
        }

        //shutdown,意味着所有的线程结束了
        public void shutDown() throws InterruptedException {
            //中断所有线程
            for (Worker w: workers
                 ) {
                w.interrupt();
            }
            //这个线程执行完后才可以中断
            for (Worker w: workers
                 ) {
                w.join();
            }
        }
    }
}
