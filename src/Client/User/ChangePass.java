package Client.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Client.Connection_Login.ConnectionSQL;
import Server.InterFace;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	public JLabel tfuser = new JLabel("");
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private JPasswordField tfcu;
	private JPasswordField tfmoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
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
	public ChangePass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản");
		lblTnTiKhon.setForeground(Color.DARK_GRAY);
		lblTnTiKhon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTnTiKhon.setBackground(new Color(244, 164, 96));
		lblTnTiKhon.setBounds(10, 97, 165, 33);
		contentPane.add(lblTnTiKhon);
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ");
		lblMtKhuC.setForeground(Color.DARK_GRAY);
		lblMtKhuC.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMtKhuC.setBackground(new Color(244, 164, 96));
		lblMtKhuC.setBounds(10, 196, 135, 33);
		contentPane.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setForeground(Color.DARK_GRAY);
		lblMtKhuMi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMtKhuMi.setBackground(new Color(244, 164, 96));
		lblMtKhuMi.setBounds(10, 297, 165, 33);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblChangePassword = new JLabel("Đổi Mật Khẩu");
		lblChangePassword.setOpaque(true);
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setForeground(Color.WHITE);
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblChangePassword.setBackground(SystemColor.controlDkShadow);
		lblChangePassword.setBounds(0, 0, 472, 50);
		contentPane.add(lblChangePassword);
		
		JButton btnChange = new JButton("Đổi");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
					int check = c.ChangePassword(tfuser.getText(), tfcu.getText(), tfmoi.getText());
					if (check == 1) {
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
					}
					else if (check == 0) {
						JOptionPane.showMessageDialog(null, "Mật khẩu Truoc không đúng");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
				}
			}
		});
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChange.setBackground(new Color(70, 130, 180));
		btnChange.setBounds(10, 419, 149, 33);
		contentPane.add(btnChange);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHy.setForeground(Color.WHITE);
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBackground(new Color(240, 128, 128));
		btnHy.setBounds(202, 419, 149, 33);
		contentPane.add(btnHy);
		
		
		tfuser.setOpaque(true);
		tfuser.setForeground(Color.BLACK);
		tfuser.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfuser.setEnabled(false);
		tfuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfuser.setBackground(Color.WHITE);
		tfuser.setBounds(10, 146, 434, 39);
		contentPane.add(tfuser);
		
		tfcu = new JPasswordField();
		tfcu.setForeground(new Color(34, 139, 34));
		tfcu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfcu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfcu.setBounds(10, 240, 434, 39);
		contentPane.add(tfcu);
		
		tfmoi = new JPasswordField();
		tfmoi.setForeground(new Color(34, 139, 34));
		tfmoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfmoi.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfmoi.setBounds(10, 341, 434, 39);
		contentPane.add(tfmoi);
	}
}
