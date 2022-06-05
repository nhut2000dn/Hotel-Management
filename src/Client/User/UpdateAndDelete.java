package Client.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Client.Connection_Login.*;
import Server.InterFace;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
public class UpdateAndDelete extends JFrame {

	private JPanel contentPane;
	public JLabel tfmauser = new JLabel("");
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField tfngaydi;
	public JTextField tfngayden;
	public JRadioButton radioButton_B = new JRadioButton("B");
	public JRadioButton radioButton_C = new JRadioButton("C");
	public JRadioButton radioButton_A = new JRadioButton("A");
	public JComboBox<String> comboBoxphong = new JComboBox<String>();
	public JLabel lblgiaphong = new JLabel("");
	public JLabel lblloaiphong = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAndDelete frame = new UpdateAndDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void loaiphong() {

	}

	/**
	 * Create the frame.
	 */
	public UpdateAndDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 54, 508, 640);
		contentPane.add(panel);
		
		JLabel lblMUser = new JLabel("Mã User");
		lblMUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMUser.setBounds(24, 25, 78, 39);
		panel.add(lblMUser);
		
		JButton btnUpdate = new JButton("Cập Nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				Boolean bl = true;
				Date first = null;
				Date last = null;
				String loi = "";
				try {
					first = df.parse(tfngayden.getText().toString());
					last = df.parse(tfngaydi.getText().toString());
					if (first.compareTo(last) == 0 || first.compareTo(last) == 1) {
						bl = false;
						loi += "Vui lòng nhập ngày tháng năm đúng quy cách !\n";
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (tfngayden.getText().equals("")) {
					bl = false;
					loi+="Vui lòng nhập Ngày đến !\n";
				}
				if (tfngaydi.getText().equals("")) {
					bl = false;
					loi+="Vui lòng nhập Ngày đi !\n";
				}
				if (bl == true) {
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						String Maphong = (String) comboBoxphong.getSelectedItem();
						int check = c.UpdateUser(Maphong, lblloaiphong.getText(), tfngayden.getText(), tfngaydi.getText(), tfmauser.getText());
						if (check == 1) {
							JOptionPane.showMessageDialog( null, "Cập nhật thành công" , "Message", 1);
						}
						else if (check == 0) {
							JOptionPane.showMessageDialog( null, e , "Message", 1);
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
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBackground(new Color(32, 178, 170));
		btnUpdate.setBounds(143, 524, 152, 45);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn Hủy phòng đã đặt !", "Xóa", JOptionPane.YES_NO_OPTION);
				if (action == 0) {
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						String Maphong = (String) comboBoxphong.getSelectedItem();
						int check = c.DeleteUser(Maphong);
						if (check == 0) {
							JOptionPane.showMessageDialog( null, "Xóa thành công" , "Message", 1);
						}
						else {
							JOptionPane.showMessageDialog( null, "Xóa thất bại" , "Message", 1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
					}
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(294, 524, 152, 45);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBackground(new Color(240, 128, 128));
		btnCancel.setBounds(223, 568, 152, 45);
		panel.add(btnCancel);
		
		JLabel label_2 = new JLabel("Loại Phòng :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(24, 91, 98, 39);
		panel.add(label_2);
		buttonGroup.add(radioButton_A);
		radioButton_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxphong.removeAllItems();
				lblgiaphong.setText("200000");
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while(bg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if(jrd.isSelected()) {
						lblloaiphong.setText(jrd.getText());
					}
				}	
				try {
					String sql = "SELECT Maphong FROM Phong WHERE Loaiphong = 'A' AND Tinhtrang = '0'";
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						comboBoxphong.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
				}
			}
		});
		
		radioButton_A.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_A.setBounds(143, 96, 80, 34);
		panel.add(radioButton_A);
		buttonGroup.add(radioButton_B);
		radioButton_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxphong.removeAllItems();
				lblgiaphong.setText("150000");
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while(bg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if(jrd.isSelected()) {
						lblloaiphong.setText(jrd.getText());
					}
				}	
				try {
					String sql = "SELECT Maphong FROM Phong WHERE Loaiphong = 'B' AND Tinhtrang = '0'";
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						comboBoxphong.addItem(rs.getString(1));
					}
				} catch (Exception e) {
				}
			}
		});
		radioButton_B.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_B.setBounds(223, 96, 78, 34);
		panel.add(radioButton_B);
		buttonGroup.add(radioButton_C);
		radioButton_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxphong.removeAllItems();
				lblgiaphong.setText("120000");
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while(bg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if(jrd.isSelected()) {
						lblloaiphong.setText(jrd.getText());
					}
				}	
				try {
					String sql = "SELECT Maphong FROM Phong WHERE Loaiphong = 'C' AND Tinhtrang = '0'";
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						comboBoxphong.addItem(rs.getString(1));
					}
				} catch (Exception e1) {
				}
			}
		});
		radioButton_C.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_C.setBounds(303, 96, 78, 34);
		panel.add(radioButton_C);
		
		JLabel label_3 = new JLabel("Giá phòng :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(24, 152, 98, 39);
		panel.add(label_3);
		

		lblgiaphong.setOpaque(true);
		lblgiaphong.setForeground(Color.DARK_GRAY);
		lblgiaphong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblgiaphong.setEnabled(false);
		lblgiaphong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		lblgiaphong.setBackground(Color.WHITE);
		lblgiaphong.setBounds(125, 152, 359, 39);
		panel.add(lblgiaphong);
		
		JLabel label_5 = new JLabel("Phòng :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(24, 225, 98, 39);
		panel.add(label_5);
		
		
		comboBoxphong.setBounds(125, 227, 258, 39);
		panel.add(comboBoxphong);
		
		JLabel label_6 = new JLabel("Loại Phòng :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(24, 301, 98, 39);
		panel.add(label_6);
		
		
		lblloaiphong.setOpaque(true);
		lblloaiphong.setForeground(Color.DARK_GRAY);
		lblloaiphong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblloaiphong.setEnabled(false);
		lblloaiphong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		lblloaiphong.setBackground(Color.WHITE);
		lblloaiphong.setBounds(125, 301, 359, 39);
		panel.add(lblloaiphong);
		
		JLabel label_8 = new JLabel("Ngày đến :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(24, 375, 98, 39);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Ngày đến :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(24, 447, 98, 39);
		panel.add(label_9);
		
		
		tfmauser.setOpaque(true);
		tfmauser.setForeground(Color.DARK_GRAY);
		tfmauser.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmauser.setEnabled(false);
		tfmauser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfmauser.setBackground(Color.WHITE);
		tfmauser.setBounds(125, 25, 359, 39);
		panel.add(tfmauser);
		
		tfngaydi = new JTextField();
		tfngaydi.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfngaydi.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfngaydi.setBounds(125, 450, 359, 39);
		panel.add(tfngaydi);
		tfngaydi.setColumns(10);
		
		tfngayden = new JTextField();
		tfngayden.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfngayden.setColumns(10);
		tfngayden.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfngayden.setBounds(125, 375, 359, 39);
		panel.add(tfngayden);
		
		JLabel lblEdit = new JLabel("Sửa Thông Tin Đặt Phòng");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEdit.setForeground(new Color(255, 255, 255));
		lblEdit.setBackground(new Color(119, 136, 153));
		lblEdit.setOpaque(true);
		lblEdit.setBounds(0, 0, 532, 43);
		contentPane.add(lblEdit);
		loaiphong();
	}
}
