package Complex;

/**
 * Created on 2015/12/16 12:55
 */
public class Complex{
	private double Real = 0;
	private double Image = 0;

	public double getRealPart(){
		return Real;
	}

	public double getImaginaryPart(){
		return Image;
	}

	public Complex(){}
	public Complex(double real, double image){
		Real = real;
		Image = image;
	}

	public Complex plus(Complex c){
		Real += c.getRealPart();
		Image += c.getImaginaryPart();
		return this;
	}

	public Complex minus(Complex c){
		Real -= c.getRealPart();
		Image = c.getImaginaryPart();
		return this;
	}

	public Complex times(Complex c){
		Real = Real*c.getRealPart() - Image*c.getImaginaryPart();
		Image = Image*c.getRealPart() + Real*c.getImaginaryPart();
		return this;
	}

	public Complex divide(Complex c){
		double cReal = c.getRealPart();
		double cImage = c.getImaginaryPart();
		double denominator = cReal*cReal + cImage + cImage;

		Real = (Real*cReal + Image+cImage)/denominator;
		Image = (cReal*Image - Real*cImage)/denominator;
		return this;
	}

	@Override
	public String toString(){
		return "("+String.format("%.5f",Real)+", "+String.format("%.5f",Image)+")";
	}
}
