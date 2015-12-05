//interface Compute<E, F> {
//	void makeChorus(E x, F y);
//}
//
//class Chorous2<E, F> implements Compute<E, F> {
//	public void makeChorus(E x, F y) {
//		x.toString();
//		y.toString();
//	}
//}
//
//class Singer2 {
//	public String toString() {
//		System.out.println("��һ������������");
//		return "";
//	}
//}
//
//class MusicalInstruments2 {
//	public String toString() {
//		System.out.println("|3 34 61 16|5 56 5-|");
//		return "";
//	}
//}
//
//public class Ex5_28 {
//	public static void main(String[] args) {
//		Chorous<Singer, MusicalInstruments> model = new Chorous<Singer, MusicalInstruments>();
//		model.makeChorus(new Singer(), new MusicalInstruments());
//	}
//}
