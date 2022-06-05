package Client.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Client.Connection_Login.*;
import Client.User.ManagementUser;
import Server.InterFace;

import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private JPasswordField tfpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAdmin() {
		setResizable(false);
		setRootPaneCheckingEnabled(false);
		setForeground(new Color(255, 140, 0));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 899, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 893, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setBounds(369, 104, 187, 29);
		lblNewLabel_1.setBackground(new Color(244, 164, 96));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		panel.add(lblNewLabel_1);
		
		tfuser = new JTextField();
		tfuser.setForeground(new Color(30, 144, 255));
		tfuser.setBounds(369, 144, 410, 33);
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfuser.setOpaque(false);
		tfuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(30, 144, 255)));
		panel.add(tfuser);
		tfuser.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setBounds(369, 324, 149, 33);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean bl = true;
				String loi = "";
				if (tfuser.getText().equals("")) {
					bl = false;
					loi+= "Vui lòng nhập Tài khoản !\n";
				}
				if (tfpassword.getText().equals("")) {
					bl = false;
					loi+= "Vui lòng nhập Mật khoản !\n";
				}
				if (bl == true) {
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						int check = c.loginAdmin(tfuser.getText(), tfpassword.getText());
						if (check == 1) {
							ManagementAdmin mana = new ManagementAdmin();
							mana.setVisible(true);
							dispose();
						}
						else if (check == 0) {
							JOptionPane.showMessageDialog( null, "Tài khoản hoặc mật khẩu không đúng !" , "Message", 1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
					}
				}
				else {
					JOptionPane.showMessageDialog( null, loi , "Message", 1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setBounds(369, 216, 135, 22);
		lblPassword.setForeground(SystemColor.controlDkShadow);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBackground(new Color(244, 164, 96));
		panel.add(lblPassword);
		
		JLabel lblLogh = new JLabel("Đăng Nhập Quản Trị Viên");
		lblLogh.setBounds(295, 0, 598, 44);
		lblLogh.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogh.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogh.setOpaque(true);
		lblLogh.setBackground(new Color(112, 128, 144));
		lblLogh.setForeground(new Color(255, 255, 255));
		panel.add(lblLogh);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChooseUserLogin chul = new ChooseUserLogin();
				chul.setVisible(true);
			}
		});
		btnCancel.setBounds(561, 324, 149, 33);
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBackground(new Color(240, 128, 128));
		panel.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/images/images (3)3333333333.png"));
		lblNewLabel.setBounds(34, 85, 214, 240);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("src/images/circular-shape-silhouette111.png"));
		label_1.setBounds(28, 96, 240, 240);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 296, 432);
		label.setOpaque(true);
		label.setForeground(new Color(255, 165, 0));
		label.setBackground(new Color(70, 130, 180));
		panel.add(label);
		
		tfpassword = new JPasswordField();
		tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfpassword.setForeground(new Color(30, 144, 255));
		tfpassword.setOpaque(false);
		tfpassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(30, 144, 255)));
		tfpassword.setBounds(369, 249, 410, 33);
		panel.add(tfpassword);
//		setUndecorated(true);
	}
}
