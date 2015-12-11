import javax.swing.*;
import java.awt.event.*;

public class Ex8_17_UseMenu {
	public static void main(String[] args) {
		final JFrame frm = new JFrame("ʹ�ò˵�");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);// ����Ϊ��ʹ�ò��ֹ�����

		// ������ʾ��ǩ������ʾ����˵��ı���
		final JLabel lbl = new JLabel("��ʾ�˵�����");
		lbl.setBounds(150, 100, 300, 30);
		frm.add(lbl);

		// �����˵�������ӵ����嶥��
		JMenuBar mbar = new JMenuBar();
		frm.setJMenuBar(mbar);

		// ����3������ʽ�˵�,����ӵ��˵���
		JMenu m1 = new JMenu("�û�����");
		JMenu m2 = new JMenu("�ɼ�����");
		JMenu m3 = new JMenu("ϵͳ״̬");
		mbar.add(m1);
		mbar.add(m2);
		mbar.add(m3);

		// �����˵���,����ӵ���Ӧ�Ĳ˵���
		JMenuItem mi11 = new JMenuItem("������Ϣ����");
		JMenuItem mi12 = new JMenuItem("�޸�����");
		// JMenuItem mi13=new JMenuItem("ϵͳ�˳�");
		m1.add(mi11);
		m1.add(mi12);
		m1.add("ϵͳ�˳�"); // ֱ����Ӳ˵���
		// ��ȡ��ֱ����ӵĲ˵���,��ע����궯��,����˵������
		final JMenuItem mi13 = m1.getItem(2);
		mi13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText(mi13.getText());
				mi13.setText("�˳�");
			}
		});

		JMenuItem mi21 = new JMenuItem("ѧ��������Ϣ¼��");
		JMenuItem mi22 = new JMenuItem("�ɼ�¼��");
		JMenuItem mi23 = new JMenuItem("�ɼ���ѯ");
		mi23.setEnabled(false);
		m2.add(mi21);
		m2.add(mi22);
		m2.add(mi23);

		// ��ѡ�˵������һ��
		ButtonGroup btnGroup = new ButtonGroup();
		JRadioButtonMenuItem mi31 = new JRadioButtonMenuItem("��ʾ����");
		JRadioButtonMenuItem mi32 = new JRadioButtonMenuItem("��ʾ¼�����");
		btnGroup.add(mi31);
		btnGroup.add(mi32);
		mi32.setSelected(true); // ���ñ�ѡ��
		JCheckBoxMenuItem mi33 = new JCheckBoxMenuItem("��ʾ״̬��");
		final JCheckBoxMenuItem mi34 = new JCheckBoxMenuItem("��ʾ��½��Ϣ");
		mi33.setSelected(true); // ���ñ�ѡ��
		m3.add(mi31);
		m3.add(mi32);
		m3.addSeparator();
		m3.add(mi33);
		m3.add(mi34);
		// m3.add(m1); //���Լ���m1������Ч��

		// ����1���µ���ʽ�˵�,��ע������¼�,���ҵ��������ʾ
		final JPopupMenu pm = new JPopupMenu("��ͼ");
		pm.add("����");
		pm.add("����");
		// pm.add(m2); //���Լ���m2������Ч��

		// Ϊ���һ���˵����������
		mi34.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText(mi34.getText());
			}
		});

		// Ϊ����ʽ�˵�������ʾλ��
		frm.addMouseListener(new MouseAdapter() {// �����������
			@Override
			public void mouseClicked(MouseEvent e) {
				int mods = e.getModifiers();
				if ((mods & InputEvent.BUTTON3_MASK) != 0)
					pm.show(frm, e.getX(), e.getY());
			}
		});

		frm.setBounds(400, 200, 450, 200);
		frm.setVisible(true);
	}
}
