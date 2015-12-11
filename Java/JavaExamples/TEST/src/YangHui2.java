public class YangHui2 {

	public static void main(String args[]) {
		try {
			int n = 10;
			int mat[][] = new int[n][];
			int i, j;
			for (i = 0; i < n; i++) {
				mat[i] = new int[i + 1];
				// mat[i][0] = 1;
				mat[i][i] = 1;
				for (j = 1; j < i; j++) {
					mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
				}

			}
			for (i = 0; i < mat.length; i++) {
				for (j = 0; j < n - i; j++)
					System.out.print(" ");
				for (j = 0; j < mat[i].length; j++)
					System.out.print(" " + mat[i][j]);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}