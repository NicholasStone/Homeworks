import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Ex8_21_StudentScore {
	public static void main(String[] args) {
		LoginDialog dlg = new LoginDialog();
		dlg.setVisible(true);
	}
}

class MainWindow extends JFrame { // ��������
	static JLabel submit;// ����¼��ɼ���ǩ

	MainWindow() {
		setTitle("ѧ���ɼ�¼��ϵͳ");
		setBounds(400, 200, 200, 120);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);// ����Ϊ��ʹ�ò��ֹ�����
		createMenu();
		submit = new JLabel();
		submit.setBounds(5, 5, 400, 20);
		add(submit);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitSystem();
			}
		});
	}

	void exitSystem() // �����˳�ϵͳ�¼�
	{
		int ret = JOptionPane.showConfirmDialog(this, "�˳�ϵͳ��", "�˳�ϵͳ��",
				JOptionPane.YES_NO_OPTION);
		if (ret == JOptionPane.YES_OPTION) {
			// dispose(); //�����˳���¼�Ի������޸ĵ�¼�Ի����е�login()������
			System.exit(0);
		}
	}

	void createMenu() {
		// �����˵�������ӵ����嶥��
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);

		// ����2������ʽ�˵�,����ӵ��˵���
		JMenu m1 = new JMenu("ϵͳ����");
		JMenu m2 = new JMenu("�ɼ�����");
		mbar.add(m1);
		mbar.add(m2);

		// �����˵���,����ӵ���Ӧ�Ĳ˵���
		JMenuItem mi11 = new JMenuItem("������Ϣ����");
		JMenuItem mi12 = new JMenuItem("�޸�����");
		JMenuItem mi13 = new JMenuItem("�˳�ϵͳ");
		mi11.setEnabled(false);
		mi12.setEnabled(false);
		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		// Ϊ�˳�ϵͳ�˵�������¼�
		mi13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitSystem();
			}
		});

		JMenuItem mi21 = new JMenuItem("�ɼ�¼��");
		JMenuItem mi22 = new JMenuItem("�ɼ���ѯ");
		mi22.setEnabled(false);
		m2.add(mi21);
		m2.add(mi22);
		// Ϊ�ɼ�¼��˵�������¼�
		mi21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inputScores();
			}
		});
	}

	void inputScores() {// ¼��ɼ�����
		InputScoresDialog isd = new InputScoresDialog();
		isd.setVisible(true);
	}

	static void setSubmit(String str) {
		submit.setText(str);
	}
}// class MainWindow

class InputScoresDialog extends JDialog {// ¼��ɼ��Ի�����
	JComboBox name;
	JTextField maths;
	JComboBox english;

	InputScoresDialog() {
		setTitle("�ɼ�¼��");
		setBounds(500, 250, 240, 180);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements();
	}

	void createGUIElements() {
		JLabel namelbl = new JLabel("����:");
		namelbl.setBounds(10, 20, 60, 25);
		add(namelbl);
		JLabel mathslbl = new JLabel("��ѧ:");
		mathslbl.setBounds(10, 50, 60, 25);
		add(mathslbl);
		JLabel englishlbl = new JLabel("Ӣ��:");
		englishlbl.setBounds(10, 80, 80, 25);
		add(englishlbl);
		name = new JComboBox();
		name.setBounds(100, 20, 120, 25);
		name.addItem("������");
		name.addItem("���ĵ�");
		add(name);
		maths = new JTextField();
		maths.setBounds(100, 50, 120, 25);
		maths.setText("100");
		add(maths);
		String[] ranks = { "����", "����", "�е�", "����", "������" };
		english = new JComboBox(ranks);
		english.setBounds(100, 80, 120, 25);
		add(english);

		JButton submitBtn = new JButton("�ύ");
		submitBtn.setBounds(20, 120, 80, 25);
		add(submitBtn);
		JButton cancelBtn = new JButton("����");
		cancelBtn.setBounds(130, 120, 80, 25);
		add(cancelBtn);

		// ���������е������������������
		for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
			Component comp = this.getContentPane().getComponent(i);
			comp.setFont(new Font("����", Font.BOLD, 20));
		}
		// ����ύ�ɼ��¼�
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String str = "����:" + name.getSelectedItem().toString() + ";��ѧ:"
						+ maths.getText() + ";Ӣ��:"
						+ english.getSelectedItem().toString();
				MainWindow.setSubmit(str);// ����������ľ�̬������ʾ,�˴��ɸ�Ϊ�������ݿ���
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();// �����ɼ�¼��Ի��򣬷���������
			}
		});
	}
}

class LoginDialog extends JDialog {// ��¼�Ի�����
	JLabel usernamelbl;
	JLabel passwordlbl;
	JComboBox username;
	JPasswordField password;
	JButton loginBtn;
	JButton cancelBtn;

	LoginDialog() {
		createGUIElements();
	}//

	void createGUIElements() {
		// ���õ�¼�Ի���,������λ�ü���С��ģ̬��
		setTitle("��¼ϵͳ");
		setBounds(500, 250, 200, 120);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setModal(true);
		// �����û����������ǩ
		usernamelbl = new JLabel("�û���:");
		usernamelbl.setBounds(20, 10, 50, 20);
		this.add(usernamelbl);
		passwordlbl = new JLabel("��  ��:");
		passwordlbl.setBounds(20, 32, 50, 20);
		this.add(passwordlbl);

		// �����û����������������,������ֵ
		username = new JComboBox();
		username.addItem("administrator");
		username.addItem("whitesun");
		username.setBounds(75, 10, 105, 20);
		this.add(username);
		password = new JPasswordField("123456");
		password.setBounds(75, 33, 105, 20);
		password.setEchoChar('*');
		this.add(password);

		// ������¼���˳���ť,������¼�
		loginBtn = new JButton("��¼");
		loginBtn.setBounds(25, 60, 60, 20);
		add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			} // ��������
		});
		cancelBtn = new JButton("�˳�");
		cancelBtn.setBounds(110, 60, 60, 20);
		add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
	}

	void login() // �����¼��ť�¼�
	{
		String accout = username.getSelectedItem().toString();
		String pwd = new String(password.getPassword());

		// ����û�����������ȷ,�����ص�¼�Ի���,��ʾ������
		if (accout.equals("administrator") && pwd.equals("123456")) {
			setVisible(false);// ֻ���ش���Ǳ�����⣬����dispose()��������
			showMianWindow();// ��ʾ������
		} else {
			JOptionPane.showMessageDialog(this, "�û�����" + accout + ",������" + pwd);
		}
	}

	void logout()// ����ȡ����ť�¼�
	{
		int ret = JOptionPane.showConfirmDialog(this, "ѡ���ǣ�ȡ����¼��", "ȡ����¼",
				JOptionPane.YES_NO_OPTION);
		if (ret == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	void showMianWindow() {// ��ʾ������
		MainWindow frm = new MainWindow();
		frm.setVisible(true);
	}
}// class LoginDialog 