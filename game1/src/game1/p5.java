package game1;
import javax.swing.*;
import java.io.*;

public class p5 {
	public static void main(String[] args)throws Exception{
		String input ;
		input = JOptionPane.showInputDialog("1 to set password,\n" + "2 to unlock the message");
		File file = new File("password.psswrd");
		if(input.equals("1")){
			//��������
			String p = JOptionPane.showInputDialog("Enter the password to set");
			//�����ļ������
			FileOutputStream outStream = new FileOutputStream(file);
			//�ı������
			PrintWriter out = new PrintWriter(outStream);
			//д��password.psswrd
			out.println(p);
			out.flush();
			out.close();
			outStream.close();
		}
		else{
			//��ȡ��ȷ������
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			String password = buffer.readLine();
			buffer.close();
			String userPass;
			userPass = JOptionPane.showInputDialog("Enter your guess");
			if(password.equals(userPass)){
				JOptionPane.showMessageDialog(null,"CORRECT!!!");
			}else{
				JOptionPane.showMessageDialog(null,"WRONG =C");
			}
		}
	}
}
