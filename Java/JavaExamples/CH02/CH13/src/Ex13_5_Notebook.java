import java.util.ArrayList; //����Ķ����ǰ��ʹ����import���

public class Ex13_5_Notebook {
	// ��Notebook���ж�����һ��ArrayList���͵��ֶ�notes���ø��ֶα�����±��е����ɼ�¼��
	// ʹ������ʱ��Ҫȷ���������ͣ����������ͣ�������ArrayList���������д�ŵ�Ԫ�����ͣ�������String����
	private ArrayList<String> notes;

	public Ex13_5_Notebook() {
		// ��Notebook�Ĺ������У�����ArrayList<String>���͵Ķ��󣬲�������notes�ֶ��С�
		notes = new ArrayList<String>();
	}

	
	public void storeNote(String note) {
		notes.add(note);
	}

	// ��ü��±��м�¼������
	public int numberOfNotes() {
		return notes.size();
	}

	// ��ȡ���±���ָ���ļ�¼
	public void showNote(int noteNumber) {
		if (noteNumber < 0) {
			//
		} else if (noteNumber < numberOfNotes()) {
			System.out.println(notes.get(noteNumber));
		} else {
			//
		}
	}

	// ɾ�����±���ָ���ļ�¼
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
