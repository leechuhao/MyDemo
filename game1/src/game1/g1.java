package game1;
import javax.swing.*;

public class g1 {
	public static void main(String[]args) throws Exception{
		int difficulty;
		difficulty = Integer.parseInt(JOptionPane.showInputDialog("How good are you\n"+"1 is hell , 10 is easy\n"));
		boolean flag = false;
		do{
			flag = false;
			double num1 = (int) (Math.round((Math.random() * 10)));
			double num2;
			do{
				num2 = (int)(Math.round(Math.random() * 10));
			}while(num2 == 0.0);//用do……while来确保num2不为0
			int sign = (int)(Math.round(Math.random() * 3));
			double answer;
			System.out.println("\n\n*********");
			if(sign == 0){
				System.out.println(num1 + "*" + num2);
				answer = num1 * num2;
			}else if(sign == 1){
				System.out.println(num1 + "/" + num2);
				answer = num1 / num2;
			}else if(sign == 2){
				System.out.println(num1 + "+" + num2);
				answer = num1 + num2;
			}else if(sign == 3){
				System.out.println(num1 + "-" + num2);
				answer = num1 - num2;
			}else{
				System.out.println(num1 + "%" + num2);
				answer = num1 % num2;
			}
			System.out.println("**********\n");
			for(int i = difficulty ; i >= 0 ; i--){
				System.out.println(i + "...");
				Thread.sleep(1000);
			}//根据困难度来调节思考时间
			System.out.println("answer:" + answer);
			String again;
			again = JOptionPane.showInputDialog("Play agian");
			if(again.equals("yes")){
				flag = true;
			}//这里觉得用yes来确定是否循环有点不妥，点取消就会出bug
		}while(flag);
	}
}
//如果可以用窗口来显示就更好了