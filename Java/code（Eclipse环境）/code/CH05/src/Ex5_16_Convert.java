public class Ex5_16_Convert {
	public static void main(String[] args) {
		C c = new D();// ��������ָ���������
		c.n = 3.1415926;// �޸ĵ��Ǹ������õı����صı���
		// c.w = 300;//A �У��������ò��ܲ���������������ĳ�Ա������
		// c.cry();//B��,�������ò��ܲ���������������ĳ�Ա����
		c.m = 186;
		c.f();
		c.g();// cʵ����һ������������ʵ�ʵ��õ��������g��������

		D d = (D) c;// ��cǿ��ת��Ϊ�������
		d.n = 555;
		d.f();
		d.g();
		d.cry();
	}
}

class C {
	int m;
	double n;

	void f() {
		System.out.println("������̳еķ���f()");
	}

	void g() {
		System.out.println("��ã�n=" + n + "  m=" + m);
	}
}

class D extends C {
	int n = 12;
	int w;

	void g() {
		System.out.println("������д����g(),n=" + n + "  m=" + m);
	}

	void cry() {
		System.out.println("���������ķ���");
	}
}
