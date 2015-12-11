package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex_2_2_numberfoundcase {
	public static void main(String[] args) {
		/* ����Ƿ����������ļ����������ļ���������ļ��� */
		if (args.length != 2) {
			System.out.println("�����������ļ���������");
		} else {
			/* step1:�����������ļ��� */
			String infile = args[0]; // �����ļ���
			String outfile = args[1]; // ����ļ���
			try {
				/* step2:�������ļ� */
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(infile), "GBK"));
				String lineBuffer;
				/* step3:��ÿһ�У�ʹ���ַ���ȡ����������ÿһ���ַ����ж��ַ��Ƿ������֣�����ǣ��������ӵ������ַ�����β���� */
				StringBuffer ages = new StringBuffer();
				while (null != (lineBuffer = br.readLine())) {
					for (int i = 0; i < lineBuffer.length(); i++) {
						if ((lineBuffer.charAt(i) >= '0')
								&& (lineBuffer.charAt(i) <= '9'))
							ages.append(lineBuffer.charAt(i));
					}
					ages.append("\r\n");
				}
				br.close();
				/* step4���ֽ���д������ļ� */
				FileOutputStream fos = new FileOutputStream(outfile);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						fos, "GBK"));
				bw.write(ages.toString());
				bw.close();
			} catch (Exception e) {
				System.out.println("�ļ����������󣡣���");
				System.out.println("�����ļ�����" + infile);
				System.out.println("����ļ�����" + outfile);
				System.out.println("������Ϣ��" + e.getMessage());
			}
		}
	}
}
