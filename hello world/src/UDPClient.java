import java.io.*;
import java.net.*;

public class UDPClient {
	public static void main (String[]args)throws Exception{
		long m = 1116464;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(m);
		byte[] buf = baos.toByteArray();
//		byte[] buf = (new String("hello")).getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,
								new InetSocketAddress("127.0.0.1",1515)
								);
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
	}
}
