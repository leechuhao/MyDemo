package myWeb;

import java.net.*;

public class Weather extends Thread{
	String weather = "节目预报，八点有大型晚会，请不要听！";
	int port = 9898;
	InetAddress iaddress = null;
	MulticastSocket socket = null;
	
	public Weather() {
		// TODO 自动生成的构造函数存根
		try {
			iaddress = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			socket.setTimeToLive(1);//指定发送范围是本地网络
			socket.joinGroup(iaddress);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
	public void run() {
		while(true){
			DatagramPacket packet = null;
			byte data[] = weather.getBytes();
			packet = new DatagramPacket(data, data.length, iaddress, port);
//			System.out.println(new String(data));
			try {
				socket.send(packet);
				sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace( );
			}
		}
	}
	
	public static void main(String[] args) {
		Weather w = new Weather();
		w.start();
	}
	
}
