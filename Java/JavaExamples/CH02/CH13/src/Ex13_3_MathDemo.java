public class Ex13_3_MathDemo {
	public static void main(String args[]) {
		double a = 3.0, b = 4.0;
		double c = Math.sqrt(a * a + b * b);
		System.out.println("�뾶Ϊ3.0��Բ����ǣ�" + Math.PI * a * a);
		System.out.println("ֱ��������ֱ�Ǳ�Ϊ3.0��4.0ʱ��б�߳�Ϊ��" + c);
		System.out.println("-8��-4�Ľϴ��ǣ�" + Math.max(-8, -4));
		System.out.println("-18�ľ���ֵ�ǣ�" + Math.abs(-18));
		System.out.println("��С��45.7����С�����ǣ�" + Math.ceil(45.7));
		System.out.println("������45.7����С�����ǣ�" + Math.floor(45.7));
		System.out.println("sin25�ȵ�ֵ�ǣ�" + Math.sin(25.0 / 180 * Math.PI));
	}
}

