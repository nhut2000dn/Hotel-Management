package Client.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Client.Connection_Login.ConnectionSQL;
import Server.InterFace;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class BookRoomAdmin extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JLabel tfusername = new JLabel("");
	public JLabel tfmakhachhang = new JLabel("");
	public JRadioButton radioButton = new JRadioButton("A");
	public JComboBox<Object> comboBox_4 = new JComboBox<Object>();
	public JComboBox<String> comboBox_5 = new JComboBox<String>();
	public JComboBox<String> comboBox_3 = new JComboBox<String>();
	public JComboBox<String> comboBox_2 = new JComboBox<String>();
	public JComboBox<Object> comboBox_1 = new JComboBox<Object>();
	public JComboBox<String> comboBox = new JComboBox<String>();
	public JLabel lblloaiphong = new JLabel("");
	public JRadioButton radioButton_2 = new JRadioButton("C");
	public JRadioButton radioButton_1 = new JRadioButton("B");
	public JLabel lblgia = new JLabel("");
	public JComboBox<String> comboBoxphong = new JComboBox<String>();
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRoomAdmin frame = new BookRoomAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void loaiphong() {
		comboBoxphong.removeAllItems();
		lblgia.setText("200000");
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
	public void listphong() {
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		comboBox.addItem("13");
		comboBox.addItem("14");
		comboBox.addItem("15");
		comboBox.addItem("16");
		comboBox.addItem("17");
		comboBox.addItem("18");
		comboBox.addItem("19");
		comboBox.addItem("20");
		comboBox.addItem("21");
		comboBox.addItem("22");
		comboBox.addItem("23");
		comboBox.addItem("24");
		comboBox.addItem("25");
		comboBox.addItem("26");
		comboBox.addItem("27");
		comboBox.addItem("28");
		comboBox.addItem("29");
		comboBox.addItem("30");
		comboBox.addItem("31");
		
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		comboBox_1.addItem("6");
		comboBox_1.addItem("7");
		comboBox_1.addItem("8");
		comboBox_1.addItem("9");
		comboBox_1.addItem("10");
		comboBox_1.addItem("11");
		comboBox_1.addItem("12");
		
		comboBox_2.addItem("2018");
		comboBox_2.addItem("2019");
		comboBox_2.addItem("2020");
		comboBox_2.addItem("2021");
		comboBox_2.addItem("2022");
		comboBox_2.addItem("2023");
		comboBox_2.addItem("2024");
		comboBox_2.addItem("2025");
		comboBox_2.addItem("2026");
		comboBox_2.addItem("2027");
		
		comboBox_3.addItem("1");
		comboBox_3.addItem("2");
		comboBox_3.addItem("3");
		comboBox_3.addItem("4");
		comboBox_3.addItem("5");
		comboBox_3.addItem("6");
		comboBox_3.addItem("7");
		comboBox_3.addItem("8");
		comboBox_3.addItem("9");
		comboBox_3.addItem("10");
		comboBox_3.addItem("11");
		comboBox_3.addItem("12");
		comboBox_3.addItem("13");
		comboBox_3.addItem("14");
		comboBox_3.addItem("15");
		comboBox_3.addItem("16");
		comboBox_3.addItem("17");
		comboBox_3.addItem("18");
		comboBox_3.addItem("19");
		comboBox_3.addItem("20");
		comboBox_3.addItem("21");
		comboBox_3.addItem("22");
		comboBox_3.addItem("23");
		comboBox_3.addItem("24");
		comboBox_3.addItem("25");
		comboBox_3.addItem("26");
		comboBox_3.addItem("27");
		comboBox_3.addItem("28");
		comboBox_3.addItem("29");
		comboBox_3.addItem("30");
		comboBox_3.addItem("31");
		
		comboBox_4.addItem("1");
		comboBox_4.addItem("2");
		comboBox_4.addItem("3");
		comboBox_4.addItem("4");
		comboBox_4.addItem("5");
		comboBox_4.addItem("6");
		comboBox_4.addItem("7");
		comboBox_4.addItem("8");
		comboBox_4.addItem("9");
		comboBox_4.addItem("10");
		comboBox_4.addItem("11");
		comboBox_4.addItem("12");
		
		comboBox_5.addItem("2018");
		comboBox_5.addItem("2019");
		comboBox_5.addItem("2020");
		comboBox_5.addItem("2021");
		comboBox_5.addItem("2022");
		comboBox_5.addItem("2023");
		comboBox_5.addItem("2024");
		comboBox_5.addItem("2025");
		comboBox_5.addItem("2026");
		comboBox_5.addItem("2027");
		
	}

	/**
	 * Create the frame.
	 */
	public BookRoomAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("UserName");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(33, 69, 78, 39);
		contentPane.add(label);
		

		tfusername.setOpaque(true);
		tfusername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(46, 139, 87)));
		tfusername.setBackground(Color.WHITE);
		tfusername.setBounds(146, 69, 347, 32);
		contentPane.add(tfusername);
		
		JLabel label_2 = new JLabel("Mã Khách hàng");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(33, 136, 135, 39);
		contentPane.add(label_2);
		

		tfmakhachhang.setOpaque(true);
		tfmakhachhang.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(46, 139, 87)));
		tfmakhachhang.setBackground(Color.WHITE);
		tfmakhachhang.setBounds(146, 143, 347, 32);
		contentPane.add(tfmakhachhang);
		
		JLabel label_4 = new JLabel("Loại Phòng :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(30, 211, 98, 39);
		contentPane.add(label_4);
		

		buttonGroup.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxphong.removeAllItems();
				lblgia.setText("200000");
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
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton.setBounds(149, 216, 80, 34);
		contentPane.add(radioButton);
		

		buttonGroup.add(radioButton_1);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxphong.removeAllItems();
				lblgia.setText("150000");
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
				} catch (Exception e1) {
				}
			}
		});
		radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_1.setBounds(229, 216, 78, 34);
		contentPane.add(radioButton_1);
		


		buttonGroup.add(radioButton_2);
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxphong.removeAllItems();
				lblgia.setText("120000");
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
		radioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_2.setBounds(309, 216, 78, 34);
		contentPane.add(radioButton_2);
		
		JLabel label_5 = new JLabel("Giá phòng :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(33, 285, 98, 39);
		contentPane.add(label_5);
		
		
		lblgia.setOpaque(true);
		lblgia.setForeground(Color.BLACK);
		lblgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblgia.setEnabled(false);
		lblgia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		lblgia.setBackground(Color.WHITE);
		lblgia.setBounds(149, 285, 344, 39);
		contentPane.add(lblgia);
		
		JLabel label_7 = new JLabel("Phòng :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(33, 364, 98, 39);
		contentPane.add(label_7);
		

		
		comboBoxphong.setBounds(149, 366, 243, 39);
		contentPane.add(comboBoxphong);
		
		JLabel label_8 = new JLabel("Loại Phòng :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(33, 440, 98, 39);
		contentPane.add(label_8);
		

		lblloaiphong.setOpaque(true);
		lblloaiphong.setForeground(Color.BLACK);
		lblloaiphong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblloaiphong.setEnabled(false);
		lblloaiphong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		lblloaiphong.setBackground(Color.WHITE);
		lblloaiphong.setBounds(149, 440, 344, 39);
		contentPane.add(lblloaiphong);
		
		JLabel label_10 = new JLabel("Ngày đến :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(33, 506, 98, 39);
		contentPane.add(label_10);
		

		comboBox.setBounds(147, 506, 78, 37);
		contentPane.add(comboBox);
		
		comboBox_1.setBounds(229, 506, 78, 37);
		contentPane.add(comboBox_1);
		
		
		comboBox_2.setBounds(309, 506, 78, 37);
		contentPane.add(comboBox_2);
		
		JLabel label_11 = new JLabel("Ngày đến :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(33, 566, 98, 39);
		contentPane.add(label_11);
		
		
		comboBox_3.setBounds(147, 566, 78, 37);
		contentPane.add(comboBox_3);
		
	
		comboBox_4.setBounds(229, 566, 78, 37);
		contentPane.add(comboBox_4);
		
		
		comboBox_5.setBounds(309, 565, 78, 39);
		contentPane.add(comboBox_5);
		
		JButton btntPhng = new JButton("Đặt phòng");
		btntPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean bl = true;
				String loi = "";
				String firstYear  = comboBox_2.getSelectedItem().toString();
				String firstMonth = comboBox_1.getSelectedItem().toString();
				String firstDay   = comboBox.getSelectedItem().toString();
				
				String lastYear   = comboBox_5.getSelectedItem().toString();
				String lastMonth  = comboBox_4.getSelectedItem().toString();
				String lastDay    = comboBox_3.getSelectedItem().toString();
			
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
				try {
					Date first = df.parse(firstMonth + "/" + firstDay + "/" + firstYear);
					Date last = df.parse(lastMonth + "/" + lastDay + "/" + lastYear);
					if (first.compareTo(last) == 0 || first.compareTo(last) == 1) {
						bl = false;
						loi += "Vui lòng nhập ngày tháng năm đúng quy cách !";
					}
				} catch (ParseException e) {
				}
				
				if(bl == true) {
					String NgayDen = comboBox.getSelectedItem() + "/"  + comboBox_1.getSelectedItem() + "/" + comboBox_2.getSelectedItem();
					String NgayDi = comboBox_3.getSelectedItem() + "/"  + comboBox_4.getSelectedItem() + "/" + comboBox_5.getSelectedItem();
					String MaPhong = (String) comboBoxphong.getSelectedItem();
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						int check = c.BookRoomUser(tfmakhachhang.getText(), MaPhong, lblloaiphong.getText(), NgayDen, NgayDi);
						if (check == 0) {
							JOptionPane.showMessageDialog( null, "Đặt phòng thành công" , "Message", 1);
						}
						else {
							JOptionPane.showMessageDialog( null, "Đặt phòng That bai" , "Message", 1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog( null, "Chua Ket Noi Server" , "Message", 1);
					}
				}
				else {
					JOptionPane.showMessageDialog( null, loi , "Message", 1);
				}
			}
		});
		
		btntPhng.setForeground(Color.WHITE);
		btntPhng.setFont(new Font("Tahoma", Font.BOLD, 18));
		btntPhng.setBackground(new Color(72, 209, 204));
		btntPhng.setBounds(89, 650, 152, 45);
		contentPane.add(btntPhng);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHy.setForeground(Color.WHITE);
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHy.setBackground(new Color(255, 69, 0));
		btnHy.setBounds(292, 650, 152, 45);
		contentPane.add(btnHy);
		
		JLabel lbltPhng = new JLabel("Đặt Phòng");
		lbltPhng.setOpaque(true);
		lbltPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lbltPhng.setForeground(Color.WHITE);
		lbltPhng.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltPhng.setBackground(new Color(112, 128, 144));
		lbltPhng.setBounds(-13, 0, 567, 58);
		contentPane.add(lbltPhng);
		listphong();
		loaiphong();
	}
}
