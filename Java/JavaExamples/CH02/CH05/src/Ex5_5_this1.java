public class Ex5_5_this1 {
	public static void main(String[] args) {
		Cat garfield = new Cat("��", 12);
		garfield.grow();
		garfield.grow();
	}
}

class Cat {
	String furColor;
	int height;

	public Cat(String color) {
		this.furColor = color;// ͨ��this���ʳ�Ա����������this����ʡ��
		this.cry();// ͨ��this���ó�Ա����������this����ʡ��

	}

	public Cat(String color, int height) {
		this(color);// //ͨ��this�����������췽��
		this.height = height;// ͨ��this���ó�Ա����������this����ʡ��
	}

	public void cry() {
		System.out.println(" ����һֻ" + this.furColor + "��ɫ��è");
	}

	public void grow() {
		this.height++;// ͨ��this���ʳ�Ա����������this����ʡ��
		System.out.println(" �ҳ����ˣ����Ϊ" + this.height);
	}

}
