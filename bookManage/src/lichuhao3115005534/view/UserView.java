package lichuhao3115005534.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import lichuhao3115005534.dao.Bookdao;
import lichuhao3115005534.dao.LendOrRe;
import lichuhao3115005534.model.User;
import lichuhao3115005534.util.DB_util;

import javax.swing.JLabel;
import javax.swing.JButton;

public class UserView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static User user;

	/**
	 * Launch the application.
	 */
	public static void f2(User user) {
		UserView.user = user;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView window = new UserView();
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
	public UserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("个人信息");
		label.setBounds(184, 10, 54, 15);
		panel.add(label);
		
		JLabel lblid = new JLabel("用户ID： ");
		lblid.setBounds(72, 51, 54, 15);
		panel.add(lblid);
		
		JLabel lblname = new JLabel("用户姓名：");
		lblname.setBounds(72, 88, 70, 15);
		panel.add(lblname);
		
		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(72, 128, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("专业");
		label_2.setBounds(72, 166, 60, 15);
		panel.add(label_2);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(184, 51, 54, 15);
		lblId.setText( String.valueOf(user.getId()));
		panel.add(lblId);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(184, 88, 54, 15);
		lblName.setText(user.getName());
		panel.add(lblName);
		
		JLabel lblSex = new JLabel("sex");
		lblSex.setBounds(184, 128, 54, 15);
		lblSex.setText(user.getSex());
		panel.add(lblSex);
		
		JLabel lblDept = new JLabel("dept");
		lblDept.setBounds(184, 166, 54, 15);
		lblDept.setText(user.getDept());
		panel.add(lblDept);
		
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
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		JLabel label1 = new JLabel("借阅/归还图书");
		label1.setBounds(185, 10, 100, 15);
		panel_2.add(label1);
		
		JLabel lblBookid = new JLabel("书的编号");
		lblBookid.setBounds(74, 66, 54, 15);
		panel_2.add(lblBookid);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 63, 66, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(261, 63, 66, 18);
		comboBox1.addItem("借");
		comboBox1.addItem("还");
		panel_2.add(comboBox1);
		
		JButton button = new JButton("确定");
		button.setBounds(160, 120, 93, 23);
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
				int bookID = Integer.valueOf(textField_1.getText());
				int userID = user.getId();
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String day = sdf.format(date);
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					int id = LendOrRe.checkid(con);
					LendOrRe.addLend(con, id, bookID, userID, day);
					JOptionPane.showMessageDialog(null, "借阅成功");
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		panel_2.add(button);
	//////////////////////////////////////////////////////////////////////////////////	
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("用户");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("个人信息");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
			}
		});
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("图书");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("查找图书");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("借/还图书");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("关于");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("作者信息");
		menu_2.add(menuItem_3);
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "学号：3115005534\n"
						+ "姓名： 李楚豪");
			}
		});
	}

}
