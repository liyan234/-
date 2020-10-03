public class Swap {

    private int a ;
    private int b ;

    public Swap() {
    }

    public Swap(int a,int b) {
        setA(a);
        setB(b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void swap() {
        int temp = this.b;
        this.b = this.a;
        this.a = temp;
    }
}
