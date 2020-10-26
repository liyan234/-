public class ToString {

    public static void toStrin(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        toStrin(array);
    }
}
