public class EleCar extends Car{
    public  EleCar(String carName,String carNum) {
        super(carName,carNum);
    }
    @Override
    public void addEnergy() {
        System.out.println(getCarName() + "加电");
    }
}
