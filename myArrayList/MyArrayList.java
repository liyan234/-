package myArrayList;

public class MyArrayList {

    private int[] array = new int[20];
    private int size = 0;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //尾插
    public boolean add (int num) {
        //size 从0开始计数  size等于19的时候 array.length已经等于20了
        if (this.size >= array.length - 1) {
            return false;
        }
        array[size] = num;
        size++;
        return true;
    }

    //在指定位置插入 一个数
    public void add (int index, int num) {
        if (this.size >= array.length - 1) {
            return;
        }

        if (index >= array.length - 1) {
            return;
        }

        if (index >= size) {
            array[size] = num;
            size++;
            return;
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = num;
        size++;
    }

    //移除一个数
    public int removeNum(int x) {
        for (int i = 0; i <= size; i++) {
            if (array[i] == x) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j+1];
                }
                size--;
                return x;
            }
        }
        return -1;
    }

    //移除某个位置上的数
    public boolean remove(int index) {
        if (index > size) {
            return false;
        }
        if (index == size) {
            array[size] = 0;
            size--;
            return true;
        }

        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return true;
    }

    //获取 index下标下的数
    public int get(int index) {
        if (index > size || index < 0) {
            return -1;
        }
        return array[index];
    }

    //将index下标位置的数设为element
    public int set (int index, int element) {
        if (index < 0 || index > size) {
            return -1;
        }
        array[index] = element;
        return array[index];
    }

    // 包含某个数
    public boolean contains(int x) {
        for (int i = 0; i < size; i++) {
            if (array[i] == x) {
                return true;
            }
        }
        return false;
    }

    // 返回找到的第一个数的下标
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i + 1;
            }
        }
        return -1;
    }

    // 返回最后一个这个数的下标
    public int lastIndexOf(int element) {
        for (int i = size -1; i > 0 ; i--) {
            if ( array[i] == element) {
                return i+1;
            }
        }
        return -1;
    }

    //清空
    public void clear () {
        size = 0;
    }

    // 获取长度
    public int length() {
        return size;
    }


}
