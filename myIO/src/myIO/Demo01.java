package myIO;

import java.io.*;

public class Demo01 {
	public static void main(String[] args) {
		File file = new File("Demo.txt");
		try {
			FileOutputStream fos= new FileOutputStream(file);
			DataOutputStream ds = new DataOutputStream(fos);
//			ds.writeUTF("writeUTF");
			ds.writeChars("writeChars");
//			ds.writeBytes("writeBytes");
			ds.close();
			
			FileInputStream fs = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fs);
//			System.out.println(dis.readUTF());
			System.out.println(dis.readChar());
//			System.out.println(dis.readByte());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
