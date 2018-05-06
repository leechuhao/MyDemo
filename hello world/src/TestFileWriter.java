import java.io.*;
public class TestFileWriter {
	public static void main (String [] args){
		FileWriter fw = null;
//		Reader和Writer都是字符流
		try{
			fw = new FileWriter("C:\\Users\\brain\\workspace\\fw.dat");
//			创建了新的文件
			for(int c = 0;c <65523;c++){
				fw.write(c);
			}
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("文件写入错误");
			System.exit(-1);
		}
	}
}



