package myWeb;

import java.net.InetAddress;

public class Address {
	public static void main(String[] args) {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			String localname = ip.getHostName();
			String localip = ip.getHostAddress();
			System.out.println("�������� " + localname);
			System.out.println("����IP�� " + localip);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
}
