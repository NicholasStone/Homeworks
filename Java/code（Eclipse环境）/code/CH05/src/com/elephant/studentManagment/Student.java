package com.elephant.studentManagment;
import javax.swing.*;
public class Student extends Person {
	private String id;
	private String major;
	private double gpa;

	public void setData() {
		String temp;
		super.setData();
		id = JOptionPane.showInputDialog(null, "������ѧ��");
		major = JOptionPane.showInputDialog(null, "������רҵ");
		while (true) {
			try {

				temp = JOptionPane.showInputDialog(null, "������ѧ��");
				gpa = Double.parseDouble(temp);
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "������Ϸ���ѧ��");
			}
		}
	}

	public void display() {
		super.display();
		System.out.println("\tרҵ: " + major + " \tѧ��: " + gpa);
	}

	public String getMajor() {
		return major;
	}

	public double getGpa() {
		return gpa;
	}
}
