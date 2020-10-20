public class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    public static void main(String[] args) {
        A<String> a = new A<>("sbc");
        System.out.println(a.get());

        A<Integer> a1 = new A<>(1);
        System.out.println(a1.get());

        A<Character> a2 = new A<>('s');
        System.out.println(a2.get());

    }
}
