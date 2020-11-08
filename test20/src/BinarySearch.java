public class BinarySearch {

    public static int binarySearch(int[] array,int key) {
        int right = array.length-1;
        int left = 0;
        int mid = (right + left)/2;
        while(left <= right) {
            if(array[mid] == key) {
                return mid;
            }
            if(key > array[mid]) {
                left = mid + 1;
                mid = (right + left) / 2;
            }
            if(key < array[mid]) {
                right = mid - 1;
                mid = (right + left) / 2;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int key = 7;
        int n = binarySearch(array,key);
        System.out.println(n);
    }
}
