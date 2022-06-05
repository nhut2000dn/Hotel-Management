package Client.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Connection_Login.*;
import Client.User.LoginUser;
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
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
public class CreateNew extends JFrame {

	private JPanel contentPane;
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private JTextField tfuser;
	private JPasswordField tfpass;
	private JTextField tfhoten;
	private JTextField tfsdt;
	private JTextField tfquocgia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton jrd;
	private JComboBox<Object> comboBox_1 = new JComboBox<Object>();
	private JComboBox<String> comboBox_2 = new JComboBox<String>();
	private JComboBox<String> comboBox = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNew frame = new CreateNew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ngaysinh() {
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
		
		comboBox_2.addItem("1930");
		comboBox_2.addItem("1931");
		comboBox_2.addItem("1933");
		comboBox_2.addItem("1934");
		comboBox_2.addItem("1935");
		comboBox_2.addItem("1936");
		comboBox_2.addItem("1937");
		comboBox_2.addItem("1938");
		comboBox_2.addItem("1939");
		comboBox_2.addItem("1940");
		comboBox_2.addItem("1941");
		comboBox_2.addItem("1942");
		comboBox_2.addItem("1943");
		comboBox_2.addItem("1944");
		comboBox_2.addItem("1945");
		comboBox_2.addItem("1946");
		comboBox_2.addItem("1947");
		comboBox_2.addItem("1948");
		comboBox_2.addItem("1949");
		comboBox_2.addItem("1950");
		comboBox_2.addItem("1951");
		comboBox_2.addItem("1952");
		comboBox_2.addItem("1953");
		comboBox_2.addItem("1954");
		comboBox_2.addItem("1955");
		comboBox_2.addItem("1956");
		comboBox_2.addItem("1957");
		comboBox_2.addItem("1958");
		comboBox_2.addItem("1959");
		comboBox_2.addItem("1960");
		comboBox_2.addItem("1961");
		comboBox_2.addItem("1962");
		comboBox_2.addItem("1963");
		comboBox_2.addItem("1964");
		comboBox_2.addItem("1965");
		comboBox_2.addItem("1966");
		comboBox_2.addItem("1967");
		comboBox_2.addItem("1968");
		comboBox_2.addItem("1969");
		comboBox_2.addItem("1970");
		comboBox_2.addItem("1971");
		comboBox_2.addItem("1972");
		comboBox_2.addItem("1973");
		comboBox_2.addItem("1974");
		comboBox_2.addItem("1975");
		comboBox_2.addItem("1976");
		comboBox_2.addItem("1977");
		comboBox_2.addItem("1978");
		comboBox_2.addItem("1979");
		comboBox_2.addItem("1980");
		comboBox_2.addItem("1981");
		comboBox_2.addItem("1982");
		comboBox_2.addItem("1983");
		comboBox_2.addItem("1984");
		comboBox_2.addItem("1985");
		comboBox_2.addItem("1986");
		comboBox_2.addItem("1987");
		comboBox_2.addItem("1988");
		comboBox_2.addItem("1989");
		comboBox_2.addItem("1990");
		comboBox_2.addItem("1991");
		comboBox_2.addItem("1992");
		comboBox_2.addItem("1993");
		comboBox_2.addItem("1994");
		comboBox_2.addItem("1995");
		comboBox_2.addItem("1996");
		comboBox_2.addItem("1997");
		comboBox_2.addItem("1998");
		comboBox_2.addItem("1999");
		comboBox_2.addItem("2000");
		comboBox_2.addItem("2001");
		comboBox_2.addItem("2002");
		comboBox_2.addItem("2003");
		comboBox_2.addItem("2004");
		comboBox_2.addItem("2005");
		comboBox_2.addItem("2006");
		comboBox_2.addItem("2007");
		comboBox_2.addItem("2008");
		comboBox_2.addItem("2009");
		comboBox_2.addItem("2010");
		comboBox_2.addItem("2011");
		comboBox_2.addItem("2012");
		comboBox_2.addItem("2013");
		comboBox_2.addItem("2014");
		comboBox_2.addItem("2015");
		comboBox_2.addItem("2016");
		comboBox_2.addItem("2017");
		comboBox_2.addItem("2018");
		comboBox_2.addItem("2019");
	}

	/**
	 * Create the frame.
	 */
	public CreateNew() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnTiKhon = new JLabel("Tài khoản");
		lblTnTiKhon.setForeground(Color.BLACK);
		lblTnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTnTiKhon.setBackground(new Color(244, 164, 96));
		lblTnTiKhon.setBounds(50, 84, 108, 33);
		contentPane.add(lblTnTiKhon);
		
		tfuser = new JTextField();
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfuser.setColumns(10);
		tfuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfuser.setBounds(170, 84, 331, 33);
		contentPane.add(tfuser);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMtKhu.setBackground(new Color(244, 164, 96));
		lblMtKhu.setBounds(50, 146, 118, 33);
		contentPane.add(lblMtKhu);
		
