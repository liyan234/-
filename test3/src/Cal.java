import javax.swing.*;
import java.awt.*;

public class Cal extends JFrame {

    JTextField showText;//文本框
    JButton equalBt;

    JPanel leftPanel;
    JButton[] leftButtons;


    JPanel rightPanel;
    JButton[] rightButtons;


    //构造方法的实现
    public Cal () {
        this.setSize(400,700);//大小
        this.setTitle("计算器");//名字

        this.setLayout(null);//设置默认布局为空
        this.init();//窗口的实现

        this.setVisible(true);//窗口的可视化

    }

    private void init() {
        showText = new JTextField();//文本框的实现
        showText.setSize(375,100);
        showText.setLocation(5,10);
        //showText.setBackground(Color.red);
        this.add(showText);

        equalBt = new JButton("=");//按钮
        equalBt.setSize(94,179);
        equalBt.setLocation(287,471);
        equalBt.setBackground(Color.gray);//背景色
        this.add(equalBt);

        //分成两个区域，分别实现这两个区域
        initLeftPanel();
        initRightPanel();


    }


    private void initLeftPanel() {
        leftPanel = new JPanel();//新的区域

        leftPanel.setSize(280,540);//大小
        leftPanel.setLocation(5,110);//位置
        leftPanel.setLayout(new GridLayout(6,3,2,2));
        String[] leftName = {"mc","m+","m-","C","/","X","7","8","9","4","5","6","1","2","3","%","0","."};
        leftButtons = new JButton[18];

        for (int i = 0; i < leftButtons.length; i++) {
            leftButtons[i] = new JButton(leftName[i]);
            leftPanel.add(leftButtons[i]);//将按钮加入到这个区域中
        }
        this.add(leftPanel);//将创建的这个区域加入到这个窗口中
    }

    private void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setSize(93,360);
        rightPanel.setLocation(287,110);
        rightPanel.setLayout(new GridLayout(4,1,2,2));
        String[] rightName = {"mr","退格","-","+"};
        rightButtons = new JButton[4];
        for (int i = 0; i < rightButtons.length; i++) {
            rightButtons[i] = new JButton(rightName[i]);
            rightPanel.add(rightButtons[i]);
        }
        this.add(rightPanel);
    }

}
