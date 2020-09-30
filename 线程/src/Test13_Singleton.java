public class Test13_Singleton {
    //饿汉模式

    static class  Singleton {
        //设为private 在内外部就无法new在这个类了
        private Singleton() {}

        //唯一实例
        private static volatile Singleton instance = new Singleton();

        //只能得到，不能有set方法
        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
       Singleton s = Singleton.getInstance();
       Singleton s2 = Singleton.getInstance();

        System.out.println(s == s2);
    }


}
