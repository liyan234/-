package 定时器;

import java.util.concurrent.PriorityBlockingQueue;

public class Test3 {

    static class Task implements Comparable<Task> {
        private Runnable command = null;
        private Long time = null;

        public Task(Runnable command, Long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;

        public Worker(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Task task = queue.take();
                    Long curTime = System.currentTimeMillis();
                    if (task.time > curTime) {
                        queue.put(task);
                        //等待时间
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
        //1.创建task
        //2.创建队列
        //3.用线程worker
        //4.安排

        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        //创建一个锁
        private Object mailBox = new Object();
        public void worker() {
            Worker worker = new Worker(queue,mailBox);
            worker.run();
        }

        //创建一个可以安排任务的
        public void schedule(Runnable command, Long after) {
            Task task = new Task(command,after);
            queue.put(task);
            synchronized (mailBox) {
                mailBox.notify();
            }
        }
    }
}
