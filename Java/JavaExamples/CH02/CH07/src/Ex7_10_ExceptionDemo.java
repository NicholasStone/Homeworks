public class Ex7_10_ExceptionDemo {
	public static void main(String args[]){
		try{
			Bank ba=new Bank(50);  //�½����ж���ba������50
			ba.withdrawal(100);    //���ж���baȡ��100
			System.out.println("ȡ��ɹ�!");
		}catch(InsufficientFundsException e){ 
			System.out.println(e.toString());
			System.out.println(e.excepMessage());
		}
	}
}   //����
class Bank{
	double balance;    // �����
	Bank(double  balance){this.balance=balance;}  //���췽��
	public void deposite(double dAmount){        
		if(dAmount>0.0) balance+=dAmount;
	}       //����
	public void withdrawal(double dAmount) throws InsufficientFundsException{
		if (balance<dAmount)
			throw new InsufficientFundsException(this, dAmount);
		balance=balance-dAmount;
	}       //ȡ���
	public void showBalance(){
		System.out.println("The balance is "+(int)balance);
	}       //��ʾ���д�����
}   //������
class InsufficientFundsException extends Exception{
	private Bank  excepbank;      // ���ж���
	private double excepAmount;   // Ҫȡ��Ǯ
	InsufficientFundsException(Bank ba, double  dAmount){
		super("ȡ���쳣��");
		excepbank=ba;
		excepAmount=dAmount;
	}  //�쳣�๹�췽��
	public String excepMessage(){
		String  str="���д���ǣ�"+excepbank.balance
			+ "\n"+"Ҫȡ��Ǯ�ǣ�"+excepAmount;
		return str; 
	}  //ȡ���쳣ʱ��ʾ����Ϣ
}   //�쳣��
