public class TestOne {
    public static void main(String[] args) {
        Car[] cars = new Car[10];
        cars[0] = new Car("张一","1231","奔驰","白",21);
        cars[1] = new Car("张二","1232","奔驰","白",22);
        cars[2] = new Car("张三","1233","奔驰","白",23);
        cars[3] = new Car("张四","1234","奔驰","白",24);
        cars[4] = new Car("张五","1235","奔驰","白",25);
        cars[5] = new Car("张六","1236","奔驰","白",26);
        cars[6] = new Car("张七","1237","奔驰","白",27);
        cars[7] = new Car("张八","1238","奔驰","白",28);
        cars[8] = new Car("张九","1239","奔驰","白",29);
        cars[9] = new Car("张十","123x","奔驰","白",230);

        Fleet fleet = new Fleet("飞扬车队","奔驰",cars);
        fleet.showInformation();

    }

}