		tfpass = new JPasswordField();
		tfpass.setForeground(new Color(34, 139, 34));
		tfpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfpass.setBounds(170, 146, 331, 33);
		contentPane.add(tfpass);
		
		JLabel label_2 = new JLabel("Họ và tên");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBackground(new Color(244, 164, 96));
		label_2.setBounds(50, 209, 108, 33);
		contentPane.add(label_2);
		
		tfhoten = new JTextField();
		tfhoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfhoten.setColumns(10);
		tfhoten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfhoten.setBounds(170, 212, 331, 33);
		contentPane.add(tfhoten);
		
		JLabel label_3 = new JLabel("Ngày Sinh");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBackground(new Color(244, 164, 96));
		label_3.setBounds(50, 271, 135, 33);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Giới Tính");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_4.setBackground(new Color(244, 164, 96));
		label_4.setBounds(50, 377, 135, 33);
		contentPane.add(label_4);
		
		JRadioButton radioButton = new JRadioButton("Nam");
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setForeground(SystemColor.controlDkShadow);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		radioButton.setBounds(50, 418, 118, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Nữ");
		buttonGroup.add(radioButton_1);
		radioButton_1.setForeground(SystemColor.controlDkShadow);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		radioButton_1.setBounds(172, 418, 172, 23);
		contentPane.add(radioButton_1);
		
		JLabel label_5 = new JLabel("Số Điện Thoại");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_5.setBackground(new Color(244, 164, 96));
		label_5.setBounds(50, 467, 149, 33);
		contentPane.add(label_5);
		
		tfsdt = new JTextField();
		tfsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfsdt.setColumns(10);
		tfsdt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfsdt.setBounds(213, 467, 288, 33);
		contentPane.add(tfsdt);
		
		JLabel label_6 = new JLabel("Quốc Gia");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_6.setBackground(new Color(244, 164, 96));
		label_6.setBounds(50, 525, 108, 33);
		contentPane.add(label_6);
		
		tfquocgia = new JTextField();
		tfquocgia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfquocgia.setColumns(10);
		tfquocgia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfquocgia.setBounds(170, 525, 331, 33);
		contentPane.add(tfquocgia);
		
		JButton btnngK = new JButton("Đăng ký");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean bl = true;
				String loi = "";
				String regexStr = "^[0-9]*$";
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while(bg.hasMoreElements()) {
					jrd = (JRadioButton) bg.nextElement();
				}
				if (tfuser.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập Username !\n";
				}
				if (tfpass.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập Password !\n";
				}
				if (tfhoten.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập họ tên !\n";
				}
				if (tfsdt.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập Số điện thoại !\n";
				}
				if (!tfsdt.getText().matches(regexStr)) {
					bl = false;
					loi += "Vui lòng nhập số điện thoại là số !\n";
				}
				if (bl == true) {
					String DateOfBird = comboBox.getSelectedItem() + "/"  + comboBox_1.getSelectedItem() + "/" + comboBox_2.getSelectedItem();
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						int check = c.registerUser(tfuser.getText(), tfpass.getText(), tfhoten.getText(), DateOfBird, jrd.getText(), tfsdt.getText(), tfquocgia.getText());
						if (check == 1) {
							JOptionPane.showMessageDialog( null, "Đăng Ký Thành Công" , "Message", 1);
							dispose();
						}
						else if (check == 0) {
							JOptionPane.showMessageDialog( null, "Tài khoản bị trùng lặp !" , "Message", 1);
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
		btnngK.setForeground(Color.WHITE);
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnngK.setBackground(new Color(70, 130, 180));
		btnngK.setBounds(177, 596, 149, 33);
		contentPane.add(btnngK);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHy.setForeground(Color.WHITE);
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBackground(new Color(240, 128, 128));
		btnHy.setBounds(352, 596, 149, 33);
		contentPane.add(btnHy);
		
		JLabel lblAddNewAccount = new JLabel("Thêm Tài Khoản");
		lblAddNewAccount.setOpaque(true);
		lblAddNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewAccount.setForeground(Color.WHITE);
		lblAddNewAccount.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddNewAccount.setBackground(new Color(112, 128, 144));
		lblAddNewAccount.setBounds(0, 0, 554, 44);
		contentPane.add(lblAddNewAccount);
		
		
		comboBox.setBounds(50, 315, 78, 37);
		contentPane.add(comboBox);
		
		comboBox_1.setBounds(132, 315, 78, 37);
		contentPane.add(comboBox_1);
		
		
		comboBox_2.setBounds(212, 315, 78, 37);
		contentPane.add(comboBox_2);
		ngaysinh();
	}
}
