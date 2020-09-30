package 定时器;

import java.util.concurrent.PriorityBlockingQueue;

public class Test4 {

    static class Task implements Comparable<Task>{
        //Task中有一个命令，有一个计时器
        private Runnable command = null;
        private Long time;


        public Task(Runnable command, Long after) {
            this.command = command;
            this.time = System.currentTimeMillis() - after;
        }

        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread {

        //阻塞优先级队列
        private PriorityBlockingQueue<Task> queue = null;
        //创建一个锁
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
                        synchronized (mailBox) {
                            wait(task.time - curTime);
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
        //1.创建一个任务Task
        //2.创建一个阻塞队列
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        //3.创建一个线程去扫描阻塞队列，如果时间到就执行
        //需要创建一个定时器传入到Worker中
        public Object mailBox = new Object();

        public Timer() {
            Worker worker = new Worker(queue, mailBox);
            worker.run();
        }

        //4.添加任务，然后安排任务
        //schedule
        public void schedule(Runnable command, Long after) {
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (mailBox) {
                mailBox.notify();
            }
        }


    }

}
