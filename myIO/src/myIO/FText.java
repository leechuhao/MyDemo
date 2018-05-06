package myIO;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.naming.*;
import javax.swing.*;

public class FText extends JFrame{
//	private static final long serialVersonUID = 1L; /*序列号*/
	private JPanel jContentPane = null;
	private JTextArea jTextArea = null;
	private JPanel controlPanel = null;
	private JButton openButton = null;
	private JButton closeButton = null;
	
	private JButton getOpenButton(){
		if(openButton == null){
			openButton = new JButton();
			openButton.setText("写入文件");
			openButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File file = new File("word.txt");
					try {
						FileWriter out = new FileWriter(file);
						String s = jTextArea.getText();
						out.write(s);
						out.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
		}
		return openButton;
	}
	private JButton getCloseButton(){
		if(closeButton == null){
			closeButton = new JButton();
			closeButton.setText("读取文件");
			closeButton.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent e) {
					File file = new File("word.txt");
					try {
						FileReader in = new FileReader(file);
						char date[] = new char[1024];
						int len = in.read(date);
						jTextArea.setText(new String(date , 0 , len));
						in.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			});
		}
		return closeButton;
	}
	
	private FText(){
		super();
		initialize();
	}
	
	private void initialize(){
		this.setTitle("JFrame");
		this.setSize(900, 600);
		this.setContentPane(getJContentPane());
	}
	
	private JPanel getJContentPane(){
		if(jContentPane == null){
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTextArea() , BorderLayout.CENTER);
			jContentPane.add(getControlPane(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	private JTextArea getJTextArea() {
		if(jTextArea == null){
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}
	
	private JPanel getControlPane(){
		try{
			if(controlPanel == null){
				controlPanel = new JPanel();
				controlPanel.setLayout( new FlowLayout());
				controlPanel.add(getOpenButton());
				controlPanel.add(getCloseButton());
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return controlPanel;
	}
	
	
	public static void main(String[] args) {
		FText thisclass = new FText();
		thisclass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisclass.setVisible(true);
	}
}
