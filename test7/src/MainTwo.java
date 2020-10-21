import java.util.Arrays;

public class MainTwo {

    public static  int compareTo(String str1,String str2) {
         int len1 = str1.length();
         int len2 = str2.length();

         int shortLen = Math.min(len1,len2);

        for (int i = 0; i < shortLen; i++) {
            int j = str1.charAt(i) - str2.charAt(i);
            if( j < 0) {
                return -1;
            } else if ( j > 0){
                return 1;
            }
        }

        if(len1 == len2) {
            return 0;
        } else {
            return (len1 - len2 > 0) ? 1 : -1;
        }
    }


    public static void main(String[] args) {

        String str1 = "123";
        String str2 = "123";

        System.out.println(str1.compareTo(str2));

        System.out.println(compareTo(str1,str2));

    }
}
