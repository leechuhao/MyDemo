package myIO;

import java.io.*;
import java.util.zip.*;

public class MyZIP {
	private void zip(String fileName , File inputFile)throws Exception{
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fileName));
		zip(out , inputFile , "");
		System.out.println("ѹ���С�������");
		out.close();
	}
	
	private void zip(ZipOutputStream out , File f , String base)throws Exception{
		if(f.isDirectory()){/*����Ƿ�ΪĿ¼*/
			File fl[] = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));/*д���Ŀ¼��entry*/
			base = base.length() == 0? "":base+"/";/*�жϲ����Ƿ�Ϊ��*/
			for(int i=0 ; i<fl.length ;i++){
				zip(out , fl[i] , base+fl[i]);
			}
		}else{
				out.putNextEntry(new ZipEntry(base + "/"));
				FileInputStream in = new FileInputStream(f);
				int b;
				System.out.println(base);
				while((b = in.read()) != -1){/*���û�е�������β�������ֽ�д�뵱ǰZIPĿ¼*/
					out.write(b);
				}
				in.close();
			}
	}
	
	public static void main(String[] args) {
		MyZIP book = new MyZIP();
		try {
			book.zip("hello.zip", new File("hello"));
			System.out.println("ѹ�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
