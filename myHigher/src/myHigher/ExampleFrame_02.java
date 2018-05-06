package myHigher;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;


public class ExampleFrame_02 extends JFrame{
	public ExampleFrame_02(){
		super();
		setTitle("创建不可以滚动的表格");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		String []columnNames = {"A", "B"};
//		String [][]tableValues = {	{"A1", "B1"}, {"A2", "B2"}, 
//				{"A3", "B3"}, {"A4", "B4"}, {"A5", "B5"}};
//		JTable table = new JTable(tableValues, columnNames);
//		JScrollPane sp = new JScrollPane(table);
//		getContentPane().add(sp, BorderLayout.CENTER);
		
		Vector<String> columnNameV = new Vector<>();
		columnNameV.add("A");
		columnNameV.add("B");
		Vector<Vector<String>> tableValueV = new Vector<>();//二维表
		for(int row=1; row<6; row++){
			Vector<String> rowV = new Vector<>();//行
			rowV.add("A" + row);
			rowV.add("B" + row);
			tableValueV.add(rowV);
		}
		JTable table = new JTable(tableValueV,columnNameV);
		getContentPane().add(table, BorderLayout.CENTER);
		JTableHeader th = table.getTableHeader();//表格头
		getContentPane().add(th, BorderLayout.NORTH);
		
		table.setAutoResizeMode(3);
	}
	
	public static void main(String[] args) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
}
