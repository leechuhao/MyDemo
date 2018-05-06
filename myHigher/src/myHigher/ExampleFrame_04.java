package myHigher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class ExampleFrame_04 extends JFrame{
	JTable table = new JTable( );
	
	public ExampleFrame_04(){
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
		
		table = new MTable(tableValueV, columNameV);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调整
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//选择模式为单选
		table.setBackground(Color.YELLOW);
		table.setForeground(Color.RED);
		table.setRowHeight(30);
		jsp.setViewportView(table);
		/////////////
		table = new JTable(tableValueV, columNameV);
		table.setRowSelectionInterval(1, 3);
		table.setRowSelectionInterval(5, 5);
		jsp.setViewportView(table);
		//
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		JButton selectAllButton = new JButton("全部选择");
		selectAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				table.selectAll();
			}
		});
		buttonPanel.add(selectAllButton);
		
		JButton clearSelectionButton = new JButton("取消选择");
		clearSelectionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				table.clearSelection();
			}
		});
		buttonPanel.add(clearSelectionButton);
		
		System.out.println("表格共有" + table.getRowCount() + "行    " + table.getColumnCount() + "列");
		System.out.println("共有" + table.getSelectedRowCount() + "行被选中");
		System.out.println("第3行的选择状态为： " + table.isRowSelected(2));
		System.out.println("第5行的选择状态为： " + table.isRowSelected(4));
		System.out.println("被选中的第一行的索引是： " + table.getSelectedRow());
		
		int[] selectedRows = table.getSelectedRows();//会的所有被选中行的索引
		System.out.print("所有被选中行的索引是： ");
		for(int row=0 ; row<selectedRows.length ; row++){
			System.out.print(selectedRows[row] + "  ");
		}
		System.out.println();
		System.out.println("列移动前第2列的名称是： " + table.getColumnName(1));
		System.out.println("列移动前第2行第2列的值是： " + table.getValueAt(1, 1));
		table.moveColumn(1, 5);
		System.out.println("列移动后第2列的名称是： " + table.getColumnName(1));
		System.out.println("列移动后第2行第2列的值是： " + table.getValueAt(1, 1));
		
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
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}
}
