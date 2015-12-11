package com.elephant.studentManagment;

import java.util.*;

public class StudentManager {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] name = { "王刚", "刘洪", "张山", "董义凡", "李克", "洪涛", "刘江涛", "段康宁",
				"沈大丽", "和平" }; // 存储学生的名字
		String [] course={"C程序设计","物理","英语","高数" ,"体育","政治" };
		double[][] grade = { { 50, 60, 70, 80, 90, 10 },
				{ 40, 90, 80, 60, 40, 70 }, { 60, 80, 70, 60, 40, 90 },
				{ 50, 60, 70, 80, 90, 10 }, { 60, 80, 70, 60, 40, 90 },
				{ 60, 70, 80, 90, 70, 70 }, { 60, 80, 70, 60, 40, 90 },
				{ 60, 80, 70, 60, 40, 90 }, { 60, 80, 70, 60, 40, 90 },
				{ 60, 45.5, 70, 60, 40, 10 } };// 存储学生各科成绩
		System.out.println("输入要查询成绩的学生名字：");
		String chioce = input.nextLine();
		
		for (int i = 0; i < 10; i++) {
			if (name[i].equals(chioce)) {
				System.out.println("学生：" + name[i] + "的成绩如下：");
				for (int j=0;j<course.length;j++)
				System.out.print(course[j]+"：" + grade[i][j] + "  " );
				System.out.println();
				break;
			} else if (i==9)
				System.out.println("您所查找的学生不存在");
		}
		System.out.println("===============================");
		System.out.println("输入查询不及格人数的科目序号/n");
		System.out.println("1、C程序设计 2、物理 3、英语 4、高数 5、体育 6、政治");
		int ch = input.nextInt();
		input.close();
		int time = 0;
		System.out.println("不及格的名单为：");
		for (int i = 0; i < 10; i++) {
			if (grade[i][ch - 1] < 60) {
				time++;
				System.out.println(name[i]);
			}
		}
		System.out.println("该科目不及格人数为：" + time);
	}
}
