package myWeb;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.xml.ws.handler.MessageContext.Scope;

public class MyClient extends JFrame{
	private PrintWriter writer;
	Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc ;
	
	public MyClient(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		//
		setSize(300, 300);
		setVisible(true);
		//
		final JScrollPane scrollPane = new JScrollPane( );
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf,BorderLayout.SOUTH);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//���ı����е���Ϣд����
				writer.println(tf.getText());
				//���ı����е���Ϣ��ʾ���ı�����
				ta.append(tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				//����ı���
				tf.setText("");
			}
		});
	}
	
	private void connect(){
		ta.append("��������\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream(), true);
			ta.append("�������\n");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
	public static void main(String[] args) {
		MyClient client = new MyClient("��������������ݡ�����������");
		client.connect();
	}

}
