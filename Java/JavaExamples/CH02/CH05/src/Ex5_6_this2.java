public class Ex5_6_this2 {
	int x = 188,y;
	public static void main(String[] args) {
		Ex5_6_this2 e= new Ex5_6_this2();
		e.f();
	}
	void f(){
		int x=3;
		y=x;//y得到的值是3，而非成员变量x的值（188）
		System.out.println("y="+y);
		
		y=this.x;//y得到的值是成员变量x的值，即：188
		System.out.println("y="+y);
	}
}
