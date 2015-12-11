package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex_2_2_numberfoundcase {
	public static void main(String[] args) {
		/* 检查是否输入两个文件名：输入文件名和输出文件名 */
		if (args.length != 2) {
			System.out.println("请输入两个文件名！！！");
		} else {
			/* step1:获得输入输出文件名 */
			String infile = args[0]; // 输入文件名
			String outfile = args[1]; // 输出文件名
			try {
				/* step2:打开输入文件 */
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(infile), "GBK"));
				String lineBuffer;
				/* step3:对每一行，使用字符读取函数，读出每一个字符；判断字符是否是数字，如果是，将它附加到缓存字符串的尾部； */
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
				/* step4：分解结果写入输出文件 */
				FileOutputStream fos = new FileOutputStream(outfile);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						fos, "GBK"));
				bw.write(ages.toString());
				bw.close();
			} catch (Exception e) {
				System.out.println("文件处理发生错误！！！");
				System.out.println("输入文件名：" + infile);
				System.out.println("输出文件名：" + outfile);
				System.out.println("错误信息：" + e.getMessage());
			}
		}
	}
}
