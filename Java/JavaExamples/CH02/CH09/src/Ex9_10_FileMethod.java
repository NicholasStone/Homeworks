import java.io.File;
import java.util.Date;
public class Ex9_10_FileMethod {
	public static void main(String[] args) {
		File file=new File("./src/Ex8_12_FileMethod.java");
		System.out.println("�ļ�����"+file.getName());
		System.out.println("��Ŀ¼��"+file.getParent());
		System.out.println("�ļ����·����"+file.getPath());
		System.out.println("�Ƿ����·����"+file.isAbsolute());
		System.out.println("����·���ǣ�"+file.getAbsolutePath());
		System.out.println("�ļ��Ƿ���ڣ�"+file.exists());
		System.out.println("�Ƿ����ļ���"+file.isFile());
		System.out.println("�Ƿ���Ŀ¼��"+file.isDirectory());
		System.out.println("�Ƿ�ɶ���"+file.canRead());
		System.out.println("�Ƿ��д��"+file.canWrite());
		System.out.println("�Ƿ����أ�"+file.isHidden());
		System.out.println("�ļ����ȣ�"+file.length()+"�ֽ�");
		System.out.println("�ļ�����޸����ڣ�"+ new Date(file.lastModified()));
	}
}
