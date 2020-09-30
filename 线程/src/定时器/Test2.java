package 定时器;

import java.util.concurrent.PriorityBlockingQueue;

public class Test2 {

    static class Task implements Comparable<Task>{
        private Runnable command;
        private long time;

        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
            //多少时间后这个任务去执行
        }

        //command 表示这个命令
        public void run() {
            command.run();//表示这个命令如何去执行
        }

        //引入比较的方法，还是为了看那个任务是最先执行的
        //
        @Override
        public int compareTo(Task o) {
            return  (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue= null;
        private Object mailBox = null;

        public Worker (PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            //具体线程如何实现
            while (true) {
                try {
                    Task task = queue.take();
                    Long curTime = System.currentTimeMillis();
                    if (task.time > curTime) {
                        queue.put(task);
                        synchronized (mailBox) {
                            mailBox.wait(task.time - curTime);
                        }
                    } else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    static class Timer {

        //构建一个阻塞优先队列去排序这个任务
        private PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<>();

        //构造方法
        //需要一个线程去循环扫面队首元素，是否到时间点
        //如果到了时间点才会去执行
        private Object mailBox = new Object();
        public Timer() {
            Worker worker = new Worker(q,mailBox);
            worker.start();
        }

        //需要一个方法将task安排进入队列
        public void schedule (Runnable command, long after) {
            Task task = new Task(command,after);
            q.put(task);
            synchronized (mailBox) {
                mailBox.notify();
                //当安排新任务后，唤醒等待，看这个新任务是否进入队首
                //若是进入队首，则会对这个新任务进行wait或者执行这个任务
            }
        }
    }
}
