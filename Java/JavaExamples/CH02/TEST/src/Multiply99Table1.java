
public class Multiply99Table1 {

	public static void main(String[] args) throws NumberFormatException{
		// TODO Auto-generated method stub
		String[] arr = {"ʮ", "һ", "��", "��", "��", "��", "��", "��", "��", "��"};
		
		for(double i=1; i<=9; i++)
		{
			for(double j=1; j<=i; j++)
			{
				
				double k = i*j;
				if(k<10)
				{
					System.out.print(arr[(int)j] + arr[(int)i] + "��" + arr[(int)(i*j)] );
				}
				else if (k>10)
				{
					String k1 = String.valueOf(k).toString().substring(0, 1);
					String k2 = String.valueOf(k).toString().substring(1, 2);
									
					System.out.print(arr[(int)j] + arr[(int)i] + arr[Integer.valueOf(k1.trim())] + arr[Integer.valueOf(k2.trim())]); 
					
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}

