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
				// TODO 自动生成的方法存根
				//将文本框中的信息写入流
				writer.println(tf.getText());
				//将文本框中的信息显示在文本域内
				ta.append(tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				//清空文本框
				tf.setText("");
			}
		});
	}
	
	private void connect(){
		ta.append("尝试连接\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream(), true);
			ta.append("完成连接\n");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
	public static void main(String[] args) {
		MyClient client = new MyClient("向服务器传送数据。。。。。。");
		client.connect();
	}

}
