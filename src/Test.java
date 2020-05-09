public class Test {
    public static void main(String[] args) {
        //可以用继承抽象类的非抽象子类来实例化抽象类的对象
       // Animal animal = new Animal("山羊,",4);
        /*Animal animal1 = new Dog("藏獒",4);

        Traffic traffic = new Plane("歼十二",12);
        traffic.run();
        Traffic traffic1 = new Ship("船",25);
        traffic1.run();*/

        Car car = new OilCar("路虎","11111");
        car.addEnergy();
        System.out.println(car.getCarNum());
        Car car1 = new GasCar("宝马","22222");
        car1.addEnergy();
        System.out.println(car1.getCarNum());
        Car car2 = new WaterCar("奔驰","33333");
        car2.addEnergy();
        System.out.println(car2.getCarNum());
        Car car3 = new EleCar("奥迪","44444");
        car3.addEnergy();
        System.out.println(car3.getCarNum());

        NewCar car4 = new WaterOilCar("凯迪拉克","55555");
        System.out.println(car4.getCarNum());

    }
}

