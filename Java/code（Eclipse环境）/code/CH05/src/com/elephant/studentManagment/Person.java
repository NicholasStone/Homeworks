package com.elephant.studentManagment;

import javax.swing.*;

public class Person {
	private String name;
	private String gender;
	private String address;
	private String phone;

	public void setData() {
		name = JOptionPane.showInputDialog(null, "����������");
		address = JOptionPane.showInputDialog(null, "�������ַ");
		gender = JOptionPane.showInputDialog(null, "�������Ա�");
		phone = JOptionPane.showInputDialog(null, "��������ϵ�绰");
	}

	public void display() {
		System.out.println("����:" + name + "\t�Ա� ��" + gender + "\t��ַ ��"
				+ address + "\t��ϵ�绰�� " + phone);
	}
}
