package 定时器;

import java.util.concurrent.PriorityBlockingQueue;

public class Test5 {

    class Task implements Comparable<Task>{
        private Runnable command;
        private Long time;

        public Task(Runnable command, Long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        public void run() {this.command.run();}

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        Object mailBox = null;

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
                    if (curTime < task.time) {
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



    class Timer{

        //1. 任务Task
        //2.阻塞队列
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //3.用一个线程来循环创建一个阻塞队列
        Object mailBox = new Object();//用来做锁

        public Timer() {
            Worker worker = new Worker(queue,mailBox);
            worker.run();
        }

        //4.提供一个新的方法
        public void schedule(Runnable command, Long after) {
            Task task = new Task(command,after);
            queue.put(task);
            synchronized (mailBox) {
                mailBox.notify();
            }

        }

    }
}
