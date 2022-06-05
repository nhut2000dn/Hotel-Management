package Client.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Connection_Login.*;
import Client.User.ManagementUser;
import Server.InterFace;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
public class UpdateAndDeleteKhackhang extends JFrame {

	private JPanel contentPane;
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	public JTextField tfuser;
	public JTextField tfhoten;
	public JTextField tfngaysinh;
	public JTextField tfsdt;
	public JTextField tfquocgia;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField tfpass;
	public JRadioButton radioButton = new JRadioButton("Nam");
	public JRadioButton radioButton_1 = new JRadioButton("Nữ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAndDeleteKhackhang frame = new UpdateAndDeleteKhackhang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fill() {
	}

	/**
	 * Create the frame.
	 */
	public UpdateAndDeleteKhackhang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 80, 615, 548);
		contentPane.add(panel);
		fill();
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBackground(new Color(32, 178, 170));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean bl = true;
				String loi = "";
				if (tfuser.getText().equals("")) {
					loi+= "Xin vui lòng nhập Username !\n";
					bl = false;
				}
				if (tfpass.getText().equals("")) {
					loi+= "Xin vui lòng nhập PassWord !\n";
					bl = false;
				}
				if (tfhoten.getText().equals("")) {
					loi+= "Xin vui lòng nhập Họ và Tên !\n";
					bl = false;
				}
				if (tfngaysinh.getText().equals("")) {
					loi+= "Xin vui lòng nhập ngày tháng năm sinh !\n";
					bl = false;
				}
				if (tfquocgia.getText().equals("")) {
					loi+= "Xin vui lòng nhập Quốc gia !\n";
					bl = false;
				}
				if (bl == true) {
					Enumeration<AbstractButton> bg = buttonGroup.getElements();
					while(bg.hasMoreElements()) {
						JRadioButton jrd = (JRadioButton) bg.nextElement();
						if(jrd.isSelected()) {
							try {
								InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
								int check = c.UpdateAccount(tfuser.getText(), tfpass.getText(), tfhoten.getText(), tfngaysinh.getText(), jrd.getText(), tfsdt.getText(), tfquocgia.getText());
								if (check == 1) {
									JOptionPane.showMessageDialog( null, "Cập nhật thành công" , "Message", 1);
								}
								else if (check == 0) {
									JOptionPane.showMessageDialog( null, "Cập nhật thất bại" , "Message", 1);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog( null, loi , "Message", 1);
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(10, 479, 134, 45);
		panel.add(btnUpdate);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setBackground(new Color(240, 128, 128));
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHy.setBounds(305, 479, 141, 45);
		panel.add(btnHy);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn Xóa thông tin khách hàng này !", "Xóa", JOptionPane.YES_NO_OPTION);
				if (action == 0) {
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						int check = c.DeleteAccount(tfuser.getText());
						if (check == 1) {
							JOptionPane.showMessageDialog( null, "Xóa thành công" , "Message", 1);
						}
						else if (check == 0) {
							JOptionPane.showMessageDialog( null, "Xóa thất bại" , "Message", 1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
					}
				}
			}	

		});
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(154, 479, 141, 45);
		panel.add(btnDelete);
		
		JLabel label = new JLabel("Username");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBackground(new Color(244, 164, 96));
		label.setBounds(36, 0, 135, 33);
		panel.add(label);
		
		tfuser = new JTextField();
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfuser.setColumns(10);
		tfuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfuser.setBounds(171, 1, 434, 33);
		panel.add(tfuser);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBackground(new Color(244, 164, 96));
		label_1.setBounds(36, 60, 135, 33);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Họ và tên");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBackground(new Color(244, 164, 96));
		label_2.setBounds(36, 127, 135, 33);
		panel.add(label_2);
		
		 tfhoten = new JTextField();
		tfhoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfhoten.setColumns(10);
		tfhoten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfhoten.setBounds(171, 128, 434, 33);
		panel.add(tfhoten);
		
		JLabel label_3 = new JLabel("Ngày Sinh");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBackground(new Color(244, 164, 96));
		label_3.setBounds(36, 191, 135, 33);
		panel.add(label_3);
		
		tfngaysinh = new JTextField();
		tfngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfngaysinh.setColumns(10);
		tfngaysinh.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfngaysinh.setBounds(171, 192, 434, 33);
		panel.add(tfngaysinh);
		
		JLabel label_4 = new JLabel("Giới Tính");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBackground(new Color(244, 164, 96));
		label_4.setBounds(39, 253, 135, 33);
		panel.add(label_4);
		

		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setForeground(SystemColor.controlDkShadow);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButton.setBounds(39, 294, 118, 23);
		panel.add(radioButton);
		
		
		buttonGroup.add(radioButton_1);
		radioButton_1.setForeground(SystemColor.controlDkShadow);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButton_1.setBounds(161, 294, 172, 23);
		panel.add(radioButton_1);
		
		JLabel label_5 = new JLabel("Số Điện Thoại");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBackground(new Color(244, 164, 96));
		label_5.setBounds(39, 339, 179, 33);
		panel.add(label_5);
		
		tfsdt = new JTextField();
		tfsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfsdt.setColumns(10);
		tfsdt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfsdt.setBounds(174, 340, 431, 33);
		panel.add(tfsdt);
		
		JLabel label_6 = new JLabel("Quốc Gia");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBackground(new Color(244, 164, 96));
		label_6.setBounds(39, 406, 118, 33);
		panel.add(label_6);
		
		tfquocgia = new JTextField();
		tfquocgia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfquocgia.setColumns(10);
		tfquocgia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfquocgia.setBounds(171, 407, 434, 33);
		panel.add(tfquocgia);
		
		tfpass = new JTextField();
		tfpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfpass.setColumns(10);
		tfpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfpass.setBounds(171, 61, 434, 33);
		panel.add(tfpass);
		
		JButton btnBookRoom = new JButton("Đặt phòng");
		btnBookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookRoomAdmin BR = new BookRoomAdmin();
				BR.tfusername.setText(tfuser.getText());
				String sql = "SELECT MaUser FROM Khackhang WHERE UserName = '" + tfuser.getText() + "'";
				try {
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						BR.tfmakhachhang.setText(rs.getString("MaUser"));
					}
					BR.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnBookRoom.setForeground(Color.WHITE);
		btnBookRoom.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBookRoom.setBackground(new Color(60, 179, 113));
		btnBookRoom.setBounds(456, 479, 151, 45);
		panel.add(btnBookRoom);
		
		JLabel lblEditRoom = new JLabel("Sửa Thông Tin Khách Hàng");
		lblEditRoom.setOpaque(true);
		lblEditRoom.setForeground(new Color(255, 255, 255));
		lblEditRoom.setBackground(new Color(105, 105, 105));
		lblEditRoom.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEditRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditRoom.setBounds(0, 0, 638, 50);
		contentPane.add(lblEditRoom);
		
		
		
	}
}
