import javax.swing.plaf.synth.SynthEditorPaneUI;

public class Fleet {
    private String name;
    private String leaderCar;
    private Car[] members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaderCar() {
        return leaderCar;
    }

    public void setLeaderCar(String leaderCar) {
        this.leaderCar = leaderCar;
    }

    public Car[] getMembers() {
        return members;
    }

    public void setMembers(Car[] members) {
        this.members = members;
    }

    public Fleet(String name,String leaderCar,Car[] members) {
        setName(name);
        setLeaderCar(leaderCar);
        setMembers(members);
    }

    public void showInformation() {
        System.out.println("领队：" + name);
        System.out.println("领车：" + leaderCar);
        System.out.print("成员：");
        for(int i = 0; i < members.length; i++) {
            System.out.print(" " + members[i].getCarMan());
        }
    }
}
