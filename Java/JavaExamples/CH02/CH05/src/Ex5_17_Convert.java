public class Ex5_17_Convert {
	public static void main(String[] args) {
		TaxRate taxRate = new TaxRate();
		Manager2 manager = new Manager2();
		taxRate.findTaxRate(manager);// ��������ʱ����������ת��
	}
}

class TaxRate {
	void findTaxRate(Employee2 e) {
	}
}

class Employee2 {
}

class Manager2 extends Employee2 {
}
