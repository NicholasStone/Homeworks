import java.io.*;
import javax.swing.JOptionPane;

public class Ex6_4_StudentScore {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int classCount = 3;// 暂定3个班
		int[] studentCount = { 2, 3, 5 };
// 每个班的学生数量，为简单，暂定每个班的学生分别为2、3、5个学生
		double score[][] = new double[3][];
		boolean contiGo = true;
		for (int i=0;i<score.length;i++) //初始化score
			score[i] = new double [studentCount[i]];
		
		//输入每个班每名同学的成绩
		String str;
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));			
		for (int i = 0; i < classCount; i++) {
			for (int k = 0; k < studentCount[i]; k++) {
				while (contiGo) {
					System.out.println("请输入第" + (i + 1) + "个班第" + (k + 1)
							+ "个学生的成绩：");
					str = buf.readLine();
					try {// 处理输入非数值数据或输入的数是0
						score[i][k] = Double.parseDouble(str);
						if (0 > score[i][k] || 100 < score[i][k]) {
							JOptionPane.showMessageDialog(null,
									"成绩不应该<0,请重新输入。", "提示信息",
									JOptionPane.QUESTION_MESSAGE);
						} else
							break;
					} catch (Exception ne) {
						System.out.println(ne);
						JOptionPane.showMessageDialog(null,							                     	"输入的不是数据，不符合规定，请重新输入。", 
"提示信息",	JOptionPane.QUESTION_MESSAGE);
					}
				}
			}
		}
		
		//计算每班的均分
		double sumScore=0,avgScore=0;
		for (int i=0;i<score.length;i++){
			sumScore=0;
			for (int k = 0; k < studentCount[i]; k++){
				sumScore=sumScore+score[i][k];
			}
			avgScore = sumScore/studentCount[i];
			System.out.println("第" + (i + 1) + "个班的平均成绩为"+avgScore );	
		}
	}
}
