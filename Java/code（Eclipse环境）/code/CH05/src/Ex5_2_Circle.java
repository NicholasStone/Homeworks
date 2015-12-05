import java.text.*;
public class Ex5_2_Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1,c2;           //声明c1和c2为Circle对象
		c1 = new Circle(10);   //创建c1
		Point p=new Point(9,8);
		c2 = new Circle(10,p);   //创建c2
		c2.setRadius(40);     //调用c2的修改半径方法，并不影响c1的成员变量状态
	    DecimalFormat   df   =   new   DecimalFormat("###,##0.00");   

		System.out.println("c1面积="+c1.getArea()+"\tc2面积="+c2.getArea());
		System.out.println("c1周长="+df.format(c1.getCircumference())+"\tc2周长="+df.format(c2.getCircumference()));
		
	}

}

class Circle {
	private Point p;
	private float radius = 0.0f;

	public Circle(float r) { // 构造方法
		radius = r;
	}

	public Circle(float r, Point p) { // 构造方法
		this.p = p;
		radius = r;
	}

	public void setRadius(float r) { // 设定半径
		radius = r;
	}

	public double getRadius() { // 修改半径
		return radius;
	}

	public double getArea() { // 计算面积
		final float PI = 3.14f;
		float area;
		area = PI * radius * radius;
		return area;
	}

	public double getCircumference() { // 计算面积
		final float PI = 3.14f;
		float circumference;
		circumference = 2 * PI * radius;
		return circumference;
	}
}

class Point {
	int x;
    int y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
