public class ADD2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       float sum=0;             
       for(int i=0;i<args.length;i++)
    	   sum+=Float.parseFloat(args[i]);
       System.out.println(sum);
	}

}
