package myIO;

import java.io.*;
import java.util.zip.*;

public class MyZIPPress {
	
	public static void main(String[] args) {
		ZipInputStream in ;
		try {
			in = new ZipInputStream(new FileInputStream("hello.zip"));
			ZipEntry entry = in.getNextEntry();
			while(	((entry = in.getNextEntry()) != null)  &&  !entry.isDirectory()){
				File file = new File(entry.getName());
				if(!file.exists()){
					file.createNewFile();
				}
				in.closeEntry();
				System.out.println(entry.getName() + "Ω‚—π≥…π¶");
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
