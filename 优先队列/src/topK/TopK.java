package topK;

//寻找n个元素中前k大的数
//建立一个大小为k的堆，堆定元素就是这个k个元素中的最小值A，
//循环遍历n个元素中的每个元素，如果比守门员大，直接替换A。
//并且向下调整堆，得到新的A，当n个元素遍历完之后，
//堆中元素就是topK。
public class TopK {

    private int[] array;
    private int size = 0;

    public TopK(int k) {
        this.array = new int[k];
    }

    public void offer(int index) {

        if(this.size < array.length) {
            this.array[this.size] = index;
            this.size++;
            shiftUp();
        } else {
            compareShiftDown(index);
        }
    }

    public Integer poll() {
        if(this.size == 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[this.size - 1];
        this.size--;
        shiftDown();
        return ret;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void compareShiftDown(int index) {
        if(index <= this.array[0] ) {
            return;
        }
        this.array[0] = index;
        shiftDown();
    }

    private void shiftDown() {
        int parent = 0;
        int child = (parent * 2) + 1;
        while(child < this.size) {
            //和child比较的是当前数组的大小，所以用size，而不用length。

            if(child + 1 < this.size && this.array[child + 1] < this.array[child]) {
                child = child + 1;
            }
            if(this.array[child] < this.array[parent]) {
                int tmp = this.array[child];
                this.array[child] = this.array[parent];
                this.array[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = (parent * 2) + 1;

        }
    }

    private void shiftUp() {
        int child = this.size - 1;
        int parent = (child - 1) / 2;

        while(child > 0) {
            if(this.array[parent] > this.array[child]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

}
