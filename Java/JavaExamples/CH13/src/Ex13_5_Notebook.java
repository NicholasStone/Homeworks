import java.util.ArrayList; //在类的定义的前面使用了import语句

public class Ex13_5_Notebook {
	// 在Notebook类中定义了一个ArrayList类型的字段notes，用该字段保存记事本中的若干记录。
	// 使用容器时需要确定两种类型：容器的类型（这里是ArrayList）和容器中存放的元素类型（这里是String）。
	private ArrayList<String> notes;

	public Ex13_5_Notebook() {
		// 在Notebook的构造器中，创建ArrayList<String>类型的对象，并保存在notes字段中。
		notes = new ArrayList<String>();
	}

	
	public void storeNote(String note) {
		notes.add(note);
	}

	// 获得记事本中记录的数量
	public int numberOfNotes() {
		return notes.size();
	}

	// 读取记事本中指定的记录
	public void showNote(int noteNumber) {
		if (noteNumber < 0) {
			//
		} else if (noteNumber < numberOfNotes()) {
			System.out.println(notes.get(noteNumber));
		} else {
			//
		}
	}

	// 删除记事本中指定的记录
	public void removeNote(int noteNumber) {
		if (noteNumber < 0) {
			//
		} else if (noteNumber < numberOfNotes()) {
			notes.remove(noteNumber);
		} else {
			//
		}
	}

	public void listNotes() {
		int index = 0;
		while (index < notes.size()) {
			System.out.println(notes.get(index));
			index++;
		}
	}

}
