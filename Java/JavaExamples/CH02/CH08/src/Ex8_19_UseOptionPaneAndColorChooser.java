import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex8_19_UseOptionPaneAndColorChooser {
	public static void main(String[] args) {
		final JFrame frm = new JFrame("ʹ�����ֱ�׼�Ի���");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);// ����Ϊ��ʹ�ò��ֹ�����

		String str = JOptionPane.showInputDialog(frm, "��ã���������Ի��������룺",
				"����Ի���", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(frm, "��������ǣ�" + str, "��Ϣ�Ի���",
				JOptionPane.PLAIN_MESSAGE);
		int t = JOptionPane.showConfirmDialog(frm, "��ѡ����˳���ѡ����ɫ��", "ȷ�϶Ի���",
				JOptionPane.YES_NO_OPTION);
		Color c;
		if (t == JOptionPane.NO_OPTION)
			c = JColorChooser.showDialog(frm, "��ɫѡ��Ի���", Color.blue);
		else
			JOptionPane.showMessageDialog(frm, "δ��ʾ��ɫѡ��Ի���", "��Ϣ�Ի���",
					JOptionPane.WARNING_MESSAGE);

		frm.setBounds(400, 200, 450, 300);
		frm.setVisible(true);
	}
}
