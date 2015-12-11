public class Ex10_4_seatorderedCase {
	private int seatResource;                     // ��������
	private boolean empty = true;         // seatResource�Ƿ�Ϊ�յ��ź���
    public void setEmpty(){
    	empty=true;
    }
	public synchronized void push(int pubResource) {
		while (!empty) {                   // ������������ʱ�򣬵ȴ�
			try {                             // �����Լ�
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		seatResource = pubResource;        // �����ɵ���λ�ŷŵ�������
		empty = false;                      // ���û�������״̬
		notify();                           // ���������ȴ��߳�
	}
	public synchronized int pop() {       // �ӻ���������λ
		while (empty) {
			try {
				wait();                    // ���������յ�ʱ�򣬵ȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int popResource = seatResource;
		seatResource = 0;
		empty = true;                    // ���û�������״̬
		notify();
		return popResource;            // ����������λ��
	}
	public static void main(String[] args) {
		Ex10_4_seatorderedCase so = new Ex10_4_seatorderedCase();
		SeatProcedure sp = new SeatProcedure(so);
		sp.start();
		SeatConsumer sc = new SeatConsumer(so);
		sc.start();
		SeatRelease sr=new SeatRelease(so);
		sr.start();
	}
}
class SeatProcedure extends Thread { //���ɿ���λ�߳�            
	private Ex10_4_seatorderedCase so;          
	public SeatProcedure(Ex10_4_seatorderedCase so) {   
		this.so = so;
	}
	public void run() {
		for (int i = 1; i <= 30; i++) {     //�����򻺳������ɿ���λ��
			int pubResource = i;
			so.push(pubResource);
			System.out.println("��" + pubResource + "����λΪ��");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//class end
class SeatConsumer extends Thread{	//Ԥ����λ�߳�
	private Ex10_4_seatorderedCase so;          
	public SeatConsumer(Ex10_4_seatorderedCase so) {         
		this.so= so;  
	}
		public void run() {
			for (int i = 1; i <= 50; i++) {//50��ѧ�������ӻ�����ȡ����λ�� 
				synchronized (so) {
					int sh = so.pop();
					if (sh != 0) {
						System.out.println("ѧ��" + i + " "+"ռ�˵�" + sh+"����λ");
					} else {
						System.out.println("û�п�������ȴ���");
					}
				}
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}//class end
class SeatRelease  extends Thread {  //�ͷ���λ�߳�                     
	private Ex10_4_seatorderedCase so;                         
	public SeatRelease(Ex10_4_seatorderedCase so) {        
		this.so = so;
	}
	public void run() {
		try {
			sleep(20000);//20���
             this.so.setEmpty();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 30; i++) {      //�ӵ�һ����ʼ,�����ͷ���Ԥ������λ
			int pubResource = i;
			so.push(pubResource);
			System.out.println("��" + pubResource + "����λȡ��Ԥ��");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



