import javax.swing.*;

public class Ex8_4_ScrollWindow {
	public static void main(String[] args) {
		// �������塢���ô������ʹ���رշ�ʽ
		JFrame frm = new JFrame();
		frm.setTitle("���������Ĵ���");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����һ��5��32���ı���,������Ĭ������
		JTextArea ta = new JTextArea();
		ta.setRows(5);
		ta.setColumns(32);
		ta.setText("����һ��5��32�е��ı���,\n\r�����������Լ�������й۲�Ч��!");
		// ����һ����ť
		JButton btn = new JButton("��ť");

		// ����һ��������������,������ı���Ͱ�ť
		JPanel p = new JPanel();
		p.add(ta);
		p.add(btn);

		// �����������,���������洴�������Ϊ���
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(p);
		// �������������Ϊ������������
		frm.setContentPane(sp);

		frm.setBounds(450, 230, 300, 150);
		frm.setVisible(true);
	}
}