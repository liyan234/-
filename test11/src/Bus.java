import java.util.ArrayList;

public class Bus {

    private String busNum;//车牌号
    private int gap;//发车间隔
    private String lineNum;//几路公交
    private String staTime;//首发车时间
    private String endTime;//末班车时间
    private Driver driver;//司机
    private Passage[] passages;//乘客
    private  int currentPassCount;//当前的载客数量

    private ArrayList<Passage> list = new ArrayList<Passage>();


    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getStaTime() {
        return staTime;
    }

    public void setStaTime(String staTime) {
        this.staTime = staTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passage[] getPassages() {
        return passages;
    }

    public void setPassages(Passage[] passages) {
        this.passages = passages;
    }

    public Bus(String busNum,String lineNum,int gap,String staTime,String endTime) {
        setBusNum(busNum);
        setLineNum(lineNum);
        setGap(gap);
        setStaTime(staTime);
        setEndTime(endTime);
        currentPassCount = 0;//开始没有乘客
        passages = new Passage[50];
    }
    ///公交车的行为
    //乘客上车的方法
    public void up(Passage[] upPassages) {
        if(upPassages != null) {
            if(upPassages.length != 0) {
                for (int i = 0; i < upPassages.length; i++) {
                    upAPassage(upPassages[i]);
                }
            }
        }
    }
    //一个乘客上车
    public  void upAPassage(Passage upPass) {


       // if(currentPassCount == 50) {
        if(this.list != null && this.list.size() == passages.length) {
            System.out.println(upPass.getName() + "无法上车，已经客满");
        } else {
            //for (int i = 0; i < passages.length; i++) {

                this.list.add(upPass);
                /*if(passages[i] == null) {
                    passages[i] = upPass;
                    break;//推出循环
                }*/
           // }
            System.out.println(upPass.getName() + "上车");
          //  currentPassCount++;
            System.out.println("当前乘客数量" + this.list.size());
        }
    }
//下车
    public void downPassages(Passage[] downPass) {
        if(downPass != null) {
            if(downPass.length != 0) {
                for (int i = 0; i < downPass.length; i++) {
                    downAPassage(downPass[i]);
                }
            }
        }
    }
    //一个乘客下车
    public void downAPassage(Passage passage) {

        if(this.list.size() > 0) {
            if(this.list.contains(passage)) {
                this.list.remove(passage);
                System.out.println(passage.getName() + "下车");
                System.out.println("当前乘客数量" + this.list.size());
            }
        }



     /*   if(currentPassCount > 0) {
            for (int i = 0; i < passages.length; i++) {
                if(passages[i] != null) {
                    if(passages[i].getName().equals(passage.getName())) {
                        passages[i] = null;
                        System.out.println(passage.getName() + "下车");
                        currentPassCount--;
                        System.out.println("当前乘客数量" + currentPassCount);
                    }
                }
            }
        }*/
    }
}
