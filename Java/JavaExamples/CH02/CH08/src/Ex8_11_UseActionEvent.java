import java.awt.event.*;
import javax.swing.*;

public class Ex8_11_UseActionEvent {
	public static void main(String[] args) {
		JFrame frm = new JFrame("����¼�����");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);

		// ������ť����
		JButton btn = new JButton("�뵥������ť");
		btn.setBounds(120, 60, 120, 30);
		frm.add(btn);

		// ������ť�ļ�����,��ע��,����Ϊ�¼������߶���
		ButtonHandler btnHandler = new ButtonHandler();
		btn.addActionListener(btnHandler); // �����¼���ص���Ȩ����ķ���

		frm.setBounds(400, 200, 400, 200);
		frm.setVisible(true);
	}
}

// ��д��ť���¼�������,��ʵ��ActionListner�ӿ�
class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("����һ�ΰ�ť");
	}
}
