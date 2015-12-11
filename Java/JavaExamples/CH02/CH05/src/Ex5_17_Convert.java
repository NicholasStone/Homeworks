public class Ex5_17_Convert {
	public static void main(String[] args) {
		TaxRate taxRate = new TaxRate();
		Manager2 manager = new Manager2();
		taxRate.findTaxRate(manager);// 参数传递时，对象类型转换
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
