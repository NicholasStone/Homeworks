import java.text.*;
public class Ex5_2_Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1,c2;           //����c1��c2ΪCircle����
		c1 = new Circle(10);   //����c1
		Point p=new Point(9,8);
		c2 = new Circle(10,p);   //����c2
		c2.setRadius(40);     //����c2���޸İ뾶����������Ӱ��c1�ĳ�Ա����״̬
	    DecimalFormat   df   =   new   DecimalFormat("###,##0.00");   

		System.out.println("c1���="+c1.getArea()+"\tc2���="+c2.getArea());
		System.out.println("c1�ܳ�="+df.format(c1.getCircumference())+"\tc2�ܳ�="+df.format(c2.getCircumference()));
		
	}

}

class Circle {
	private Point p;
	private float radius = 0.0f;

	public Circle(float r) { // ���췽��
		radius = r;
	}

	public Circle(float r, Point p) { // ���췽��
		this.p = p;
		radius = r;
	}

	public void setRadius(float r) { // �趨�뾶
		radius = r;
	}

	public double getRadius() { // �޸İ뾶
		return radius;
	}

	public double getArea() { // �������
		final float PI = 3.14f;
		float area;
		area = PI * radius * radius;
		return area;
	}

	public double getCircumference() { // �������
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
