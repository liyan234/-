package src1;

public class Enroll {

    private static final String user = "li";
    private static final String cip = "123";

    class User extends Exception {
        public User(String message) {
            super(message);
        }
    }

    class Cip extends Exception {
        public Cip(String message) {
            super(message);
        }
    }

    public static void login(String name, String num) throws User,Cip {
        if(!Enroll.user.equals(name)) {
            throw new RuntimeException("名字错误");
        }
        if(!Enroll.cip.equals(num)) {
            throw new RuntimeException("密码错误");
        }
        System.out.println("登录成功");
    }

    public static void main(String[] args) {
        try {
            login("li","123");
        } catch (User e) {
            e.printStackTrace();
        } catch (Cip e) {
            e.printStackTrace();
        }
    }
}
