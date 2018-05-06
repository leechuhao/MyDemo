package myWeb;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Receive extends JFrame implements Runnable,ActionListener{
	int port = 9898;
	String add = "224.255.10.0";
	InetAddress group = null;
	MulticastSocket socket = null;
	JButton ince = new JButton("��ʼ����");
	JButton stop = new JButton("ֹͣ����");
	JTextArea inceAr = new JTextArea(10, 10);
	JTextArea inced = new JTextArea(10, 10);
	JScrollPane jsp = new JScrollPane(inced);
	Thread thread;
	boolean b = false;
	
	public Receive(){
		super("�㲥���ݱ�");		
		thread = new Thread(this);		
		ince.addActionListener(this);
		stop.addActionListener(this);
		inceAr.setForeground(Color.blue);
		setBounds(100, 50, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(360, 300);
		
		JPanel north = new JPanel();
		north.add(ince);
		north.add(stop);
		add(north, BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		center.add(inceAr);
		center.add(jsp);
		add(center, BorderLayout.CENTER);
		//ˢ��
		validate();
		
		try {
			group = InetAddress.getByName(add);
			socket = new MulticastSocket(port);
			socket.joinGroup(group);//����㲥��
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
		}
	
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource() == ince){
			ince.setBackground(Color.red);
			stop.setBackground(Color.yellow);
			if(!(thread.isAlive())){
				thread = new Thread(this);
			}
			thread.start();
			b = false;
		}
		if(e.getSource() == stop){
			ince.setBackground(Color.yellow);
			stop.setBackground(Color.red);
			b = true;
		}
		
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
			byte data[] = new byte[1024];
			DatagramPacket packet = null;
			packet = new DatagramPacket(data, data.length, group, port);
			try {
				socket.receive(packet);
				String message = new String(packet.getData(), 0, packet.getLength());
				inceAr.setText("���ڽ��ܵ����� �� \n" + message);
				inced.append(message + "\n");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace( );
			}
			if(b == true){
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Receive rec = new Receive();
//		rec.setSize(460, 200);
	}
	
}
