package com.elephant.studentManagment;

import java.util.*;

public class StudentManager {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] name = { "����", "����", "��ɽ", "���已", "���", "����", "������", "�ο���",
				"�����", "��ƽ" }; // �洢ѧ��������
		String [] course={"C�������","����","Ӣ��","����" ,"����","����" };
		double[][] grade = { { 50, 60, 70, 80, 90, 10 },
				{ 40, 90, 80, 60, 40, 70 }, { 60, 80, 70, 60, 40, 90 },
				{ 50, 60, 70, 80, 90, 10 }, { 60, 80, 70, 60, 40, 90 },
				{ 60, 70, 80, 90, 70, 70 }, { 60, 80, 70, 60, 40, 90 },
				{ 60, 80, 70, 60, 40, 90 }, { 60, 80, 70, 60, 40, 90 },
				{ 60, 45.5, 70, 60, 40, 10 } };// �洢ѧ�����Ƴɼ�
		System.out.println("����Ҫ��ѯ�ɼ���ѧ�����֣�");
		String chioce = input.nextLine();
		
		for (int i = 0; i < 10; i++) {
			if (name[i].equals(chioce)) {
				System.out.println("ѧ����" + name[i] + "�ĳɼ����£�");
				for (int j=0;j<course.length;j++)
				System.out.print(course[j]+"��" + grade[i][j] + "  " );
				System.out.println();
				break;
			} else if (i==9)
				System.out.println("�������ҵ�ѧ��������");
		}
		System.out.println("===============================");
		System.out.println("�����ѯ�����������Ŀ�Ŀ���/n");
		System.out.println("1��C������� 2������ 3��Ӣ�� 4������ 5������ 6������");
		int ch = input.nextInt();
		input.close();
		int time = 0;
		System.out.println("�����������Ϊ��");
		for (int i = 0; i < 10; i++) {
			if (grade[i][ch - 1] < 60) {
				time++;
				System.out.println(name[i]);
			}
		}
		System.out.println("�ÿ�Ŀ����������Ϊ��" + time);
	}
}
