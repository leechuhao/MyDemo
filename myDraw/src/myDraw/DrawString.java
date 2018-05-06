package myDraw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.xml.crypto.Data;

public class DrawString extends JFrame{//???????????
	
	private Shape rect;
	private Font font;
	private Data data;
	
	public DrawString(){
		rect = new Rectangle(10, 10, 200, 80);
		font = new Font("宋体", font.BOLD, 16);
		data = new Data() {
		};
		this.setSize(230, 140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new CanvasPanel());
		this.setTitle("绘图文本");
	}
	
	public static void main(String[] args) {
		new DrawString().setVisible(true);
	}

	class CanvasPanel extends Canvas{
		public void paint(Graphics g){
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.CYAN);
			g2.fill(rect);
			g2.setColor(Color.BLUE);
			g2.setFont(font);
			g2.drawString("现在时间是", 20, 30);
			g2.drawString(String.format("%tr", data), 50, 60);
		}
		
	}
	
}
