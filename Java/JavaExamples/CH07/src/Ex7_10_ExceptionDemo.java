public class Ex7_10_ExceptionDemo {
	public static void main(String args[]){
		try{
			Bank ba=new Bank(50);  //新建银行对象ba并存入50
			ba.withdrawal(100);    //银行对象ba取款100
			System.out.println("取款成功!");
		}catch(InsufficientFundsException e){ 
			System.out.println(e.toString());
			System.out.println(e.excepMessage());
		}
	}
}   //主类
class Bank{
	double balance;    // 存款数
	Bank(double  balance){this.balance=balance;}  //构造方法
	public void deposite(double dAmount){        
		if(dAmount>0.0) balance+=dAmount;
	}       //存款方法
	public void withdrawal(double dAmount) throws InsufficientFundsException{
		if (balance<dAmount)
			throw new InsufficientFundsException(this, dAmount);
		balance=balance-dAmount;
	}       //取款方法
	public void showBalance(){
		System.out.println("The balance is "+(int)balance);
	}       //显示银行存款余额
}   //银行类
class InsufficientFundsException extends Exception{
	private Bank  excepbank;      // 银行对象
	private double excepAmount;   // 要取的钱
	InsufficientFundsException(Bank ba, double  dAmount){
		super("取款异常！");
		excepbank=ba;
		excepAmount=dAmount;
	}  //异常类构造方法
	public String excepMessage(){
		String  str="银行存款是："+excepbank.balance
			+ "\n"+"要取的钱是："+excepAmount;
		return str; 
	}  //取款异常时显示的信息
}   //异常类
