public class Test4 {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("cxk") {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "正在打篮球");

                    //若是在新线程中用sleep，并且用到了这种打断方式
                    //一定要在catch中加break
                    //若是打断的是后正在休眠，就会出现异常，若不用break
                    //又会继续执行这个新线程
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }

                System.out.println(Thread.currentThread().getName() + "发来了律师函");
            }
        };
        t.start();

        Thread.sleep(100);

        t.interrupt();


       /* Thread.interrupted();
        //判断中断标记的话，
        //返回第一次结果为true
        //将把中断标记设为false

        Thread.currentThread().isInterrupted();
        //判断中断标记,仅仅是判定标记位，而不会修改标记位
        //返回结果一直是是true
*/



    }
}


