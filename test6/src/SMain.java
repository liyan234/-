public class SMain {

    public static void main(String[] args) {
        SeqList list = new SeqList();

        list.add(0,"aaa");
        list.add(1,"bbb");
        list.add(2,"ccc");
        list.add(3,"ddd");

        list.disPlay();

        System.out.println(list.check("e"));

        System.out.println(list.contain("ccc"));

        System.out.println(list.getPos(0));

        list.changePos(0,"fff");
        list.disPlay();

        list.delKey("bbb");
        list.disPlay();

    }


}
