public class Ex10_1_CaseRunnable implements Runnable {// ����һ����ʵ�֣�implements��Runnable�ӿ�
	String studentName;

	public Ex10_1_CaseRunnable(String studentName) {// ������Ĺ��캯��,���ݲ���
		System.out.println(studentName + "������ʷ�����");
		this.studentName = studentName;
	}

	public void run() {// �����ڴ��߳���ִ�еĴ��븲��Thread���run()����
		for (int i = 0; i < 5; i++) {
			System.out.println("��ǰ�ķ��������" + studentName + "ͬѧ");
			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException ex) {
				System.err.println(ex.toString());
			}
		}// for
	}// run

	public static void main(String[] args) {
		Thread t1 = new Thread(new Ex10_1_CaseRunnable("����")); // ��newʵ��������
		Thread t2 = new Thread(new Ex10_1_CaseRunnable("����"));
		t1.start(); // ���øö����start()���������̡߳�
		t2.start();
	} // main
}
