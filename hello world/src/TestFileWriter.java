import java.io.*;
public class TestFileWriter {
	public static void main (String [] args){
		FileWriter fw = null;
//		Reader��Writer�����ַ���
		try{
			fw = new FileWriter("C:\\Users\\brain\\workspace\\fw.dat");
//			�������µ��ļ�
			for(int c = 0;c <65523;c++){
				fw.write(c);
			}
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("�ļ�д�����");
			System.exit(-1);
		}
	}
}



