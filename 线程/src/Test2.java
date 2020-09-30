public class Test2 {
    public static void main(String[] args) {
        Thread t1 = new Thread("线程1") {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                   // System.out.println(Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //以下四个线程被创建后就存在了，奴可以被改变
        System.out.println(t1.getName());//获取线程的名字
        System.out.println(t1.getId());//获取线程的id
        System.out.println(t1.getPriority());//获取线程的优先级
        System.out.println(t1.isDaemon());//线程是否为后台线程

        //下面的会随着线程的运行而发生改变
        System.out.println(t1.isAlive());//线程是否存活
        System.out.println(t1.isInterrupted());//线程是否被中断
        System.out.println(t1.getState());//获取线程的状态

        t1.start();

        System.out.println(t1.isAlive());//线程是否存活
        System.out.println(t1.isInterrupted());//线程是否被中断
        System.out.println(t1.getState());//获取线程的状态
    }
}
