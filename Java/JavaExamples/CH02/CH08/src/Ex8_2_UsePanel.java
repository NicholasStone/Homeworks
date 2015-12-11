import javax.swing.*;
import java.awt.*;

public class Ex8_2_UsePanel {
	public static void main(String[] args) {
		// �������岢���ô������
		JFrame frm = new JFrame("ʹ��JPanel");
		// ���ô���رշ�ʽ
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ������岢���ڴ����ϰ벿��
		JPanel topPanel = new JPanel();
		frm.add(topPanel, BorderLayout.NORTH);

		// ������ʾ��ǩ��������ʾ��Ϣ
		JLabel show = new JLabel();
		show.setText("����������:");

		// ���������,����Ϊ�ɱ༭,�������,20��
		JTextField input = new JTextField();
		input.setEditable(true);
		input.setHorizontalAlignment(SwingConstants.LEFT);
		input.setColumns(20);

		// �����ύ��ť
		JButton myBtn = new JButton("�ύ");

		// �����ʾ��ǩ�������Ͱ�ť
		topPanel.add(show);
		topPanel.add(input);
		topPanel.add(myBtn);

		// ������岢���ڴ����°벿��
		JPanel bottomPanel = new JPanel();
		frm.add(bottomPanel, BorderLayout.CENTER);

		// ������ʾ��ǩ��������ʾ��Ϣ
		JLabel againshow = new JLabel();
		againshow.setText("��ʾ�������������:");
		// ���������,5��32��,���ɱ༭
		JTextArea output = new JTextArea();
		output.setRows(5);
		output.setColumns(32);
		output.setEditable(false);

		// �����ʾ��ǩ�������
		bottomPanel.add(againshow);
		bottomPanel.add(output);

		// ���ô���λ�����С����ʾ
		frm.setBounds(400, 200, 400, 200);
		frm.setVisible(true);
	}
}
