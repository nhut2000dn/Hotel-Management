package Client.User;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Client.Connection_Login.*;
import Server.*;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookRoomUser extends JFrame {
	private JPanel contentPane;
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("C");
	private JLabel lblgia = new JLabel("");
	private JLabel lblloaiphong = new JLabel("");
	public JLabel tfmakhachhang = new JLabel("");
	public JLabel tfusername = new JLabel("");
	private JComboBox<String> comboBoxphong = new JComboBox<String>();
	private JComboBox<String> comboBox_2 = new JComboBox<String>();
	private JComboBox<String> comboBox_1 = new JComboBox<String>();
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JComboBox<String> comboBox_3 = new JComboBox<String>();
	private JComboBox<String> comboBox_4 = new JComboBox<String>();
	private JComboBox<String> comboBox_5 = new JComboBox<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRoomUser frame = new BookRoomUser();
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
	public BookRoomUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(9, 65, 434, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(29, 107, 106, 39);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Đặt phòng");
		btnNewButton.setBackground(new Color(72, 209, 204));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
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
						loi += "Vui lòng nhập ngay tháng năm đúng quy cách !";
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
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
							try {
								JOptionPane.showMessageDialog( null, "Đặt phòng thành công" , "Message", 1);
						        Socket socket = new Socket("localhost", 7777);
						        System.out.println("Connected!");

						        // get the output stream from the socket.
						        OutputStream outputStream = socket.getOutputStream();
						        // create an object output stream from the output stream so we can send an object through it
						        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

						        // make a bunch of messages to send.
						        List<Message> messages = new ArrayList<>();
						        messages.add(new Message("Khach Hang" + tfusername.getText() + " Vua Book Phong"));
//						        messages.add(new Message("How are you doing?"));
//						        messages.add(new Message("What time is it?"));
//						        messages.add(new Message("Hi hi hi hi."));

						        System.out.println("Sending messages to the ServerSocket");
						        objectOutputStream.writeObject(messages);

						        System.out.println("Closing socket and terminating program.");
						        socket.close();
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
						else {
							JOptionPane.showMessageDialog( null, "Đặt phòng That bai" , "Message", 1);
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(46, 500, 152, 45);
		panel.add(btnNewButton);
		
		JButton btnCancer = new JButton("Hủy");
		btnCancer.setBackground(new Color(255, 69, 0));
		btnCancer.setForeground(Color.WHITE);
		btnCancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancer.setBounds(239, 500, 152, 45);
		panel.add(btnCancer);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
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
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(134, 161, 56, 34);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("B");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				} catch (Exception e) {
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(205, 161, 49, 34);
		panel.add(rdbtnNewRadioButton_1);
		
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
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
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(270, 161, 56, 34);
		panel.add(rdbtnNewRadioButton_2);
		
		JLabel lblGiPhng = new JLabel("Giá phòng :");
		lblGiPhng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiPhng.setBounds(29, 207, 98, 39);
		panel.add(lblGiPhng);
		lblgia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		

		lblgia.setBackground(Color.WHITE);
		lblgia.setOpaque(true);
		lblgia.setEnabled(false);
		lblgia.setForeground(new Color(0, 0, 0));
		lblgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblgia.setBounds(143, 207, 266, 39);
		panel.add(lblgia);
		
		JLabel lblPhng = new JLabel("Phòng :");
		lblPhng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhng.setBounds(29, 271, 97, 39);
		panel.add(lblPhng);
		

		comboBoxphong.setBounds(144, 273, 265, 39);
		panel.add(comboBoxphong);
		
		
		tfmakhachhang.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(46, 139, 87)));
		tfmakhachhang.setOpaque(true);
		tfmakhachhang.setBackground(Color.WHITE);
		tfmakhachhang.setBounds(140, 107, 269, 32);
		panel.add(tfmakhachhang);
		
		JLabel lblLoiPhng = new JLabel("Loại Phòng :");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoiPhng.setBounds(29, 337, 86, 39);
		panel.add(lblLoiPhng);
		
		JLabel lblNgy = new JLabel("Ngày đến :");
		lblNgy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgy.setBounds(29, 387, 106, 39);
		panel.add(lblNgy);
		
		
		comboBox.setBounds(143, 390, 78, 37);
		panel.add(comboBox);
		
		
		comboBox_1.setBounds(239, 391, 78, 37);
		panel.add(comboBox_1);
		
		
		comboBox_2.setBounds(331, 391, 78, 37);
		panel.add(comboBox_2);
		
		JLabel lblNgyi = new JLabel("Ngày đi :");
		lblNgyi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyi.setBounds(29, 439, 98, 39);
		panel.add(lblNgyi);
		
		
		comboBox_3.setBounds(143, 439, 78, 37);
		panel.add(comboBox_3);
		
		
		comboBox_4.setBounds(239, 439, 78, 37);
		panel.add(comboBox_4);
		
		
		comboBox_5.setBounds(331, 439, 78, 39);
		panel.add(comboBox_5);
		lblloaiphong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		
		
		lblloaiphong.setOpaque(true);
		lblloaiphong.setForeground(Color.BLACK);
		lblloaiphong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblloaiphong.setEnabled(false);
		lblloaiphong.setBackground(Color.WHITE);
		lblloaiphong.setBounds(143, 337, 266, 39);
		panel.add(lblloaiphong);
		
		JLabel label_2 = new JLabel("Loại Phòng :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(29, 157, 98, 39);
		panel.add(label_2);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản");
		lblTnTiKhon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnTiKhon.setBounds(29, 44, 98, 39);
		panel.add(lblTnTiKhon);
		
		
		tfusername.setOpaque(true);
		tfusername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(46, 139, 87)));
		tfusername.setBackground(Color.WHITE);
		tfusername.setBounds(142, 48, 269, 32);
		panel.add(tfusername);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showMessageDialog( null, "Đặt phòng thành công" , "Message", 1);
			        Socket socket = new Socket("localhost", 7777);
			        System.out.println("Connected!");

			        // get the output stream from the socket.
			        OutputStream outputStream = socket.getOutputStream();
			        // create an object output stream from the output stream so we can send an object through it
			        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

			        // make a bunch of messages to send.
			        List<Message> messages = new ArrayList<>();
			        messages.add(new Message("Tai Khoan" + tfusername.getText() + " Vua moi Book Phong"));

			        System.out.println("Sending messages to the ServerSocket");
			        objectOutputStream.writeObject(messages);

			        System.out.println("Closing socket and terminating program.");
			        socket.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(26, 10, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblBookRoom = new JLabel("Đặt Phòng");
		lblBookRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookRoom.setForeground(new Color(255, 255, 255));
		lblBookRoom.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBookRoom.setOpaque(true);
		lblBookRoom.setBackground(new Color(112, 128, 144));
		lblBookRoom.setBounds(0, 0, 455, 58);
		contentPane.add(lblBookRoom);
		listphong();
		loaiphong();
	}
}
