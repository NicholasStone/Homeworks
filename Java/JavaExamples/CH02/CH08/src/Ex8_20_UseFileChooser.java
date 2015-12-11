import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class Ex8_20_UseFileChooser {
	public static void main(String[] args) {
		final JFrame frm = new JFrame("使用文件对话框");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);// 设置为不使用布局管理器

		// 创建文件对话框，并设置文件过滤器，只选择.txt文件
		JFileChooser fc = new JFileChooser();
		TxtFileFilter myff = new TxtFileFilter(".txt");
		fc.setFileFilter(myff);
		fc.showOpenDialog(frm);
		System.out.println("选中的文件为：" + fc.getSelectedFile().getName());
		// fc.setDialogType(JFileChooser.SAVE_DIALOG);
		// fc.showDialog(frm, "保存txt文件");
		// fc.showSaveDialog(frm);

		frm.setBounds(400, 200, 450, 300);
		frm.setVisible(true);
	}
}

// 继承抽象类FileFilter,定义过滤文本文件的文件过滤器类
class TxtFileFilter extends FileFilter {
	String condition = "";

	public TxtFileFilter(String condition) {
		this.condition = condition;
	}

	@Override
	public boolean accept(File pathname) {
		String filename = pathname.getName();
		if (filename.lastIndexOf(condition) != -1) {
			return true;
		} else
			return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}