import java.io.File;

public class Test1 {

    public static void main(String[] args) {
        //文件操作

        File file = new File("c:/Test1.txt");


        System.out.println(file.exists());//是否存在
        System.out.println(file.isFile());//是否普通文件
        System.out.println(file.isDirectory());//是否目录文件


        File file2 = new File("c:/Test1");
        listALLFiles(file2);
    }

    //罗列出一个目录中的所有文件
    private static void listALLFiles(File f) {

        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                listALLFiles(file);
            }
        } else {
            //打印这个文件的目录
            System.out.println(f);
        }
    }
}
