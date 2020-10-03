public class Main {

    /*public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.multi());
        System.out.println(calculator.division());
    }*/

    public static void main(String[] args) {//交换实参的值

        Swap swap2 = new Swap(40,60);
        System.out.println("a:" + swap2.getA() + "  b:" +swap2.getB());
        swap2.swap();
        System.out.println("a:" + swap2.getA() + "  b:" +swap2.getB());
    }
}
