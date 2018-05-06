package myIO;

import java.io.*;
import java.util.zip.*;

public class MyZIP {
	private void zip(String fileName , File inputFile)throws Exception{
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fileName));
		zip(out , inputFile , "");
		System.out.println("压缩中…………");
		out.close();
	}
	
	private void zip(ZipOutputStream out , File f , String base)throws Exception{
		if(f.isDirectory()){/*检查是否为目录*/
			File fl[] = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));/*写入此目录的entry*/
			base = base.length() == 0? "":base+"/";/*判断参数是否为空*/
			for(int i=0 ; i<fl.length ;i++){
				zip(out , fl[i] , base+fl[i]);
			}
		}else{
				out.putNextEntry(new ZipEntry(base + "/"));
				FileInputStream in = new FileInputStream(f);
				int b;
				System.out.println(base);
				while((b = in.read()) != -1){/*如果没有到达流的尾部，将字节写入当前ZIP目录*/
					out.write(b);
				}
				in.close();
			}
	}
	
	public static void main(String[] args) {
		MyZIP book = new MyZIP();
		try {
			book.zip("hello.zip", new File("hello"));
			System.out.println("压缩完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
