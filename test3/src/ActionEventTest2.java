import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventTest2 {

    public class ActionEventTest1 extends JFrame
    {
        private JButton redBt;
        private JButton greenBt;

        public ActionEventTest1()
        {
            this.setSize(300, 300);
            this.setTitle("动作事件实例");
            this.setLayout(null);

            redBt=new JButton("红色");
            redBt.setSize(60, 30);
            redBt.setLocation(30,30);
            this.add(redBt);

            greenBt=new JButton("绿色");
            greenBt.setSize(60, 30);
            greenBt.setLocation(120,30);
            this.add(greenBt);

            JButton blueBt = new JButton("蓝色");
            blueBt.setSize(60, 30);
            blueBt.setLocation(210,30);
            this.add(blueBt);

            //将动作事件的事件处理对象注册到事件源中
            ActionDeal deal=new ActionDeal(this);
            redBt.addActionListener(deal);
            greenBt.addActionListener(deal);
            blueBt.addActionListener(deal);

            this.setVisible(true);
        }
    }

    class ActionDeal implements ActionListener {
        private ActionEventTest1 window;
        public ActionDeal(ActionEventTest1 window) {
            this.window = window;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton) e.getSource();// 获取事件源并强制转换为按钮对象
            if (bt.getText().equals("红色")) {
                window.getContentPane().setBackground(Color.red);// 设置窗体的背景颜色为红色
            } else {
                if (bt.getText().equals("绿色")) {
                    window.getContentPane().setBackground(Color.green);// 设置窗体的背景颜色为红色
                } else {
                    window.getContentPane().setBackground(Color.blue);// 设置窗体的背景颜色为红色
                }
            }
        }
    }
}
