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
		super("������");
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ�����
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//ѡ��ģʽΪ��ѡ
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
		JButton selectAllButton = new JButton("ȫ��ѡ��");
		selectAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				table.selectAll();
			}
		});
		buttonPanel.add(selectAllButton);
		
		JButton clearSelectionButton = new JButton("ȡ��ѡ��");
		clearSelectionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				table.clearSelection();
			}
		});
		buttonPanel.add(clearSelectionButton);
		
		System.out.println("�����" + table.getRowCount() + "��    " + table.getColumnCount() + "��");
		System.out.println("����" + table.getSelectedRowCount() + "�б�ѡ��");
		System.out.println("��3�е�ѡ��״̬Ϊ�� " + table.isRowSelected(2));
		System.out.println("��5�е�ѡ��״̬Ϊ�� " + table.isRowSelected(4));
		System.out.println("��ѡ�еĵ�һ�е������ǣ� " + table.getSelectedRow());
		
		int[] selectedRows = table.getSelectedRows();//������б�ѡ���е�����
		System.out.print("���б�ѡ���е������ǣ� ");
		for(int row=0 ; row<selectedRows.length ; row++){
			System.out.print(selectedRows[row] + "  ");
		}
		System.out.println();
		System.out.println("���ƶ�ǰ��2�е������ǣ� " + table.getColumnName(1));
		System.out.println("���ƶ�ǰ��2�е�2�е�ֵ�ǣ� " + table.getValueAt(1, 1));
		table.moveColumn(1, 5);
		System.out.println("���ƶ����2�е������ǣ� " + table.getColumnName(1));
		System.out.println("���ƶ����2�е�2�е�ֵ�ǣ� " + table.getValueAt(1, 1));
		
	}
	
	private class MTable extends JTable{
		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames){
			super(rowData, columnNames);
		}
		
		public JTableHeader getTableHeader(){//������ͷ
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false);//���ñ���в�������
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer)tableHeader.getDefaultRenderer();
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//����������ʾ
			return tableHeader;
		}
		
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass){//���嵥Ԫ��
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
