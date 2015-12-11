
public class Ex2_4_Circle {
    public static void main(String[] args) {
    	Point1 p = new Point1(1, 1);
    	
    	double r = 1.5;
    	
    	System.out.println("Բ�ĵ����꣺" + p.toString());
    	
    	Circle c = new Circle(p,r);
    	
    	System.out.println("Բ���ܳ���" + c.getPerimeter());
    	System.out.println("Բ�������" + c.getArea());
    	
    	if(c.isInner(Point1.origin)) {
    		System.out.println("ԭ����Բ��");
    		}
    	
    	Point1 p2 = new Point1(-0.5, -0.5);
    	
    	if(c.isInner(p2)) {
    		System.out.println(p2.toString() + "��Բ��");
    		} else {
    			System.out.println(p2.toString() + "����Բ��");
    			}
    	}
    
}


/**
 * 
 * @������Circle
 * @���飺Բ�࣬���Գ�ʼ����ԭ������Ͱ뾶��
 * @������ڣ�2012-8-10
 * @�޸����ڣ�2013-9-11
 * ע��˳�����DOS��Eclipse�е�Ч����ͬ,DOS��������������
 *
 */

class Circle {
	Point1 center;
	double radius;
    
    /* ���캯������Բ������Ͱ뾶��ʼ�� */
	public Circle(Point1 p, double r) {
		this.center = new Point1(p.getX(), p.getY());
		this.radius = r;
		}
	
	
    /* ����Բ���ܳ� */
    public double getPerimeter() {
    	return 2 * Math.PI * radius;
    	}
    
    /* ����Բ����� */
    public double getArea() {
    	return Math.PI * radius * radius;
    	}
    
    /* �ж�һ��������Ƿ���Բ֮�� */
    public Boolean isInner(Point1 p) {
        double deltaX = Math.abs(center.getX()-p.getX());
        double deltaY = Math.abs(center.getY()-p.getY());
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	if(distance < radius) {
		return true;
		}else{
			return false;
			}
	}
    
}

/**
 * 
 * @������Point
 * @���飺������࣬���Գ�ʼ��������x��y��
 * @������ڣ�2012-8-9
 * @�޸����ڣ�2012-9-11
 *
 */

class Point1 {
	double x, y;

	public Point1(double x, double y){
		this.x = x;
		this.y = y; 
		}
	
	/* ���ʼ��ʱ������һ��ԭ��ʵ�� */
	public static Point1 origin = new Point1(0, 0);
	
	/* ��+������õ��������ַ��� */
	public String toString(){
        	return "(" + x + "," + y + ")"; 
        	}
	
	/* ��������Xֵ */
	public double getX() {
		return x;
	}

	/* ��������Yֵ */
	public double getY() {
		return y;
	}
}

