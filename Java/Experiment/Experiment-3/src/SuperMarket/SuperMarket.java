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

    public List<Goods> Query(sString producer, boolean x){
        List<Goods> result = new ArrayList<Goods>();
        boolean isName = true;
        for(Goods g : rack){
            if(producer.equals(g.getProducer())){
                g.showMe();
                result.add(g);
            }
        }
        return result;
    }

    public List<Goods> Query(String name){
        List<Goods> result = null;
        for(Goods g : rack){
            if(name.equals(g.getName())){
                g.showMe();
                result.add(g);
            }
        }
        return result;
    }

    public List<Goods> Query(double price){
        List<Goods> result = null;
        for(Goods g : rack){
            if(price == g.getPrice()){
                g.showMe();
                result.add(g);
            }
        }
        return result;
    }
}
