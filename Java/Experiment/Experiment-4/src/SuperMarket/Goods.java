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


	public void sale(double money) throws InsufficientFundsException{
		if(Price > money){
			throw new InsufficientFundsException();
		}else{
			Count--;
			System.out.println("已售出，现余货 "+Count+" 件");
		}
	}

	public void add(int number){
        if(number < 0){
			System.out.println("上架失败");
		}else{
            Count += number;
			System.out.println("上架成功，现余货 "+Count+" 件");
		}
	}

	public void showMe(){
        System.out.println(
            "===================\n" +
            "货名:"+Name +
            "\n价格:"+Price+
            "\n产地:"+Producer+
            "\n余货:"+Count+
            "\n==================="
        );
    }

    @Override
    public String toString() {
        return  "===================\n" +
                "货名:"+Name +
                "\n价格:"+Price+
                "\n产地:"+Producer+
                "\n余货:"+Count+
                "\n===================";
    }
}
