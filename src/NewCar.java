public class NewCar {
    private String carName;
    private String carNum;

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

    public NewCar() {

    }

    public NewCar(String carName,String carNum) {
        setCarName(carName);
        setCarNum(carNum);
    }
}
