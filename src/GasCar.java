public class GasCar extends Car {
    public  GasCar(String carName,String carNum) {
        super(carName,carNum);
    }
    @Override
    public void addEnergy() {
        System.out.println(getCarName() + "加柴油");
    }
}
