import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
class Ex11_6_ScoreClient extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Panel p1, p2, p3, p4, p5;
	Label l1, l2, l3, id, mz, bj, yw, sx, yy, lz, did, jg;
	TextField t1, t2, t3, id1, mz1, bj1, yw1, sx1, yy1, lz1, did1;
	TextArea ta1;
	Button b, b1, b2, b3, b4, b5, add, del, search, xg, add1, del1, xg1;
	Frame f, f1, f2, cz;
	Socket s1;
	PrintWriter printWriter = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	Ex11_6_ScoreClient() {
		f = new Frame();
		f.setBounds(100, 300, 400, 400);
		f.setLayout(new GridLayout(2, 1));
		p1 = new Panel();
		p3 = new Panel();
		f.add(p1);
		f.add(p3);
		p1.setLayout(new FlowLayout());
		l2 = new Label("学号");
		t2 = new TextField("", 10);
		b = new Button("查询");
		b2 = new Button("管理信息");
		p1.add(l2);
		p1.add(t2);
		p1.add(b);
		p1.add(b2);
		p3.setLayout(new FlowLayout());
		ta1 = new TextArea(30, 50);
		p3.add(ta1);
		b.addActionListener(this);
		b2.addActionListener(this);
		f.setVisible(false);
		f.addWindowListener(new Close());
		f1 = new Frame();
		f1.setBounds(100, 300, 200, 100);
		f1.setLayout(new GridLayout(4, 1));
		l3 = new Label("密码");
		t3 = new TextField("", 10);
		t3.setEchoChar('*');
		b3 = new Button("登录");
		b4 = new Button("返回查询页面");
		b3.addActionListener(this);
		b4.addActionListener(this);
		f1.add(l3);
		f1.add(t3);
		f1.add(b3);
		f1.add(b4);
		f1.setVisible(false);
		f1.addWindowListener(new Close());
		cz = new Frame();
		cz.setBounds(100, 300, 200, 100);
		cz.setLayout(new GridLayout(3, 1));
		add1 = new Button("增加信息");
		del1 = new Button("删除信息");
		xg1 = new Button("修改信息");
		b4 = new Button("返回查询页面");
		cz.add(add1);
		cz.add(del1);
		cz.add(xg1);
		cz.add(b4);
		add1.addActionListener(this);
		del1.addActionListener(this);
		xg1.addActionListener(this);
		b4.addActionListener(this);
		cz.setVisible(false);
		cz.addWindowListener(new Close());
		f2 = new Frame();
		f2.setBounds(100, 300, 200, 500);
		f2.setLayout(new GridLayout());
		jg = new Label("");
		b4 = new Button("返回管理页面");
		b5 = new Button("返回管理页面");
		p1 = new Panel();
		p2 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		f2.add(p1);
		f2.add(p2);
		f2.add(jg);
		f2.add(b4);
		id = new Label("学号");
		id1 = new TextField("", 10);
		mz = new Label("名字");
		mz1 = new TextField("", 10);
		bj = new Label("班级");
		bj1 = new TextField("", 10);
		yw = new Label("语文");
		yw1 = new TextField("", 10);
		sx = new Label("数学");
		sx1 = new TextField("", 10);
		yy = new Label("英语");
		yy1 = new TextField("", 10);
		lz = new Label("科学");
		lz1 = new TextField("", 10);
		add = new Button("添加");
		xg = new Button("确认修改");
		xg.setVisible(false);
		p1.add(mz);
		p1.add(mz1);
		p1.add(id);
		p1.add(id1);
		p1.add(bj);
		p1.add(bj1);
		p1.add(id);
		p1.add(id1);
		p1.add(yw);
		p1.add(yw1);
		p1.add(sx);
		p1.add(sx1);
		p1.add(yy);
		p1.add(yy1);
		p1.add(lz);
		p1.add(lz1);
		p1.add(add);
		p1.add(b4);
		p1.add(xg);
		did = new Label("学号");
		did1 = new TextField("", 10);
		del = new Button("删除");
		p2.add(did);
		p2.add(did1);
		p2.add(del);
		p2.add(jg);
		p2.add(b5);
		add.addActionListener(this);
		del.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		p1.setVisible(false);
		p2.setVisible(false);
		add.addActionListener(this);
		del.addActionListener(this);
		xg.addActionListener(this);
		f2.setVisible(false);
		f2.addWindowListener(new Close());
	}
	public void connection(String IP) {
		try {
			String accountnum1 = JOptionPane.showInputDialog(null, "请输入ip地址",
					"选择", JOptionPane.PLAIN_MESSAGE);
			if (accountnum1 == null)
				System.exit(0);
			;
			s1 = new Socket(accountnum1, 5432);
			sendMessage("connect:");
			MyThread my = new MyThread();
			my.start();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "连接出错!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "连接出错!");
			connection("");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "连接") {
			connection(t1.getText());
			sendMessage("connect:");
			MyThread my = new MyThread();
			my.start();
		}
		if (e.getActionCommand() == "查询") {
			ta1.setText("");
			if (t2.getText().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "请输入学号!");
			else {
				sendMessage("search" + ":" + t2.getText());
				MyThread my = new MyThread();
				my.start();
			}
		}
		if (e.getActionCommand() == "管理信息") {
			t3.setText("");
			f.setVisible(false);
			f1.setVisible(true);
		}
		if (e.getActionCommand() == "登录") {
			if (t3.getText().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "请输入密码!");
			else {
				sendMessage("login:" + t3.getText());
				MyThread my = new MyThread();
				my.start();
			}
		}
		if (e.getActionCommand() == "增加信息") {
			cz.setVisible(false);
			f2.setVisible(true);
			p1.setVisible(true);
			p2.setVisible(false);
			add.setVisible(true);
			xg.setVisible(false);
		}
		if (e.getActionCommand() == "删除信息") {
			cz.setVisible(false);
			f2.setVisible(true);
			p1.setVisible(false);
			p2.setVisible(true);
		}
		if (e.getActionCommand() == "修改信息") {
			cz.setVisible(false);
			f2.setVisible(true);
			p1.setVisible(true);
			p2.setVisible(false);
			add.setVisible(false);
			xg.setVisible(true);
		}
		if (e.getActionCommand() == "添加") {
			if (id1.getText().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "请输入密码!");
			else {

				sendMessage("add" + ":" + id1.getText() + ":" + mz1.getText()
						+ ":" + bj1.getText() + ":" + yw1.getText() + ":"
						+ sx1.getText() + ":" + yy1.getText() + ":"
						+ lz1.getText());
				MyThread my = new MyThread();
				my.start();
			}
		}
		if (e.getActionCommand() == "删除") {
			if (did1.getText().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "请输入学号!");
			else {
				sendMessage("del" + ":" + did1.getText());
				MyThread my = new MyThread();
				my.start();
			}
		}
		if (e.getActionCommand() == "确认修改") {
			if (id1.getText().equalsIgnoreCase(""))
				JOptionPane.showMessageDialog(null, "请输入学号!");
			else {
				sendMessage("xg" + ":" + id1.getText() + ":" + mz1.getText()
						+ ":" + bj1.getText() + ":" + yw1.getText() + ":"
						+ sx1.getText() + ":" + yy1.getText() + ":"
						+ lz1.getText());
				MyThread my = new MyThread();
				my.start();
			}
		}
		if (e.getActionCommand() == "返回查询页面") {
			f.setVisible(true);
			f1.setVisible(false);
			cz.setVisible(false);
			f2.setVisible(false);
		}
		if (e.getActionCommand() == "返回管理页面") {
			f2.setVisible(false);
			cz.setVisible(true);
		}
	}
	class Close extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			sendMessage("exit");
			System.exit(0);
			f.setVisible(false);
		}
	}
	public void show(String str) {
	}
	public void sendMessage(String str) {
		try {
			printWriter = new PrintWriter(s1.getOutputStream(), true);
			printWriter.println(str);
			printWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	class MyThread extends Thread {
		public void run() {
			System.out.print("客服端开始接收数据：");
			for (;;) {
				try {
					isr = new InputStreamReader(s1.getInputStream());
					br = new BufferedReader(isr);
					String str = br.readLine();
					if (str.equalsIgnoreCase("connect")) {
						JOptionPane.showMessageDialog(null, "连接成功!");
						f.setVisible(true);
						break;
					}
					if (str.equalsIgnoreCase("loginsuccess")) {
						f1.setVisible(false);
						cz.setVisible(true);
						break;
					}
					if (str.equalsIgnoreCase("over"))
						break;
					if (str.equalsIgnoreCase("passwordwrong")) {
						JOptionPane.showMessageDialog(null, "密码错误!");
						break;
					}
					if (str.equalsIgnoreCase("unmodify")) {
						JOptionPane.showMessageDialog(null, "查无此人 请重新输入正确ID!");
						break;
					}
					if (str.equalsIgnoreCase("modify")) {
						JOptionPane.showMessageDialog(null, "修改成功！");
						break;
					}
					if (str.equalsIgnoreCase("success")) {
						JOptionPane.showMessageDialog(null, "操作成功！");
						break;
					}
					if (str.equalsIgnoreCase("have")) {
						JOptionPane.showMessageDialog(null, "你输入的学号已经存在！");
						break;
					}
					ta1.append(str);
					ta1.append("\n");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} catch (IOException e) {
				}
			}
		}
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public static void main(String[] args) {
		Ex11_6_ScoreClient m = new Ex11_6_ScoreClient();
		m.connection("IP");
	}
}
