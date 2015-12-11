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
		return members.size();// 容器对象membership中的元素的个数就是当前会员的人数。
	}

	public int joinedInMonth(int month) {
		if (month >= 1 && month <= 12) {
			int num = 0; // 定义变量，保存统计结果
			for (Membership member : members) {
				if (member.getMonth() == month)
					num++;
			}
			return num; // 统计结束后返回统计结果
		} else {
			System.out.println("输入的月份无效！");
			return 0;
		}
	}

	public static void main(String[] args) {
		Club club = new Club(); // 创建一个Club对象

		club.join(new Membership("David", 2, 2004));
		club.join(new Membership("Michael", 1, 2004));
		System.out.println("The club has " + club.numberOfMembers()
				+ " members.");
	}
}
