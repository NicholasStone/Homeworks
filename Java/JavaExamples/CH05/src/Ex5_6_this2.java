public class Ex5_6_this2 {
	int x = 188,y;
	public static void main(String[] args) {
		Ex5_6_this2 e= new Ex5_6_this2();
		e.f();
	}
	void f(){
		int x=3;
		y=x;//y�õ���ֵ��3�����ǳ�Ա����x��ֵ��188��
		System.out.println("y="+y);
		
		y=this.x;//y�õ���ֵ�ǳ�Ա����x��ֵ������188
		System.out.println("y="+y);
	}
}
