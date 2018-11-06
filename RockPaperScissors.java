import java.util.*;

class Person {
    public String name;
    public int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String play(int i) {
        return i == 1?"剪刀":(i == 2?"石头":"布");
    }
}

public class RockPaperScissors {
	
	public static void main(String[] args) {

		int num = 0;

        System.out.println("*****************\n****猜拳, 开始****\n*****************");
        System.out.println("出拳规则:1.剪刀 2.石头 3.布");
        System.out.println("请选择对方角色<1:刘备 2:孙权 3:曹操>");

        Scanner scanner = new Scanner(System.in);
		
		//new一个对手
		Person opponent = new Person("",0);
        int nameIndex = scanner.nextInt();
        while (true){
            if (nameIndex == 1){
                opponent.name = "刘备";
                break;
            }else if (nameIndex == 2){
                opponent.name  = "孙权";
                break;
            }else if (nameIndex == 3){
                opponent.name = "曹操";
                break;
            }else {
                System.out.println("输入错误!输入对方角色<1:刘备 2:孙权 3:曹操>");
                nameIndex = scanner.nextInt();
            }
        }

		System.out.println("请输入您的姓名:");
        Scanner scanner1 = new Scanner(System.in);
        Person self = new Person(scanner1.next(),0);
        System.out.println(self.name + " VS " +opponent.name);
        System.out.println("要开始游戏吗?<y/n>");

        Scanner scanner2 = new Scanner(System.in);
        String option = scanner2.next();
        while (option.equals("y")){
            System.out.println("请出拳:1、剪刀 2、石头 3、布");
            Scanner scanner3 = new Scanner(System.in);
            int select = scanner3.nextInt();
            String result1;
            if (select!=1&&select!=2&&select!=3){
                System.out.println("输入错误!请输入出拳规则:1、剪刀 2、石头 3、布");
                select = scanner3.nextInt();
            }
            result1 = self.play(select);
            System.out.println(self.name+"出:"+result1);
            String result2 = opponent.play(new Random().nextInt(3)+1);
            System.out.println(opponent.name+"出:"+result2);


            if (result1.equals(result2)){
                System.out.println("和局");
            }else if (result1.equals("剪刀")&&result2.equals("布")||result1.equals("石头")&&result2.equals("剪刀")||result1.equals("布")&&result2.equals("石头")){
                System.out.println("你赢了! "+self.name+"赢!");
                self.score += 1;
            }else {
                System.out.println("你输了! "+opponent.name+"赢!");
                opponent.score += 1;
            }
            num++;
            System.out.println("需要进行下一局吗?<y/n>");
            option = scanner2.next();
            if (option.equals("n")){
                System.out.println("=================");
                System.out.println("共进行"+num+"局\n"+self.name+"得分为"+self.score+","+opponent.name+"得分为"+opponent.score +"\n");
                if (self.score>opponent.score){
                    System.out.println(self.name+"赢!"+self.name+"好棒!");
                }else if (self.score == opponent.score){
                    System.out.println("平局!");
                }else {
                    System.out.println(opponent.name+"赢!"+self.name+"笨蛋!");
                }
                System.out.println("感谢你的使用!");
            }else if (!option.equals("y")){
                System.out.println("输入错误,请重新输入!");
                System.out.println("需要进行下一局吗?<y/n>");
                option = scanner2.next();
        	}
		}
	}
}
