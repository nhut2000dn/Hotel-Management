package Client.User;

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

import Client.Connection_Login.*;
import Server.InterFace;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
public class RegisteUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JPasswordField tfpass;
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfhoten;
	private JTextField tfsdt;
	private JTextField tfquocgia;
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
					RegisteUser frame = new RegisteUser();
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
	public RegisteUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 903, 672);
		contentPane.add(panel);
		
		JLabel lblTiKhon = new JLabel("Tài khoản");
		lblTiKhon.setForeground(Color.BLACK);
		lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTiKhon.setBackground(new Color(244, 164, 96));
		lblTiKhon.setBounds(38, 69, 118, 33);
		panel.add(lblTiKhon);
		
		tfuser = new JTextField();
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfuser.setColumns(10);
		tfuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfuser.setBounds(166, 69, 374, 33);
		panel.add(tfuser);
		Enumeration<AbstractButton> bg = buttonGroup.getElements();
		while(bg.hasMoreElements()) {
			bg.nextElement();
		}
		
		JButton btnSubmit = new JButton("Đăng ký");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean bl = true;
				String loi = "";
				String regexStr = "^[0-9]*$";
				if (!tfsdt.getText().matches(regexStr)) {
					bl = false;
					loi += "Vui lòng nhập số điện thoại là số !\n";
				}
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while(bg.hasMoreElements()) {
					jrd = (JRadioButton) bg.nextElement();
				}
				if (tfuser.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập Tài khoản !\n";
				}
				if (tfpass.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập Mật khẩu !\n";
				}
				if (tfhoten.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập họ tên !\n";
				}
				if (tfsdt.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập số điện thoại !\n";
				}
				if (tfquocgia.getText().equals("")) {
					bl = false;
					loi += "Vui lòng nhập quốc gia !\n";
				}
				try {
					InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
					int check = c.checkUser(tfuser.getText());
					if (check == 0) {
						bl = false;
						loi+= "Tài khoản đã có người đăng ký xin hãy chọn tài khoản khác !";
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
				}
				if (bl == true) {
					String DateOfBird = comboBox.getSelectedItem() + "/"  + comboBox_1.getSelectedItem() + "/" + comboBox_2.getSelectedItem();
					JOptionPane.showMessageDialog( null, DateOfBird , "Message", 1);
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
						int check = c.registerUser(tfuser.getText(), tfpass.getText(), tfhoten.getText(), DateOfBird, jrd.getText(), tfsdt.getText(), tfquocgia.getText());
						if (check == 1) {
							JOptionPane.showMessageDialog( null, "Đăng Ký Thành Công" , "Message", 1);
							dispose();
							LoginUser lus = new LoginUser();
							lus.setVisible(true);
						}
						else if (check == 0) {
							JOptionPane.showMessageDialog( null, "Tài khoản bị trùng lặp !" , "Message", 1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog( null, "Server loi" , "Message", 1);
					}
				} else {
					JOptionPane.showMessageDialog( null, loi , "Message", 1);
				}
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBackground(new Color(70, 130, 180));
		btnSubmit.setBounds(166, 614, 135, 33);
		panel.add(btnSubmit);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMtKhu.setBackground(new Color(244, 164, 96));
		lblMtKhu.setBounds(38, 138, 118, 33);
		panel.add(lblMtKhu);
		
		JLabel lblRe = new JLabel("Đăng ký");
		lblRe.setOpaque(true);
		lblRe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRe.setForeground(Color.WHITE);
		lblRe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRe.setBackground(new Color(112, 128, 144));
		lblRe.setBounds(0, 0, 609, 44);
		panel.add(lblRe);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginUser lus = new LoginUser();
				lus.setVisible(true);
			}
		});
		btnHy.setForeground(Color.WHITE);
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBackground(new Color(240, 128, 128));
		btnHy.setBounds(332, 614, 135, 33);
		panel.add(btnHy);
		
		tfpass = new JPasswordField();
		tfpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfpass.setForeground(new Color(34, 139, 34));
		tfpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfpass.setBounds(166, 141, 374, 33);
		panel.add(tfpass);
		
		JLabel lblHVTn = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblHVTn.setForeground(Color.BLACK);
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHVTn.setBackground(new Color(244, 164, 96));
		lblHVTn.setBounds(38, 208, 118, 33);
		panel.add(lblHVTn);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y Sinh");
		lblNgySinh.setForeground(Color.BLACK);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgySinh.setBackground(new Color(244, 164, 96));
		lblNgySinh.setBounds(38, 274, 135, 33);
		panel.add(lblNgySinh);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setForeground(new Color(105, 105, 105));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnNewRadioButton.setBounds(38, 427, 118, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("N\u1EEF");
		buttonGroup.add(rdbtnN);
		rdbtnN.setForeground(new Color(105, 105, 105));
		rdbtnN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnN.setBounds(160, 427, 172, 23);
		panel.add(rdbtnN);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblGiiTnh.setForeground(Color.BLACK);
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGiiTnh.setBackground(new Color(244, 164, 96));
		lblGiiTnh.setBounds(38, 386, 135, 33);
		panel.add(lblGiiTnh);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
		lblSinThoi.setForeground(Color.BLACK);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSinThoi.setBackground(new Color(244, 164, 96));
		lblSinThoi.setBounds(38, 484, 154, 33);
		panel.add(lblSinThoi);
		
		JLabel lblQucGia = new JLabel("Qu\u1ED1c Gia");
		lblQucGia.setForeground(Color.BLACK);
		lblQucGia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQucGia.setBackground(new Color(244, 164, 96));
		lblQucGia.setBounds(38, 551, 103, 33);
		panel.add(lblQucGia);
		
		tfhoten = new JTextField();
		tfhoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfhoten.setColumns(10);
		tfhoten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfhoten.setBounds(166, 208, 374, 33);
		panel.add(tfhoten);
		
		tfsdt = new JTextField();
		tfsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfsdt.setColumns(10);
		tfsdt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfsdt.setBounds(200, 487, 340, 33);
		panel.add(tfsdt);
		
		tfquocgia = new JTextField();
		tfquocgia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfquocgia.setColumns(10);
		tfquocgia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(60, 179, 113)));
		tfquocgia.setBounds(166, 551, 380, 33);
		panel.add(tfquocgia);
		
		
		comboBox.setBounds(38, 315, 78, 37);
		panel.add(comboBox);
		
		comboBox_1.setBounds(120, 315, 78, 37);
		panel.add(comboBox_1);
		
		
		comboBox_2.setBounds(200, 315, 78, 37);
		panel.add(comboBox_2);
		ngaysinh();
	}
}
