package myWeb;

import java.io.*;
import java.net.*;

public class MyTCPServer {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	void getserver(){
		try {
			server = new ServerSocket(8998);
			System.out.println("�������׽����Ѿ������ɹ�");
			while(true){
				System.out.println("�ȴ��û�������......");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
	private void getClientMessage(){
		try {
			while(true){
				System.out.println("�ͻ���: " + reader.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
		try {
			if(reader != null){
				reader.close();
			}
			if(socket != null){
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
	public static void main(String[] args) {
		MyTCPServer tcp = new MyTCPServer();
		tcp.getserver();
	}
	
}
