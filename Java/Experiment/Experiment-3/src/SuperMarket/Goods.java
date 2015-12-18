package SuperMarket;

/**
 * Created on 2015/12/16 20:06
 */
public class Goods{
	private String Name = "";
	private int Count = 0;
	private double Price = 0;
	private String Producer = "";

	public Goods(String name, String producer, int count, double price){
		Name = name;
		Price = price;
		Count = count;
		Producer = producer;
	}

	public String getName(){
		return Name;
	}

	public int getCount(){
		return Count;
	}

	public double getPrice(){
		return Price;
	}

	public String getProducer(){
		return Producer;
	}


	public void Sale(){

	}

	public void add(int number){

	}

	public void showMe(){

	}

}
