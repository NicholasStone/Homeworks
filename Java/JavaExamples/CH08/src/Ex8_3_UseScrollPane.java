import java.awt.BorderLayout;
import javax.swing.*;

public class Ex8_3_UseScrollPane {
	public static void main(String[] args) {
		// �������塢���ô������ʹ���رշ�ʽ
		JFrame frm = new JFrame();
		frm.setTitle("ʹ��JScrollPane");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����3�������,��Ϊ2��32��,������Ĭ������
		JTextArea toutput = new JTextArea();
		toutput.setRows(2);
		toutput.setColumns(32);
		toutput.setText("����JScrollPaneʹ��ʾ��!\n\r ����һ������϶��ַ��۲���ʾ���ı仯!");

		JTextArea coutput = new JTextArea();
		coutput.setRows(2);
		coutput.setColumns(32);
		coutput.setText("����JScrollPaneʹ��ʾ��!\n\r ����������ַ���һ������ַ��۲���ʾ���ı仯! ");

		JTextArea boutput = new JTextArea();
		boutput.setRows(2);
		boutput.setColumns(32);
		boutput.setText("����JScrollPaneʹ��ʾ��!\n\r ����������ַ��۲���ʾ���ı仯! ");

		// ����3���������
		JScrollPane toutputScrollPane = new JScrollPane();
		JScrollPane coutputScrollPane = new JScrollPane();
		JScrollPane boutputScrollPane = new JScrollPane();

		// Ϊÿ�����������Ӹ��Ե����
		toutputScrollPane.setViewportView(toutput);
		coutputScrollPane.setViewportView(coutput);
		boutputScrollPane.setViewportView(boutput);

		// Ϊÿ���������������ʾˮƽ�ʹ�ֱ����
		toutputScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		toutputScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		coutputScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		coutputScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		boutputScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		boutputScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// �ڴ��������3���������
		frm.add(toutputScrollPane, BorderLayout.NORTH);
		frm.add(coutputScrollPane, BorderLayout.CENTER);
		frm.add(boutputScrollPane, BorderLayout.SOUTH);

		// ���ýṹ(JFrame)��λ�����С����ʾ
		frm.setBounds(450, 230, 400, 180);
		frm.setVisible(true);
	}
}
