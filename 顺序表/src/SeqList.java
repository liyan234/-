import java.util.Arrays;

public class SeqList {
        public int[] elem;//null
        public int usedSize;//0

        //设置默认容量
        public static final int DEFAULT_SIZE = 3;

        //构造方法
        public SeqList() {
            this.elem = new int[DEFAULT_SIZE];
            this.usedSize = 0;
        }

        //顺序表扩容
        //当顺序表满了的时候就进行扩容
        private void grow() {
            //数组的拷贝，将长度增加了一倍
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }


        public void disPlay() {
            for (int i = 0; i < this.usedSize; i++) {
                System.out.print(" " + this.elem[i] );
            }
            System.out.println();
        }


        //在pos位置新增元素
        public void add(int pos,int data) {
            if(isFull()) {
                //数组扩容
                grow();
                /*System.out.println("顺序表满了");
                return;*/
            }
            if(pos < 0 || pos > this.usedSize) {
                /*System.out.println("pos位置不合法");
                return;*/
                throw new ArrayIndexOutOfBoundsException("pos位置不合法");
            }
            for (int i = this.usedSize - 1; i >= pos ; i--) {
                this.elem[i+1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.usedSize ++;
        }


        //判定是否包含这个元素
        public boolean contains(int toFind) {
            if(isEmpty()) {
                /*System.out.println("顺序表为空");
                return false;*/
                throw new RuntimeException("顺序表为空");
            }
            for (int i = 0; i < this.usedSize; i++) {
                if(toFind == this.elem[i]) {
                    return true;
                }
            }
            return false;
        }

        //查找元素的对应位置
        public int search(int toFind) {
            if(isEmpty()) {
                /*System.out.println("顺序表为空");
                return -1;*/
                throw new RuntimeException("顺序表为空");
            }
            for (int i = 0; i < this.usedSize; i++) {
                if(toFind == this.elem[i]) {
                    return i;
                }
            }
            return -1;
        }

        //获取pos位置的元素
         public int getPos(int pos) {
             if(isEmpty()) {
                 /*System.out.println("顺序表为空");
                 return -1;*/
                 throw new RuntimeException("顺序表为空");
             }
             checkPos(pos);
             return this.elem[pos];
         }

         //给pos位置的元素设为value
         public void setPos(int pos,int value) {
             if(isEmpty()) {
                 /*System.out.println("顺序表为空");
                 return;*/
                 throw new RuntimeException("顺序表为空");
             }
             checkPos(pos);
             this.elem[pos] = value;
         }

         //删除第一次出现的关键字key
         public void remove(int key) {
            //1，调用search看返回值 -1没有key 那木就删除不要了
             //2， 调换覆盖key关键字
             //3,size = size - 1
             if(isEmpty()) {
                  /*System.out.println("顺序表为空");
                 return;*/
                 throw new RuntimeException("顺序表为空");
             }
             if(search(key) == -1) {
                 System.out.println("没有关键字");
                 return;
             }
             for (int i = search(key); i < this.usedSize - 1 ; i++) {
                 this.elem[i] = this.elem[i+1];
             }
             this.usedSize = this.usedSize-1;
         }

         //获取顺序表长度
         public int size() {
            return this.usedSize;
         }
         //清空顺序表
         public void clear() {
            this.usedSize = 0;
         }


    //这几种方法只在类中使用 所以用private封装
        //顺序表是否为满
        private boolean isFull() {
            if(this.usedSize == this.elem.length) {
                return true;
            }
            return false;
        }
        //顺序表是否为空
        private boolean isEmpty() {
            if(this.usedSize == 0) {
                return true;
            }
            return false;
        }
        //检查pos的位置是否合法
        private void checkPos(int pos) {
            if(pos < 0 || pos > this.usedSize) {
                        /*System.out.println("pos位置不合法");
                        return;*/
                throw new ArrayIndexOutOfBoundsException("pos位置不合法");
            }
        }
}
