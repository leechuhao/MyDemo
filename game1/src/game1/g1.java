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
			}while(num2 == 0.0);//��do����while��ȷ��num2��Ϊ0
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
			}//�������Ѷ�������˼��ʱ��
			System.out.println("answer:" + answer);
			String again;
			again = JOptionPane.showInputDialog("Play agian");
			if(again.equals("yes")){
				flag = true;
			}//���������yes��ȷ���Ƿ�ѭ���е㲻�ף���ȡ���ͻ��bug
		}while(flag);
	}
}
//��������ô�������ʾ�͸�����