import java.io.*;
public class TestBufferStream {
	public static void main(String []args){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\brain\\Desktop\\dat1.txt"));
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/brain/Desktop/dat1.txt"));
//			Reader 并不能创建文件
			String s = null;
			for(int i = 1;i <= 100;i++){
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s = br.readLine()) != null){
				System.out.println(s);
			}
			bw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
