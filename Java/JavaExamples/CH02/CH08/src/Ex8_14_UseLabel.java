import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Ex8_14_UseLabel {
	public static void main(String[] args) {
		JFrame frm = new JFrame("��ʾ��ͼ��ı�ǩ");
		frm.setLayout(null);// ����Ϊ��ʹ�ò��ֹ�����

		// ������ǩ���,����λ�ü���С����ʾ���塢����ͼƬ
		JLabel label = new JLabel("��ʾ22�Ŵ�����");
		label.setBounds(5, 5, 220, 100);
		label.setFont(new Font("", Font.BOLD, 22));
		label.setIcon(new ImageIcon("label.jpg"));
		// �������������
		label.setHorizontalAlignment(JLabel.LEFT);

		// ���ñ�ǩ���ͼƬ��λ��,�ڸ�JDK�߰汾���������µľ�̬����
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		frm.add(label);
		frm.setBounds(450, 200, 230, 130);
		frm.setVisible(true);
	}
}