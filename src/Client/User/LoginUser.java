package Client.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import Client.Connection_Login.*;
import Server.InterFace;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;

public class LoginUser extends JFrame {

	private JPanel contentPane;
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private JTextField tfuser;
	private JPasswordField tfpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
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
	public LoginUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 862, 432);
		contentPane.add(panel);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản");
		lblTnTiKhon.setForeground(SystemColor.controlDkShadow);
		lblTnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTnTiKhon.setBackground(new Color(244, 164, 96));
		lblTnTiKhon.setBounds(369, 105, 188, 22);
		panel.add(lblTnTiKhon);
		
		tfuser = new JTextField();
		tfuser.setForeground(new Color(34, 139, 34));
		tfuser.setOpaque(false);
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfuser.setColumns(10);
		tfuser.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(60, 179, 113)));
		tfuser.setBounds(369, 144, 374, 33);
		panel.add(tfuser);
		
		JButton btnngNhp = new JButton("Đăng nhập");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Boolean bl = true;
				String loi = "";
				if (tfuser.getText().equals("")) {
					bl = false;
					loi+= "Vui lòng nhập Tài khoản !\n";
				}
				if (tfpass.getText().equals("")) {
					bl = false;
					loi+= "Vui lòng nhập Mật khẩu !\n";
				}
				if (bl == true) {
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						int check = c.loginUser(tfuser.getText(), tfpass.getText());
						if (check == 1) {
							dispose();
							ManagementUser bk = new ManagementUser();
							bk.labeltk.setText(tfuser.getText());
							bk.labelmk.setText(tfpass.getText());
							bk.setVisible(true);
						}
						else if (check == 0) {
							JOptionPane.showMessageDialog( null, "Tài Khoản hoặc mật khẩu không đúng" , "Message", 1);
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
		btnngNhp.setForeground(Color.WHITE);
		btnngNhp.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnngNhp.setBackground(new Color(70, 130, 180));
		btnngNhp.setBounds(369, 324, 149, 33);
		panel.add(btnngNhp);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setForeground(SystemColor.controlDkShadow);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMtKhu.setBackground(new Color(244, 164, 96));
		lblMtKhu.setBounds(369, 216, 135, 22);
		panel.add(lblMtKhu);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("src/images/iconfinder_38_Target_Audience_1688838111.png"));
		label_6.setBounds(24, 105, 246, 203);
		panel.add(label_6);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("src/images/circular-shape-silhouette111.png"));
		label_2.setBounds(30, 81, 258, 254);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(30, 81, 240, 240);
		panel.add(label_4);
		
		JLabel lblngNhpKhch = new JLabel("Đăng Nhập Khách Hàng");
		lblngNhpKhch.setOpaque(true);
		lblngNhpKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhpKhch.setForeground(Color.WHITE);
		lblngNhpKhch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblngNhpKhch.setBackground(new Color(112, 128, 144));
		lblngNhpKhch.setBounds(295, 0, 567, 44);
		panel.add(lblngNhpKhch);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChooseUserLogin chul = new ChooseUserLogin();
				chul.setVisible(true);
			}
		});
		btnHy.setForeground(Color.WHITE);
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBackground(new Color(240, 128, 128));
		btnHy.setBounds(561, 324, 149, 33);
		panel.add(btnHy);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(true);
		label_5.setForeground(new Color(255, 165, 0));
		label_5.setBackground(new Color(60, 179, 113));
		label_5.setBounds(0, 0, 296, 432);
		panel.add(label_5);
		
		tfpass = new JPasswordField();
		tfpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfpass.setForeground(new Color(34, 139, 34));
		tfpass.setOpaque(false);
		tfpass.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(60, 179, 113)));
		tfpass.setBounds(369, 249, 374, 33);
		panel.add(tfpass);
		
		JLabel lblNewLabel = new JLabel("Ch\u01B0a c\u00F3 t\u00E0i kho\u1EA3n ! \u0110\u0103ng K\u00FD Ngay");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegisteUser rg = new RegisteUser();
				rg.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.GRAY);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(369, 395, 232, 14);
		panel.add(lblNewLabel);
	}
}
