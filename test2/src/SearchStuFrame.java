import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStuFrame extends JFrame implements ActionListener {

    JLabel numLabel,nameLabel,sexLabel;//标签
    JTextField numText,nameText;//文本框
    JComboBox sexBox;//下拉框
    JButton findBt,quitBt;//两个按钮，添加，删除。

    public SearchStuFrame() {

        this.setSize(600,500);
        this.setTitle("查找学生记录");
        this.init();
        this.setVisible(true);

    }


    private void init() {

        this.setLayout(null);

        numLabel = new JLabel("学号");
        numLabel.setSize(90,40);
        numLabel.setLocation(100,80);
        this.add(numLabel);

        numText = new JTextField();
        numText.setSize(180,40);
        numText.setLocation(250,80);
        this.add(numText);

        nameLabel = new JLabel("名字");
        nameLabel.setSize(90,40);
        nameLabel.setLocation(100,160);
        this.add(nameLabel);

        nameText = new JTextField();
        nameText.setSize(180,40);
        nameText.setLocation(250,160);
        this.add(nameText);

        sexBox = new JComboBox();
        sexBox.addItem("nv");
        sexBox.addItem("nan");
        sexBox.setSize(180,40);
        sexBox.setLocation(170,240);
        this.add(sexBox);

        quitBt = new JButton("tuichu");
        quitBt.setSize(90,40);
        quitBt.setLocation(100,340);
        this.add(quitBt);

        findBt = new JButton("chaxun");
        findBt.setSize(90,40);
        findBt.setLocation(300,340);
        this.add(findBt);

        quitBt.addActionListener(this);
        findBt.addActionListener(this);


    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton bt=(JButton)e.getSource();
        if(bt.getText().equals("查询"))
        {
            //创建一个teacher对象来调用添加学生的方法

        }
        else
        {
            System.exit(0);
            //退出应用程序的标准写法
        }

    }
}
