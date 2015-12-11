import java.awt.event.*;
import javax.swing.*;

public class Ex8_11_UseActionEvent {
	public static void main(String[] args) {
		JFrame frm = new JFrame("理解事件处理");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);

		// 创建按钮对象
		JButton btn = new JButton("请单击本按钮");
		btn.setBounds(120, 60, 120, 30);
		frm.add(btn);

		// 创建按钮的监听器,并注册,参数为事件处理者对象
		ButtonHandler btnHandler = new ButtonHandler();
		btn.addActionListener(btnHandler); // 与点击事件相关的授权处理的方法

		frm.setBounds(400, 200, 400, 200);
		frm.setVisible(true);
	}
}

// 编写按钮的事件处理者,即实现ActionListner接口
class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("单击一次按钮");
	}
}
