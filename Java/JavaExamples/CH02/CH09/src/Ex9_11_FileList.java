import java.io.File;
public class Ex9_11_FileList {
	public static void main(String[] args) {
		File files=new File(".\\");  //用当前目录构造抽象文件
		File newDir=new File("c:\\sub1\\sub2");
		newDir.mkdirs();  //新建目录及其子目录
		System.out.println("当前目录的绝对路径是："+files.getAbsolutePath());
		fileList(files,1);
	}
	public static void fileList(File file,int level){ //文件列表方法
		String preStr="";
		int dcount=0,fcount=0,tsize=0; 
		for(int i=0;i<level;i++)
			preStr+="\t";
		File[] childs=file.listFiles(); //获得抽象路径名file目录中的文件或目录
		for(int i=0;i<childs.length;i++){ //显示该目录中的文件或目录
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
			System.out.println(preStr+"在["+file.getName()+"]目录下有"+dcount
					+"个目录,"+fcount+"个文件,共"+tsize+"字节");
	}
}
