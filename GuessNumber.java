import java.util.*;

public class GuessNumber {
	public static void main(String[] args) {
		Random random = new Random(); // 创建random
		int x = random.nextInt(100) + 1; // 生成一个1-100之间的随机数，random.nextInt(100)的范围为0-99，所以+1，范围为1-100
		System.out.println("系统已自动为您生成了一个随机数（范围为1-100），游戏开始！");
		System.out.print("猜猜这个数字是多少吧：");
		Scanner in = new Scanner(System.in); // 创建scanner
		int y = in.nextInt(); // 输入数字
		int count = 1; // 次数

		while (y != x) {

			count++;

			if (y < 1 || y > 100) {
				System.out.print("Sorry,你猜的数字不在范围之内（范围为1-100），请再重新猜一次吧：");
				y = in.nextInt();
			}

			else if (y > x) {
				System.out.print("Sorry,你输入的数字太大了，请再重新猜一次吧：");
				y = in.nextInt();

			} else if (y < x) {
				System.out.print("Sorry,你输入的数字太小了，请再重新猜一次吧：");
				y = in.nextInt();
			}
		}
		System.out.println("恭喜你，猜对了！你猜的数字是" + y + "你总共猜了" + count + "次！");
	}
}
