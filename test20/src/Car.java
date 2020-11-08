public class Car {

    private String carMan;//车主
    private String carNum;//车牌号
    private String carName;//车名
    private String carColor;//车颜色
    private double carCost;//车价格(万元)

    public String getCarMan() {
        return carMan;
    }
    public void setCarMan(String carMan) {
        this.carMan = carMan;
    }

    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNum() {
        return carNum;
    }
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public double getCarCost() {
        return carCost;
    }
    public void setCarCost(double carCost) {
        this.carCost = carCost;
    }

    public Car(String carMan,String carNum,String carName,String carColor,double carCost) {
        setCarMan(carMan);
        setCarNum(carNum);
        setCarName(carName);
        setCarColor(carColor);
        setCarCost(carCost);
    }

    public Car() {
        carMan = "李";
        carNum = "123";
        carName = "奔驰";
        carColor = "白色";
        carCost = 23.9;
    }

    public void showInformation() {
        System.out.println("车主：" + this.getCarMan());
        System.out.println("车牌号：" + this.getCarColor());
        System.out.println("车名字：" + this.getCarName());
        System.out.println("车颜色：" + this.getCarColor());
        System.out.println("车价格：" + this.getCarCost());
    }
}
