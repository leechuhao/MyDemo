import java.io.*;
import java.net.*;

public class UDPServer {
	public static void main (String []args )throws Exception{
		byte buf[] = new byte [1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		DatagramSocket ds = new DatagramSocket(1515);
		while(true){
			ds.receive(dp);
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readLong());
//			System.out. println(new String(buf,0,dp.getLength()));
		}
	}
}
