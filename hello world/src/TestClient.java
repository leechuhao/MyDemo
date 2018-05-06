import java.net.*;
import java.io.*;
public class TestClient {
	public static void main (String []args)throws Exception{
		Socket s = new Socket("127.0.0.1",6666);//127.0.0.1是本机IP,6666是端口号，要用1024以上的端口号
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
}
