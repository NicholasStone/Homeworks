import java.util.ArrayList;

public class Club {

	private ArrayList<Membership> members;

	public Club() {
		members = new ArrayList<Membership>();
	}

	public void join(Membership member) {
		members.add(member);
	}

	public int numberOfMembers() {
		return members.size();// ��������membership�е�Ԫ�صĸ������ǵ�ǰ��Ա��������
	}

	public int joinedInMonth(int month) {
		if (month >= 1 && month <= 12) {
			int num = 0; // �������������ͳ�ƽ��
			for (Membership member : members) {
				if (member.getMonth() == month)
					num++;
			}
			return num; // ͳ�ƽ����󷵻�ͳ�ƽ��
		} else {
			System.out.println("������·���Ч��");
			return 0;
		}
	}

	public static void main(String[] args) {
		Club club = new Club(); // ����һ��Club����

		club.join(new Membership("David", 2, 2004));
		club.join(new Membership("Michael", 1, 2004));
		System.out.println("The club has " + club.numberOfMembers()
				+ " members.");
	}
}
