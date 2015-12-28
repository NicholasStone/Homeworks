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


	public boolean Sale(double money){
		if(Price > money){
			return false;
		}else{
			Count--;
			return true;
		}
	}

	public boolean add(int number){
        if(number < 0){
            return false;
        }else{
            Count += number;
            return true;
        }
	}

	public void showMe(){
        System.out.println(
                "===================\nName:"+Name
                +"\nPrice:"+Price
                +"\nProducer:"+Producer
                +"\nRemaining:"+Count
                +"\n==================="
        );
    }

    @Override
    public String toString() {
        return Name;
    }
}
