
public class Complex {
	private float realPart;
	private float imaginaryPart;
	public Complex(float r,float i){
		this.realPart=r;
		this.imaginaryPart=i;
	}
	public Complex(){
		this.realPart=0;
		this.imaginaryPart=0;
	}
	public Complex complexAdd(Complex c1,Complex c2){
		Complex c=new Complex();
		c.realPart=c1.realPart+c2.realPart;
		c.imaginaryPart=c1.imaginaryPart+c2.imaginaryPart;
		return c;
	}
	public Complex complexSubtract(Complex c1,Complex c2){
		Complex c=new Complex();
		c.realPart=c1.realPart-c2.realPart;
		c.imaginaryPart=c1.imaginaryPart-c2.imaginaryPart;
		return c;
	}
	public Complex complexMul(Complex c1,Complex c2){
		Complex c=new Complex();
		c.realPart=c1.realPart*c2.realPart-c1.imaginaryPart*c2.imaginaryPart;
		c.imaginaryPart=c1.realPart*c2.imaginaryPart+c2.imaginaryPart*c1.realPart;
		return c;
	}
	public void tostring(){
		System.out.print("("+this.realPart+","+this.imaginaryPart+")");
		
	}


}
