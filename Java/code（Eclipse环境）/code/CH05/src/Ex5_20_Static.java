public class Ex5_20_Static {

	public static void main(String[] args) {
		System.out.println(staticTestFunction.addUP(10, 5));// ��ȷ���෽���ɱ���ֱ�ӵ���
		// System.out.println(staticTestFunction.sub());//���� ��ʵ���������ܱ���ֱ�ӵ���
		staticTestFunction test = new staticTestFunction();
		System.out.println(test.sub());
	}
}

class staticTestFunction {
	int x = 10, y = 6;
	static int z = 9;

	public static int addUP(int a, int b) { // ������Ϊ�෽��
		return a + b + z;// �෽������ʹ�������
	}

	public int sub() {
		return x - y;
	}

//	public static int addUP() {
//		return x + y;// ����,�෽���в���ʹ��ʵ������
//	}
}
