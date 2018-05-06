package lichuhao3115005534.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lichuhao3115005534.dao.Admindao;
import lichuhao3115005534.dao.Userdao;
import lichuhao3115005534.model.User;
import lichuhao3115005534.model.admin;
import lichuhao3115005534.util.DB_util;

import javax.swing.JComboBox;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class LoginView {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("图书管理系统");
		frame.setBounds(100, 100, 401, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("账号：");
		label.setBounds(103, 66, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(103, 104, 54, 15);
		frame.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 101, 103, 21);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(141, 63, 103, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(86, 149, 93, 21);
		comboBox.addItem("普通用户");
		comboBox.addItem("管理员");
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("登录");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = textField.getText();
				String password = passwordField.getText();
				String combo = (String) comboBox.getSelectedItem();
				try {
					com.mysql.jdbc.Connection con = new DB_util().getCon();
					if(combo == "管理员"){
						ResultSet res = Admindao.logining(con, name, password);
						frame.setVisible(false);
						admin ad = new admin();
						while(res.next()){
							ad.set(res.getInt("admin_id"), res.getString("account"), res.getString("password"));
						}
						AdminView.f1();
					}
					if(combo == "普通用户") {
						ResultSet res = Userdao.logining(con, name, password);
						frame.setVisible(false);
						User user = new User();
						while(res.next()){
							user.set(res.getInt("user_id"), res.getString("user_name"), res.getString("user_password"), res.getString("sex"), res.getString("dept"));
						}
						UserView.f2(user);
					}
					JOptionPane.showMessageDialog(null, "登录成功");
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		button.setBounds(189, 148, 93, 23);
		frame.getContentPane().add(button);
	}
}
