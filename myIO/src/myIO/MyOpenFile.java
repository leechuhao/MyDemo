package myIO;

import java.io.*;

public class MyOpenFile {
	public static void main(String[] args) {
		File file = new File("word.txt");
		
//		try {
//			FileOutputStream out = new FileOutputStream(file);
//			byte []buy = "�����ĵ�".getBytes();
//			out.write(buy);
//			out.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			FileInputStream in = new FileInputStream(file);
			byte []six = new byte[1024];
			int len = in.read(six);
			System.out.println("�ļ��е���Ϣ�� :    " + new String(six ,0 ,len));
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
//		if(file.exists()){
//			file.delete();
//			System.out.println("�ļ��Ѿ���ɾ��");
//		}else{
//			try{
//				file.createNewFile();
//				System.out.println("�ļ�������");
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
	}
}
