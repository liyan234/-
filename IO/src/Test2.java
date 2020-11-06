import java.io.*;

public class Test2 {

    public static void main(String[] args) throws IOException {
        copyFile("c:/Test1/xxx.jpg", "c:/Test1/yyy.jpg");
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);

        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void copyFile2(String srcPath, String destPath)  {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile3(String srcPath, String destPath)  {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile4(String srcPath, String destPath)  {
       try (FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            FileInputStream fileInputStream = new FileInputStream(srcPath)) {

           byte[] bytes = new byte[1024];
           int len = -1;
           while ((len = fileInputStream.read()) != -1) {
               fileOutputStream.write(bytes, 0, len);
           }
       } catch (IOException e){
           e.printStackTrace();
       }
    }
}
