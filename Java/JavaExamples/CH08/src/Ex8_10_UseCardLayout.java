import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex8_10_UseCardLayout {
	public static void main(String[] args) {
		JFrame frm = new JFrame("ʹ�ÿ�Ƭ���ֹ�����");
		// ������Ƭ���ֹ�������������
		CardLayout cardlayout = new CardLayout();
		frm.setLayout(cardlayout);

		// ����5���������ӵ�������
		JLabel label1 = new JLabel("Ӣ��");
		JLabel label2 = new JLabel("��ѧ");
		JLabel label3 = new JLabel("����");
		JLabel label4 = new JLabel("��ʷ");
		JLabel label5 = new JLabel("����");
		frm.add(label1, "�γ�1");
		frm.add(label2, "�γ�2");
		frm.add(label3, "�γ�3");
		frm.add(label4, "�γ�4");
		frm.add(label5, "�γ�5");

		// ��ʾָ���Ŀ�Ƭ����һ��ǰһ����һ�����һ�ſ�Ƭ,
		cardlayout.show(frm.getContentPane(), "�γ�4");
		// cardlayout.next(frm.getContentPane());
		// cardlayout.previous(frm.getContentPane());
		// cardlayout.first(frm.getContentPane());
		// cardlayout.last(frm.getContentPane());

		frm.setBounds(450, 230, 200, 100);
		frm.setVisible(true);
	}
}
