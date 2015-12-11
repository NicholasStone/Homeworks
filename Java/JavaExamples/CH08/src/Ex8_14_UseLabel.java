import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Ex8_14_UseLabel {
	public static void main(String[] args) {
		JFrame frm = new JFrame("显示带图像的标签");
		frm.setLayout(null);// 设置为不使用布局管理器

		// 创建标签组件,设置位置及大小、显示字体、加载图片
		JLabel label = new JLabel("显示22号粗体字");
		label.setBounds(5, 5, 220, 100);
		label.setFont(new Font("", Font.BOLD, 22));
		label.setIcon(new ImageIcon("label.jpg"));
		// 设置文字左对齐
		label.setHorizontalAlignment(JLabel.LEFT);

		// 设置标签相对图片的位置,在高JDK高版本中增加了新的静态常量
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		frm.add(label);
		frm.setBounds(450, 200, 230, 130);
		frm.setVisible(true);
	}
}