package shutDown;

import java.io.IOException;

import javax.swing.JOptionPane;

public class MainShutDown {
	public void shutDown(String s){
		Runtime rt = Runtime.getRuntime();
		try {
			Process p = rt.exec("shutdown -s -t " + s);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void cancel(){
		Runtime rt = Runtime.getRuntime();
		try {
			Process p = rt.exec("shutdown -a");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "����в���");
		String ss = JOptionPane.showInputDialog("����ػ�ʱ�䣺����");
		if(!ss.equals("")){
			JOptionPane.showMessageDialog(null, "�����ʱ��Ϊ�� " + ss);
		}
		JOptionPane.showMessageDialog(null, "����Ϊ��ֵ");
	}
}
