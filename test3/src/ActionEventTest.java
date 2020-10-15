import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventTest extends JFrame implements ActionListener {

    private JButton redBt,blueBt,greenBt;

    private JTextField whiteText;

    public ActionEventTest() {

        this.setSize(300,300);
        this.setTitle("事件");
        this.setLayout(null);

        redBt = new JButton("red");
        redBt.setSize(20,20);
        redBt.setLocation(20,20);
        this.add(redBt);

        greenBt = new JButton("green");
        greenBt.setSize(20,20);
        greenBt.setLocation(50,20);
        this.add(greenBt);

        blueBt = new JButton("blue");
        blueBt.setSize(20,20);
        blueBt.setLocation(80,20);
        this.add(blueBt);

        whiteText = new JTextField("white");
        whiteText.setSize(20,20);
        whiteText.setLocation(110,20);
        this.add(whiteText);

        redBt.addActionListener(this);//this代表当前对象的引用
        blueBt.addActionListener(this);//将其引用到下面的方法中
        greenBt.addActionListener(this);
        whiteText.addActionListener(this);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //获取事件源，得到这个类并且将其转化成字符串，看字符串中是否包含JButton
        if(e.getSource().getClass().toString().contains("JButton")) {
            JButton jButton = (JButton)e.getSource();//获取事件源并且强制转换

            if(jButton.getText().equals("red")) {
                this.getContentPane().setBackground(Color.red);
            }

            if(jButton.getText().equals("green")) {
                this.getContentPane().setBackground(Color.green);
            }

            if(jButton.getText().equals("blue")) {
                this.getContentPane().setBackground(Color.blue);
            }
        } else {
            //不包含，则为文本文档JTextFiled
            this.getContentPane().setBackground(Color.white);
        }

    }
}
