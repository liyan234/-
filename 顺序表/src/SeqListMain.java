public class SeqListMain {
    public static void main(String[] args) {
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.disPlay();
        //判定是否包含这个元素
        System.out.println(seqList.contains(2));
        System.out.println(seqList.contains(4));
        //查找元素的对应位置
        System.out.println(seqList.search(2));
        System.out.println(seqList.search(4));//顺序表中没有4
        //获取pos位置的元素
        System.out.println(seqList.getPos(1));
        //System.out.println(seqList.getPos(4));//4号位置不存在
        //给pos位置的元素设为value
        seqList.setPos(2,4);
        seqList.disPlay();
        //删除第一次出现的关键字key
        seqList.remove(1);
        seqList.disPlay();
        //获取顺序表长度
        System.out.println(seqList.size());
        //清空顺序表
        seqList.clear();
        seqList.disPlay();
    }
}
