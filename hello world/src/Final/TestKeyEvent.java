package Final;

import java.awt.*;
import java.awt.event.*;

public class TestKeyEvent {
	public static void main (String[]args){
		new MyFrame().launchFrame();;
	}
}

class MyFrame extends Frame{
	public void launchFrame(){
		setSize(500,500);
		setLocation(300,300);
		addKeyListener(new MyMonitor());
		setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
	}
}

class MyMonitor extends KeyAdapter{
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			System.out.println("up!!!!!!");
		}
	}
}