public class WaterCar extends Car {
    public  WaterCar(String carName,String carNum) {
        super(carName,carNum);
    }
    @Override
    public void addEnergy() {
        System.out.println(getCarName() + "加水");
    }
}
