package SuperMarket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2015/12/16 17:13
 */
public class SuperMarket{

	private List<Goods> rack;

	public SuperMarket(String names[], int count[], double price[], String producer[]){
		rack = new ArrayList<Goods>();

		for(int i = 0; i < names.length; i++){
			rack.add(new Goods(names[i], producer[i], count[i], price[i]));
		}

	}

	public void Check(){
		System.out.println("=========================================================");
		System.out.println("Name\t\t\tProducer\t\tCount\t\tPrice");
		System.out.println("=========================================================");
		for(Goods g : rack){
			System.out.println(g.getName() + "\t\t\t" + g.getProducer() + "\t\t" +  g.getCount() + "\t\t" +g.getPrice());
		}
		System.out.println("=========================================================");
	}

	public void Query(String producer, boolean x){
		int result = 0;
		boolean isName = true;
		for(Goods g : rack){
			if(producer.equals(g.getProducer())){
				result += g.getCount();
			}
		}
	}

	public void Query(String name){
		int result = 0;
		for(Goods g : rack){
			if(name.equals(g.getName())){
				result += g.getCount();
			}
		}
	}

	public void Query(double price){
		int result = 0;
		for(Goods g : rack){
			if(price == g.getPrice()){
				result += g.getCount();
			}
		}
	}
}
