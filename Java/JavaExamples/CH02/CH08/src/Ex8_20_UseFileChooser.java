import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class Ex8_20_UseFileChooser {
	public static void main(String[] args) {
		final JFrame frm = new JFrame("ʹ���ļ��Ի���");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);// ����Ϊ��ʹ�ò��ֹ�����

		// �����ļ��Ի��򣬲������ļ���������ֻѡ��.txt�ļ�
		JFileChooser fc = new JFileChooser();
		TxtFileFilter myff = new TxtFileFilter(".txt");
		fc.setFileFilter(myff);
		fc.showOpenDialog(frm);
		System.out.println("ѡ�е��ļ�Ϊ��" + fc.getSelectedFile().getName());
		// fc.setDialogType(JFileChooser.SAVE_DIALOG);
		// fc.showDialog(frm, "����txt�ļ�");
		// fc.showSaveDialog(frm);

		frm.setBounds(400, 200, 450, 300);
		frm.setVisible(true);
	}
}

// �̳г�����FileFilter,��������ı��ļ����ļ���������
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