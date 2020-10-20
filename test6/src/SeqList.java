
import java.util.Arrays;

public class SeqList {
    private String[] elem;
    private int userSize;

    public static final int DEFAULT_SIZE = 10;

    public SeqList() {
        this.elem = new String[DEFAULT_SIZE];
        this.userSize = 0;
    }

    public String[] getElem() {
        return elem;
    }

    public void setElem(String[] elem) {
        this.elem = elem;
    }

    public int getUserSize() {
        return userSize;
    }

    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

    //打印顺序表
    public void disPlay() {
        for (int i = 0; i < this.userSize; i++) {
            System.out.print( " " + this.elem[i] + " ");
        }
        System.out.println();
    }

    //添加元素
    public void add (int pos,String data) {
        if(isFull()) {
            //throw new RuntimeException("顺序表已满");
            this.elem = Arrays.copyOf(this.elem, (int) (this.elem.length * 1.5));
        }
        if(pos < 0 || pos > this.userSize) {
            System.out.println("添加的位置不合适");
            return;
        }
        if(pos == 0) {
            this.elem[pos] = data;
            this.userSize++;
            return;
        }
        for (int i = this.userSize - 1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.userSize++;
    }

    //查找元素的对应下标
    public int check(String data) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        for (int i = 0; i < this.userSize; i++) {
            if(data == this.elem[i]) {
                return i ;
            }
        }
        return -1;//代表顺序表中没有这个元素
    }
    //判定是否包含这个元素
    public boolean contain(String data) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        for (int i = 0; i < this.userSize; i++) {
            if(data == this.elem[i]) {
                return true ;
            }
        }
        return false;//代表顺序表中没有这个元素
    }

    //获取pos位置的元素
    public String getPos(int pos) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        if(pos < 0 || pos > this.userSize) {
            System.out.println("输入pos不合法");
            return null;
        }
        return this.elem[pos];
    }
    ////给pos位置的元素设为value
    public void changePos(int pos,String value) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        if(pos < 0 || pos > this.userSize) {
            System.out.println("输入pos值不对");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void delKey( String key) {
        if(isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        for (int i = 0; i < this.userSize; i++) {
            if(key == this.elem[i]) {
                for (int j = i; j <= this.userSize ; j++) {
                    this.elem[j] = this.elem[j+1];
                }
                this.userSize = this.userSize-1;
                return;
            }
        }
        System.out.println("顺序表中没有这个key");
    }
    ////获取顺序表长度
    public int size() {
        return this.userSize;
    }

    private boolean isEmpty(){
        if(this.userSize == 0) {
            return true;
        }
        return false;
    }
    private boolean isFull(){
        if(this.userSize ==this.elem.length) {
            return true;
        }
        return false;
    }
}
