package com.elephant.studentManagment;

import javax.swing.*;

public class CollegeList {
	public static void main(String[] args) {

		CollegeEmployee[] emp = new CollegeEmployee[10];
		Student[] stu = new Student[20];
		int empCount = 0, facCount = 0, stuCount = 0;
		char letter;
		String input;
		int x;
		double maxAnnualSalary = 0, avGannualSalary = 0, tempAnnualSalary;
		double sumAnnualSalary = 0;
		double maxGpa = 0, avgGpa = 0, tempGpa, sumGpa = 0;
		input = JOptionPane.showInputDialog(null, "����C ¼��Ա����Ϣ" + "\n����S ¼��ѧ����Ϣ"
				+ "\n����Q �˳�");
		input = input.toUpperCase();
		letter = input.charAt(0);
		while (letter != 'Q') {
			if (letter == 'C') {
				if (empCount < emp.length) {
					CollegeEmployee c = new CollegeEmployee();
					c.setData();
					emp[empCount] = c;
					++empCount;

					// ����ƽ����н�������н
					tempAnnualSalary = c.getAnnualSalary();
					sumAnnualSalary = tempAnnualSalary + sumAnnualSalary;
					if (tempAnnualSalary > maxAnnualSalary)
						maxAnnualSalary = tempAnnualSalary;
				} else
					JOptionPane.showMessageDialog(null, "�Բ���¼��̫��Ա����Ϣ");
			} else if (letter == 'S') {
				if (stuCount < stu.length) {
					Student s = new Student();
					s.setData();
					stu[stuCount] = s;
					++stuCount;

					// ����ƽ��ѧ�ֺ����ѧ��
					tempGpa = s.getGpa();
					sumGpa = tempGpa + sumGpa;
					if (tempGpa > maxGpa)
						maxGpa = tempGpa;
				} else
					JOptionPane.showMessageDialog(null, "�Բ���¼��̫���ѧ����Ϣ");
			}
			input = JOptionPane.showInputDialog(null, "����C ¼��Ա����Ϣ"
					+ "\n����S ¼��ѧ����Ϣ" + "\n����Q �˳�");
			input = input.toUpperCase();
			letter = input.charAt(0);
		}
		System.out.println("\nԱ����Ϣ:");
		if (empCount == 0)
			System.out.println("û��¼��Ա����Ϣ");
		else
			for (x = 0; x < empCount; ++x)
				emp[x].display();
		System.out.println("\n ����Ա���е������н:" + maxAnnualSalary + "ƽ����н:"
				+ sumAnnualSalary / empCount);

		System.out.println("\nѧ����Ϣ:");
		if (stuCount == 0)
			System.out.println("û��¼��ѧ����Ϣ");
		else
			for (x = 0; x < stuCount; ++x)
				stu[x].display();
		System.out.println("\n ����ѧ���е����ѧ��:" + maxGpa + "ƽ��ѧ��:" + sumGpa
				/ stuCount);
		System.exit(0);
	}
}
