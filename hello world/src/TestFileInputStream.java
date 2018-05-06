import java.io.*;
public class TestFileInputStream {
	public static void main (String []args){
		int b = 0;
		 FileInputStream in = null;
		 try{
			 in = new FileInputStream("一个文件");
//			 可以读出里面的内容.java
		 }catch(FileNotFoundException e){
			 System.out.println("找不到指定文件");
			 System.exit(-1);
		 }
		 try{
			 long num = 0;
			 while((b=in.read()) != -1){
				 System.out.print((char)b);
				 num++;
			 }
			 in.close();
//			 out.close();
//			 管道用完了记得要关闭
			 System.out.println( );
			 System.out.println("共读取了" +num+ "个字节");
		 }catch(IOException e1){
			 System.out.println("文件读取出错");System.exit(-1);
		 }
	}
}
