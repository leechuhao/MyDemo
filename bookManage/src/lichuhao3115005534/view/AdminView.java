package lichuhao3115005534.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import lichuhao3115005534.dao.Bookdao;
import lichuhao3115005534.dao.Userdao;
import lichuhao3115005534.model.Book;
import lichuhao3115005534.model.User;
import lichuhao3115005534.util.DB_util;

import javax.swing.JButton;

public class AdminView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPassword;
	private JTextField textField_6;
	private JTextField txtId_1;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void f1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("管理员页面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎使用管理员页面");
		lblNewLabel.setBounds(140, 80, 168, 52);
		panel.add(lblNewLabel);

		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(45, 86, 331, 144);
		panel_1.add(textPane);
		
		textField = new JTextField();
		textField.setText("图书信息");
		textField.setBounds(29, 41, 226, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					ResultSet res = Bookdao.findBook(con, textField.getText());
					StringBuffer sbf = new StringBuffer();
					while(res.next()){
						sbf.append("id: "+ res.getInt("book_id") + "     bookname: "+ res.getString("book_name")+
								"      booktype: "+ res.getString("book_type") + 
								"      bookstate: "+ res.getString("book_state")+"\n");
					}
					textPane.setText(sbf.toString());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					ResultSet res = Bookdao.findBook(con, textField.getText());
					StringBuffer sbf = new StringBuffer();
					while(res.next()){
						sbf.append("id: "+ res.getInt("book_id") + "     bookname: "+ res.getString("book_name")+
								"      booktype: "+ res.getString("book_type") + 
								"      bookstate: "+ res.getString("book_state")+"\n");
					}
					textPane.setText(sbf.toString());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					ResultSet res = Bookdao.findBook(con, textField.getText());
					StringBuffer sbf = new StringBuffer();
					while(res.next()){
						sbf.append("id: "+ res.getInt("book_id") + "     bookname: "+ res.getString("book_name")+
								"      booktype: "+ res.getString("book_type") + 
								"      bookstate: "+ res.getString("book_state")+"\n");
					}
					textPane.setText(sbf.toString());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(293, 41, 65, 21);
		comboBox.addItem("书名");
		comboBox.addItem("书号");
		panel_1.add(comboBox);
		
		final JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		panel2.setVisible(false);
		
		JLabel label = new JLabel("添加图书");
		label.setBounds(185, 10, 54, 15);
		panel2.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("id");
		textField_1.setBounds(55, 54, 66, 21);
		panel2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("书名");
		textField_2.setBounds(173, 54, 66, 21);
		panel2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("书类");
		textField_3.setBounds(310, 54, 66, 21);
		panel2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("确认");
		button.setBounds(162, 113, 93, 23);
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int id = Integer.valueOf(textField_1.getText());
				String name = textField_2.getText();
				String type = textField_3.getText();
				Book book = new Book().set(id, name, type, "可借");
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					Bookdao.addBook(con, book);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		panel2.add(button);
		
		final JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);
		panel3.setVisible(false);
		
		JLabel labelde = new JLabel("删除图书");
		labelde.setBounds(184, 10, 54, 15);
		panel3.add(labelde);
		
		final JTextField label_1 = new JTextField();
		label_1.setText("编号");
		label_1.setBounds(73, 62, 60, 15);
		panel3.add(label_1);
		label_1.setColumns(10);
		
		JButton button1 = new JButton("确认");
		button1.setBounds(267, 58, 93, 23);
		button1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int id = Integer.valueOf(label_1.getText());
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					Bookdao.deleteBook(con, id);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		panel3.add(button1);
		
		final JPanel panel4 = new JPanel();
		panel4.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel4);
		panel4.setLayout(null);
		panel4.setVisible(false);
		
		JLabel labelal = new JLabel("修改图书");
		labelal.setBounds(191, 10, 54, 15);
		panel4.add(labelal);
		
		textField_4 = new JTextField();
		textField_4.setText("编号");
		textField_4.setBounds(66, 49, 66, 21);
		panel4.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("修改内容");
		textField_5.setBounds(159, 49, 66, 21);
		panel4.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(272, 49, 80, 21);
		comboBox1.addItem("书名");
		comboBox1.addItem("书类");
		comboBox1.addItem("书的状态");
		panel4.add(comboBox1);
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.setBounds(164, 105, 93, 23);
		btnNewButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int id = Integer.valueOf(textField_4.getText());
				String name = textField_5.getText();
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					Bookdao.alterBook(con, id, name);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		panel4.add(btnNewButton);
		
		final JPanel panel5 = new JPanel();
		panel5.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel5);
		panel5.setLayout(null);
		panel5.setVisible(false);
		
		txtId = new JTextField();
		txtId.setText("id");
		txtId.setBounds(70, 67, 66, 21);
		panel5.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(176, 67, 66, 21);
		panel5.add(txtName);
		txtName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("password");
		txtPassword.setBounds(277, 67, 66, 21);
		panel5.add(txtPassword);
		txtPassword.setColumns(10);
		
		final JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(123, 115, 55, 21);
		comboBox2.addItem("男");
		comboBox2.addItem("女");
		panel5.add(comboBox2);
		
		textField_6 = new JTextField("计算机系");
		textField_6.setBounds(217, 115, 66, 21);
		panel5.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel labeladd = new JLabel("申请用户");
		labeladd.setBounds(176, 10, 54, 15);
		panel5.add(labeladd);
		
		JButton btnY = new JButton("Y");
		btnY.setBounds(145, 165, 93, 23);
		btnY.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int id = Integer.valueOf(txtId.getText());
				String name = txtName.getText();
				String password = txtPassword.getText();
				String sex = (String) comboBox2.getSelectedItem();
				String dept = textField_6.getText();
				User user = new User().set(id, name, password, sex, dept);
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					Userdao.add(con, user);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		panel5.add(btnY);
		
		final JPanel panel6 = new JPanel();
		panel6.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel6);
		panel6.setLayout(null);
		panel6.setVisible(false);
		
		JLabel labelalter = new JLabel("修改用户信息");
		labelalter.setBounds(169, 10, 113, 15);
		panel6.add(labelalter);
		
		txtId_1 = new JTextField();
		txtId_1.setText("id");
		txtId_1.setBounds(59, 46, 66, 21);
		panel6.add(txtId_1);
		txtId_1.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText("修改的信息");
		textField_7.setBounds(169, 46, 66, 21);
		panel6.add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setBounds(280, 46, 100, 21);
		comboBox3.addItem("name");
		comboBox3.addItem("password");
		comboBox3.addItem("sex");
		comboBox3.addItem("dept");
		panel6.add(comboBox3);
		
		JButton btnYe = new JButton("Y");
		btnYe.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int id = Integer.valueOf(txtId_1.getText());
				String name = textField_7.getText();
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					Userdao.alterSex(con, id, name);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		panel6.add(btnYe);
		
		final JPanel panel7 = new JPanel();
		panel7.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel7);
		panel7.setLayout(null);
		panel7.setVisible(false);
		
		JLabel lblDele = new JLabel("删除用户");
		lblDele.setBounds(185, 10, 54, 15);
		panel7.add(lblDele);
		
		textField_8 = new JTextField();
		textField_8.setBounds(113, 71, 66, 21);
		panel7.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(70, 74, 54, 15);
		panel7.add(lblId);
		
		JButton btnYes = new JButton("yes");
		btnYes.setBounds(242, 70, 93, 23);
		btnYes.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int id = Integer.valueOf(textField_8.getText());
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					Userdao.delete(con, id);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		panel7.add(btnYes);
		/////////////////////////////////////////////////////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("图书管理");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("查找图书");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				panel7.setVisible(false);
				
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("添加图书");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				panel7.setVisible(false);
				
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenuItem menuItem_6 = new JMenuItem("删除图书");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				panel7.setVisible(false);
				
			}
		});
		mnNewMenu.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("修改图书");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(true);
				panel5.setVisible(false);
				panel6.setVisible(false);
				panel7.setVisible(false);
				
			}
		});
		mnNewMenu.add(menuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("用户管理");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("申请用户");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(true);
				panel6.setVisible(false);
				panel7.setVisible(false);
				
			}
		});
		mnNewMenu_1.add(menuItem_2);
		
		JMenuItem menuItem_4 = new JMenuItem("用户信息修改");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(true);
				panel7.setVisible(false);
				
			}
		});
		mnNewMenu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("删除用户");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				panel7.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(menuItem_5);
		
		JMenu menu = new JMenu("关于");
		menuBar.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("作者信息");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "学号：3115005534\n"
						+ "姓名： 李楚豪");
			}
		});
		menu.add(menuItem_3);

	}
}
