//package chapter4;

import java.util.*;

public class YangHui {

	public static void yanghui(int n) { // 输出杨辉三角
		int[][] s = new int[n + 1][n + 1];

		for (int x = 1; x <= n; x++) {
			System.out.print("\t\t\t\t");
			for (int z = 1; z <= n + 1 - x; z++)
				System.out.print("  ");
			for (int y = 1; y <= x; y++) {
				if (y == 1) {
					System.out.print(y + "   ");
					s[x][y] = 1;
				} else if (y == x) {
					System.out.print(1);
					s[x][y] = 1;
				} else {
					
					System.out.print(s[x - 1][y - 1] + s[x - 1][y] + "   ");
					s[x][y] = s[x - 1][y - 1] + s[x - 1][y];
				}
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("请输入一个数字代表行数：");
		Scanner s = new Scanner(System.in);
		yanghui(s.nextInt());
	}

}
