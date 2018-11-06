import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimulatedLight {

	public static void main(String[] args) {
		// 答案
		Map<Integer, String> answerMap = new LinkedHashMap<Integer, String>();
		answerMap.put(1, "近光灯");
		answerMap.put(2, "远光灯");
		answerMap.put(3, "交替远近光灯");
		answerMap.put(4, "灯开一档打开危险灯");
		// 考题
		List<Map<String, String>> subjectMap = new ArrayList<Map<String, String>>();
		Map<String, String> temp = new HashMap<String, String>(2);
		temp.put("title", "夜间同方向近距离跟车行驶");
		temp.put("result", "1");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "在有路灯照明良好的道路行驶");
		temp.put("result", "1");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "通过路口");
		temp.put("result", "1");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "会车");
		temp.put("result", "1");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "在路边临时停车");
		temp.put("result", "4");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "通过急弯、坡路、拱桥、人行横道或者没有交通信号灯控制的路口");
		temp.put("result", "3");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "超车");
		temp.put("result", "3");
		subjectMap.add(temp);
		temp = new HashMap<String, String>(2);
		temp.put("title", "进入无照明或照明不良的道路行驶");
		temp.put("result", "2");
		subjectMap.add(temp);
		
		Scanner sc = new Scanner(System.in);
		do{
			// 是否考试合格
			boolean qualified = true;
			// 错误原因
			StringBuffer error = new StringBuffer();
			
			System.out.println("\n*********** 开始进入考试 ***********\n");
			System.out.println("* 请开启前照灯");
			for(int key : answerMap.keySet()){
				System.out.print("[" +  key + "]" + answerMap.get(key) + "\t\t");
			}
			System.out.print("\n请输入答案：");
			int answer = sc.nextInt();
			if(answer != 1){
				qualified = false;
				error.append("开启前照灯，答题错误。正确答案：近光灯\n");
			}
			System.out.println();
			
			// 随机考试开始
			// 已选题号，保证每次题目不同
			List<Integer> checkNum = new ArrayList<Integer>();
			for(int i=1; i<=5; i++){
				// 随机拿题号
				int num = (int)(Math.random()*subjectMap.size());
				while(checkNum.contains(num)){
					num = (int)(Math.random()*subjectMap.size());
				}
				checkNum.add(num);
				// 根据题号，获取题目和答案
				Map<String, String> subject = subjectMap.get(num);
				String title = subject.get("title");
				int result = Integer.parseInt(subject.get("result"));
				// 开始答题
				System.out.println("* " + title);
				for(int key : answerMap.keySet()){
					System.out.print("[" + key + "]" + answerMap.get(key) + "\t\t");
				}
				System.out.print("\n请输入答案：");
				answer = sc.nextInt();
				if(answer != result){
					qualified = false;
					error.append(title+"，答题错误。正确答案："+answerMap.get(result)+"\n");
				}
				System.out.println();
			}
			
			System.out.println("模拟灯光结束，请关闭所有灯光！\n");
			System.out.println("考试结束，您的考试成绩是否合格：" + (qualified ? "合格" : "不合格"));
			if(qualified){
				System.out.println("恭喜你，考试通过！");
			}else{
				System.out.println("很遗憾，考试不合格，您的错误原因是：");
				System.out.println(error.toString());
			}
			
			System.out.print("考试结束。是否继续(y/n)？");
			String next = sc.next();
			if("n".equals(next) || "N".equals(next)){
				break;
			}
		}while(true);
		System.out.println("bye~");
	}
	
}
