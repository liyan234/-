public class Test14_Singleton2 {
    //懒汉模式

    static class Singleton {
        private Singleton () {

        }

        private static volatile Singleton instance = null;

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
