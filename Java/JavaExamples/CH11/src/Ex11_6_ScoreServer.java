import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.StringTokenizer;
public class Ex11_6_ScoreServer implements ActionListener {
	String id, name, level, chinese, math, english, science;
	ServerSocket s = null;
	Socket s1;
	PrintWriter printWriter = null;
	Label l;
	static Frame f;
	Ex11_6_ScoreServer() {
		f = new Frame();
		f.setBounds(100, 300, 400, 400);
		f.setLayout(new GridLayout(3, 1));
		l = new Label();
		f.add(l);
		f.addWindowListener(new Close());
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
	}
	public void Connection() {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			l.setText("服务器当前ip：" + ip);
		} catch (Exception e) {
		}
		try {
			s = new ServerSocket(5432);
			while (true) {
				s1 = s.accept();
				MyThread my1 = new MyThread();
				my1.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void del(String id) {
		try {
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\score.mdb";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from  score where id='" + id + "'");
			if (rs.next()) {
				sendMessage("success");
				stm.executeQuery("DELETE FROM score where id='" + id + "'");
			} else {
				sendMessage("unmodify");
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void add(String id, String name, String level, String chinese,
			String math, String english, String science) {
		try {
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\score.mdb";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from  score where id='"
					+ id + "'");
			if (rs.next()) {
				sendMessage("have");
				System.out.print("添加");
			} else {
				sendMessage("success");
				stm.executeQuery("insert into score values('" + id + "','"
						+ name + "','" + level + "','" + chinese + "','" + math
						+ "','" + english + "','" + science + "')");
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void modify(String id, String name, String level, String chinese,
			String math, String english, String science) {
		try {
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\score.mdb";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from  score where id='"
					+ id + "'");
			if (rs.next()) {
				sendMessage("modify");
				stm.executeQuery("Update  score set name='" + name
						+ "',class='" + level + "',chinese='" + chinese
						+ "',math='" + math + "',english='" + english
						+ "',science='" + science + "' where id='" + id + "'");
			} else {
				sendMessage("unmodify");
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception ex) {
			sendMessage("unmodify");
		}
	}
	public void login(String str) {
		try {
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\score.mdb";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("select * from  admin where password='" + str
							+ "'");
			if (rs.next()) {
				sendMessage("loginsuccess");
				System.out.print("loginsuccess");
			} else {
				System.out.print("密码错误！");
				sendMessage("password is wrong");
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void search(String str) {
		try {
			System.out.print("查找数据库" + str);
			//运行前，请修改数据库路径，或将score.mdb放在D盘根目录下。
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\score.mdb";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from  score where Id='"
					+ str + "'");
			if (rs.next()) {
				sendMessage("查询成功");
				sendMessage("学号：" + rs.getString(1));
				sendMessage("名字：" + rs.getString(2));
				sendMessage("班级：" + rs.getString(3));
				sendMessage("语文：" + rs.getString(4));
				sendMessage("数学：" + rs.getString(5));
				sendMessage("英语：" + rs.getString(6));
				sendMessage("科学：" + rs.getString(7));
			} else {
				sendMessage("没有该学生信息！");
			}
			sendMessage("over");
			rs.close();
			stm.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void sendMessage(String str) {
		try {
			printWriter = new PrintWriter(s1.getOutputStream(), true);
			printWriter.println(str);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Ex11_6_ScoreServer server = new Ex11_6_ScoreServer();
		server.Connection();
	}
	class MyThread extends Thread {
		OutputStream s1out;
		DataOutputStream dos;
		InputStreamReader isr;
		BufferedReader br;
		public void run() {
			try {
				isr = new InputStreamReader(s1.getInputStream());
				br = new BufferedReader(isr);
			} catch (Exception e) {
			}
			for (;;) {
				try {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (br.ready()) {
						String str = br.readLine();
						System.out.println(str);
						StringTokenizer strfo = new StringTokenizer(str, ":");
						String head = strfo.nextToken();
						if (strfo.hasMoreTokens())
							id = strfo.nextToken();
						if (strfo.hasMoreTokens())
							name = strfo.nextToken();
						if (strfo.hasMoreTokens())
							level = strfo.nextToken();
						if (strfo.hasMoreTokens())
							chinese = strfo.nextToken();
						if (strfo.hasMoreTokens())
							math = strfo.nextToken();
						if (strfo.hasMoreTokens())
							english = strfo.nextToken();
						if (strfo.hasMoreTokens())
							science = strfo.nextToken();
						System.out.println(head);
						if (head.equalsIgnoreCase("connect"))
							sendMessage("connect");
						if (head.equalsIgnoreCase("login")) {
							login(id);
						}
						if (head.equalsIgnoreCase("add"))
							add(id, name, level, chinese, math, english,
									science);
						if (head.equalsIgnoreCase("del"))
							del(id);
						if (head.equalsIgnoreCase("xg"))
							modify(id, name, level, chinese, math, english,
									science);
						if (head.equalsIgnoreCase("search"))
							search(id);
						if (head.equalsIgnoreCase("exit"))
							break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class Close extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			f.setVisible(false);
		}
	}
}