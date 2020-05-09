import com.sun.org.apache.bcel.internal.generic.NEW;

public class WaterOilCar extends NewCar implements WaterInf,OilInf {

    public WaterOilCar() {

    }

    public WaterOilCar(String carName,String carNum) {
        super(carName,carNum);
    }

    public void addWater() {
        System.out.println(getCarName() + "加水");
    }

    public void addOil() {
        System.out.println(getCarName() + "加汽油");
    }

}
