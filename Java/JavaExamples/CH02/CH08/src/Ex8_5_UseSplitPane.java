import javax.swing.*;

public class Ex8_5_UseSplitPane {
	public static void main(String[] args) {
		// �������塢���ô������ʹ���رշ�ʽ
		JFrame frm = new JFrame();
		frm.setTitle("ʹ��JSplitPane");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����ˮƽ�ָ����
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		frm.add(splitPane);

		// ���������,����Ϊ�ɱ༭,�������,20��,����ӵ��������
		JTextArea input = new JTextArea();
		input.setEditable(true);
		input.setRows(5);
		input.setColumns(25);
		input.setText("�������м�ֽ���,\n\r�۲촰�ڱ仯,\n\r������϶��ַ���");
		splitPane.setLeftComponent(input);

		// �����ύ��ť����ӵ������Ҳ�
		JButton submitBtn = new JButton("�ύ");
		splitPane.setRightComponent(submitBtn);

		// ���÷ָ����,���Ϊ140�����ؿ�
		splitPane.setDividerLocation(140);

		// ���ýṹ(JFrame)��λ�����С����ʾ
		frm.setBounds(450, 230, 400, 200);
		frm.setVisible(true);
	}
}
