//package SocketCommunication;

import javax.swing.*;

import java.awt.*;

public class FormManagement {
	JFrame frm = null;
	JPanel bottomPanel = null;
	JPanel centerPanel = null;
	JTextField input = null;
	JButton send = null;
	JTextArea output = null;

	public void creatForm(String s) {
		this.frm = new JFrame(s);
		this.frm.setLayout(new BorderLayout());

		this.bottomPanel = new JPanel();
		this.bottomPanel.setVisible(true);
		this.frm.getContentPane().add(this.bottomPanel, BorderLayout.SOUTH);

		this.centerPanel = new JPanel();
		this.centerPanel.setVisible(true);
		this.frm.getContentPane().add(this.centerPanel, BorderLayout.CENTER);

		this.input = new JTextField();
		this.input.setEditable(true);
		this.input.setHorizontalAlignment(SwingConstants.LEFT);
		this.input.setColumns(25);
		this.bottomPanel.add(this.input); // 添加输入框;

		this.send = new JButton("发送");
		this.send.setBounds(0, 0, 40, 20);
		this.bottomPanel.add(this.send); // 发送按钮

		this.output = new JTextArea();
		this.output.setRows(6);
		this.output.setColumns(32);
		this.output.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.output.setEditable(false);
		this.centerPanel.add(this.output);

		this.frm.setBounds(400, 200, 400, 200);
		this.frm.setVisible(true);
	}
}
