public class Ex5_23_InnerClass {
	public static void main(String[] args) {
		Parcel p =new Parcel();
		Parcel.Contents c = p.new Contents(33);
		Parcel.Destination d = p.new Destination("ɽ����ͬ");//D ��
		//Destination d = new Destination("ɽ��̫ԭ");//A ��
		p.setValue(c,d);
		p.ship();
		p.testShip();
	}
}

class Parcel{
	private Contents c;
	private Destination d;
	private int contentsCount=0;
	class Contents {
		private int i;
		Contents(int i){
			this.i=i;
			contentsCount++;//C��
		}
		int value(){
			return i;
		}			
	}
	
	class Destination{
		private String label;
		Destination(String whereTo){
			label=whereTo;		
		}
		String readLabel(){
			return label;
		}
		
	}
	
	void setValue(Contents c,Destination d){
		this.c=c;
		this.d=d;
	}
	
	void ship(){
		System.out.println("����"+c.value()+"��"+d.label) ;//B��
	}
	
	public void testShip(){
		c = new Contents(22);
		d = new Destination("ɽ��̫ԭ");
		ship();
	}
}
