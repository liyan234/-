public class Test1 {

    //实现Runnable的接口
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("这是一个线程3");
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是一个线程1");
        }
    }

    public static void main(String[] args) {
        //1.显式继承Thread
        Thread t1 = new MyThread();
        t1.start();

        //2.通过匿名内部类的方式继承Thread
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("这是一个线程2");
            }
        };
        t2.start();

        //3.显式创建一个类，实现Runnable接口，然后把这个Runnable接口的接口连接到Thread实列上
        Thread t3 = new Thread(new MyRun());
        t3.start();

        //4.通过匿名内部类来实现Runnable接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个线程4");
            }
        };
        Thread t4 = new Thread(runnable);
        t4.start();

        //5.使用lambda表达式来指定，线程执行的内容
        Thread t5 = new Thread(() -> {
            System.out.println("这是一个线程5");
        });
     }

}
