import java.net.*;
import java.io.*;
public class TestClient {
	public static void main (String []args)throws Exception{
		Socket s = new Socket("127.0.0.1",6666);//127.0.0.1�Ǳ���IP,6666�Ƕ˿ںţ�Ҫ��1024���ϵĶ˿ں�
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
}
