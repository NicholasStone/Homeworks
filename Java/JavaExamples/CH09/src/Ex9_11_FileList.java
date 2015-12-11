import java.io.File;
public class Ex9_11_FileList {
	public static void main(String[] args) {
		File files=new File(".\\");  //�õ�ǰĿ¼��������ļ�
		File newDir=new File("c:\\sub1\\sub2");
		newDir.mkdirs();  //�½�Ŀ¼������Ŀ¼
		System.out.println("��ǰĿ¼�ľ���·���ǣ�"+files.getAbsolutePath());
		fileList(files,1);
	}
	public static void fileList(File file,int level){ //�ļ��б���
		String preStr="";
		int dcount=0,fcount=0,tsize=0; 
		for(int i=0;i<level;i++)
			preStr+="\t";
		File[] childs=file.listFiles(); //��ó���·����fileĿ¼�е��ļ���Ŀ¼
		for(int i=0;i<childs.length;i++){ //��ʾ��Ŀ¼�е��ļ���Ŀ¼
			if(childs[i].isDirectory()){
				System.out.println(preStr+"["+childs[i].getName()+"]");
				dcount++;
			}
			else{
				System.out.println(preStr+childs[i].getName());
				fcount++;
				tsize+=childs[i].length();
			}
			if(childs[i].isDirectory())	
				fileList(childs[i],level+1);
		}
		if(file.isDirectory())
			System.out.println(preStr+"��["+file.getName()+"]Ŀ¼����"+dcount
					+"��Ŀ¼,"+fcount+"���ļ�,��"+tsize+"�ֽ�");
	}
}
