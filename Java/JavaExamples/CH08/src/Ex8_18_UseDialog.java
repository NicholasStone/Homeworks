import javax.swing.*;
import java.awt.event.*;

public class Ex8_18_UseDialog {
	public static void main(String[] args) {
		final JFrame frm = new JFrame("使用普通对话框");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);// 设置为不使用布局管理器

		// 创建普通对话框,并设置位置及大小、模态等
		final JDialog dlg = new JDialog(frm, "普通对话框");
		dlg.setBounds(470, 220, 200, 150);
		dlg.setLayout(null);
		dlg.setModal(true);

		// 创建 窗体中打开对话框的按钮， 并添加动作监听器
		JButton obtn = new JButton("打开对话框");
		obtn.setBounds(60, 60, 100, 30);
		obtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(true);// 显示窗体
				// dlg.show(true);//show()不已推荐使用
			}
		});
		frm.add(obtn);

		// 创建对话框中的退出按钮，并添加动作监听器
		JButton btn = new JButton("退出");
		btn.setBounds(50, 50, 80, 30);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dlg.setVisible(false);// 隐藏窗体
			}
		});
		dlg.add(btn);

		frm.setBounds(450, 200, 250, 200);
		frm.setVisible(true);
	}
}
