public class Test3 {

    //这种结束方法比较温和，当标记位被标记后结束当前任务，才会结束
    private static boolean B = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("cxk") {
            @Override
            public void run() {
                while (!B) {

                    System.out.println(Thread.currentThread().getName() + "正在打篮球");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //终止的标记
                System.out.println("cxk发出了警告律师函");
            }
        };
        t.start();

        //这个休眠非常重要
        //多线程是抢占式执行。
        Thread.sleep(1000);//让线程休眠1000ms

        B = true;
    }
}
