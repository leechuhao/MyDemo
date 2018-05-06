package myHigher;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class ExampleFrame_03 extends JFrame{
	
	public ExampleFrame_03(){
		super("定义表格");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JScrollPane jsp = new JScrollPane( );
		getContentPane().add(jsp, BorderLayout.CENTER);
		String[] columNames = {"A", "B","C", "D", "E", "F", "G"};
		Vector<String> columNameV = new Vector<>();
		
		for(int col=0 ; col<columNames.length ; col++){
			columNameV.add(columNames[col]);
		}
		Vector<Vector<String>> tableValueV = new Vector<>();
		
		for(int row=1; row<21; row++){
			Vector<String> rowV = new Vector<String>();
			for(int column=0 ; column<columNames.length ; column++){
				rowV.add(columNames[column] + row);
			}
			tableValueV.add(rowV);
		}
		
		JTable table = new MTable(tableValueV, columNameV);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调整
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//选择模式为单选
		table.setBackground(Color.YELLOW);
		table.setForeground(Color.RED);
		table.setRowHeight(30);
		jsp.setViewportView(table);
		
	}
	
	private class MTable extends JTable{
		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames){
			super(rowData, columnNames);
		}
		
		public JTableHeader getTableHeader(){//定义表格头
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false);//设置表格列不可重排
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer)tableHeader.getDefaultRenderer();
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//列名居中显示
			return tableHeader;
		}
		
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass){//定义单元格
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer)super
					.getDefaultRenderer(columnClass);
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
		
		public boolean isCellEditable(int row, int column){
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}
}
