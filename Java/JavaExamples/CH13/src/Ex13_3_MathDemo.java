public class Ex13_3_MathDemo {
	public static void main(String args[]) {
		double a = 3.0, b = 4.0;
		double c = Math.sqrt(a * a + b * b);
		System.out.println("半径为3.0的圆面积是：" + Math.PI * a * a);
		System.out.println("直角三角型直角边为3.0和4.0时的斜边长为：" + c);
		System.out.println("-8和-4的较大都是：" + Math.max(-8, -4));
		System.out.println("-18的绝对值是：" + Math.abs(-18));
		System.out.println("不小于45.7的最小整数是：" + Math.ceil(45.7));
		System.out.println("不大于45.7的最小整数是：" + Math.floor(45.7));
		System.out.println("sin25度的值是：" + Math.sin(25.0 / 180 * Math.PI));
	}
}

