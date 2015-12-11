import java.awt.BorderLayout;
import javax.swing.*;

public class Ex8_7_UseBorderLayout {

	public static void main(String[] args) {
		JFrame frm = new JFrame("ʹ�ñ߽粼�ֹ�����");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����ʹ�ñ߽粼�ֹ�����
		frm.setLayout(new BorderLayout());

		// ����5����ǩ,�����������ˮƽ��ʽ
		JLabel northLabel = new JLabel("��������(NORTH)");
		northLabel.setHorizontalAlignment(JLabel.HORIZONTAL);
		JLabel southLabel = new JLabel("�����ײ�(SOUTH)");
		southLabel.setHorizontalAlignment(JLabel.HORIZONTAL);
		JLabel westLabel = new JLabel("�������(WEST)");
		westLabel.setHorizontalAlignment(JLabel.HORIZONTAL);
		JLabel eastLabel = new JLabel("�����Ҳ�(EAST)");
		eastLabel.setHorizontalAlignment(JLabel.HORIZONTAL);
		JLabel centerLabel = new JLabel("��������(CENTER)");
		centerLabel.setHorizontalAlignment(JLabel.HORIZONTAL);

		// ������ǩ�����������Ӧλ��
		frm.add(northLabel, BorderLayout.NORTH);
		frm.add(southLabel, BorderLayout.SOUTH);
		frm.add(westLabel, BorderLayout.WEST);
		frm.add(eastLabel, BorderLayout.EAST);
		frm.add(centerLabel, BorderLayout.CENTER);

		frm.setBounds(450, 230, 400, 200);
		frm.setVisible(true);
	}
}
