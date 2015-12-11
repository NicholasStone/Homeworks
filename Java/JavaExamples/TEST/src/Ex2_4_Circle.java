
public class Ex2_4_Circle {
    public static void main(String[] args) {
    	Point1 p = new Point1(1, 1);
    	
    	double r = 1.5;
    	
    	System.out.println("圆心的坐标：" + p.toString());
    	
    	Circle c = new Circle(p,r);
    	
    	System.out.println("圆的周长：" + c.getPerimeter());
    	System.out.println("圆的面积：" + c.getArea());
    	
    	if(c.isInner(Point1.origin)) {
    		System.out.println("原点在圆中");
    		}
    	
    	Point1 p2 = new Point1(-0.5, -0.5);
    	
    	if(c.isInner(p2)) {
    		System.out.println(p2.toString() + "在圆中");
    		} else {
    			System.out.println(p2.toString() + "不在圆中");
    			}
    	}
    
}


/**
 * 
 * @类名：Circle
 * @类简介：圆类，可以初始化其原点坐标和半径。
 * @编程日期：2012-8-10
 * @修改日期：2013-9-11
 * 注意此程序在DOS与Eclipse中的效果不同,DOS环境下正常运行
 *
 */

class Circle {
	Point1 center;
	double radius;
    
    /* 构造函数：用圆心坐标和半径初始化 */
	public Circle(Point1 p, double r) {
		this.center = new Point1(p.getX(), p.getY());
		this.radius = r;
		}
	
	
    /* 计算圆的周长 */
    public double getPerimeter() {
    	return 2 * Math.PI * radius;
    	}
    
    /* 计算圆的面积 */
    public double getArea() {
    	return Math.PI * radius * radius;
    	}
    
    /* 判定一个坐标点是否在圆之内 */
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
 * @类名：Point
 * @类简介：坐标点类，可以初始化其坐标x和y。
 * @编程日期：2012-8-9
 * @修改日期：2012-9-11
 *
 */

class Point1 {
	double x, y;

	public Point1(double x, double y){
		this.x = x;
		this.y = y; 
		}
	
	/* 类初始化时，创建一个原点实例 */
	public static Point1 origin = new Point1(0, 0);
	
	/* 用+运算符得到坐标点的字符串 */
	public String toString(){
        	return "(" + x + "," + y + ")"; 
        	}
	
	/* 获得坐标的X值 */
	public double getX() {
		return x;
	}

	/* 获得坐标的Y值 */
	public double getY() {
		return y;
	}
}

