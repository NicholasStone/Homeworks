package SuperMarket;

import java.util.ArrayList;
import java.util.Collection;
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

    public Goods Query(String name){
        Goods result = null;
        for(Goods g : rack){
            if(name.equals(g.getName())){
                if (result == null) {
                    result = g;
                }else{
                    System.out.println("条件有多个结果，请输入其他查询条件！");
                    return null;
                }
            }
        }
        return result;
    }

    public Goods Query(String name, String producer){
        Goods result = null;
        for(Goods g : rack){
            if(name.equals(g.getName())) {
                if (producer.equals(g.getProducer())) {
                    if (result == null) {
                        result = g;
                    } else {
                        System.out.println("条件有多个结果，请输入其他查询条件！");
                        return null;
                    }
                }
            }
        }
        return result;
    }

    public Goods Query(String name, String producer, double price){
        Goods result = null;
        for(Goods g : rack){
            if(name.equals(g.getName())) {
                if (producer.equals(g.getProducer())) {
                    if(price == g.getPrice()) {
                        result = g;
                    }
                }
            }
        }
        return result;
    }

    public Goods Query(String prodocuer, boolean f){
        Goods result = null;
        for(Goods g : rack){
            if(prodocuer.equals(g.getProducer())){
                if (result == null) {
                    result = g;
                }else{
                    System.out.println("条件有多个结果，请输入其他查询条件！");
                    return null;
                }
            }
        }
        return result;
    }
    public static void main(String args[]){
        String GoodsName[] = {"DotA ", "WarCraft", "Call of Duty", "Crysis", "Red Alert", "FIFA", "2K  ", "Halo", "ArmA", "GTA ", "CS:GO", "CS:GO"};
        String Producers[] = {"Valve", "Blizzard", "Activision", "Crytek Studios", "EA", "EA", "2K Sports", "Microsoft", "Bohemia", "RockstarGames", "Valve","EA"};
        double Price[] = {0, 90, 286, 70, 99, 360, 285, 249, 319, 113, 48, 15};
        int Count[] = {100000, 100000, 50000, 50000, 30000, 30000, 20000, 50000, 10000, 70000, 60000, 30000};
        SuperMarket superMarket  = new SuperMarket(GoodsName, Count, Price, Producers);

        superMarket.Check();

        System.out.println(superMarket.Query("Crysis"));
        System.out.println(superMarket.Query("EA",true));
        System.out.println(superMarket.Query("CS:GO","Valve"));
        superMarket.Query("CS:GO","Valve").add(300);
        try {
            superMarket.Query("Call of Duty").sale(466);
        }catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
        try {
            superMarket.Query("Call of Duty").sale(5);
        }catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
    }
}
