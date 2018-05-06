package shutDown;

import java.io.IOException;

import javax.swing.JOptionPane;

public class MainShutDown {
	public void shutDown(String s){
		Runtime rt = Runtime.getRuntime();
		try {
			Process p = rt.exec("shutdown -s -t " + s);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
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
//		JOptionPane.showMessageDialog(null, "请进行操作");
		String ss = JOptionPane.showInputDialog("输入关机时间：！！");
		if(!ss.equals("")){
			JOptionPane.showMessageDialog(null, "输入的时间为： " + ss);
		}
		JOptionPane.showMessageDialog(null, "不能为空值");
	}
}
