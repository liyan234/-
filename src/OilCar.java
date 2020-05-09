public class OilCar extends Car{

    public  OilCar(String carName,String carNum) {
        super(carName,carNum);
    }
    @Override
    public void addEnergy() {
        System.out.println(getCarName() + "加汽油");
    }
}
