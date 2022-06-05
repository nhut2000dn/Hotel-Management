package Client.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import org.omg.CORBA.ARG_OUT;

import Client.Connection_Login.*;
import Server.*;

import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.io.*;
import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class ManagementAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField tfsearch;
	private JTable table;
	private JComboBox<String> comboBoxSearch = new JComboBox<String>();
	private JComboBox<String> comboBoxoder = new JComboBox<String>();
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	private JTable table_1;
	public static JButton btnNewButton_1;
	Random rand = new Random();
	  Timer tm;
	  int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementAdmin frame = new ManagementAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void checkCount() {
		if (count > 0) {
			JOptionPane.showMessageDialog(null, "co thong bao moi", "Error List",  JOptionPane.PLAIN_MESSAGE);
		}
	}
	public void getCount() {
		try {
			String sql = "SELECT Khackhang.MaUser, Khackhang.Username , Khackhang.Hoten, Datphong.Maphong, Datphong.Loaiphong, Datphong.Ngaydat " + 
					"FROM Khackhang, Datphong WHERE Khackhang.Mauser = Datphong.MaUser AND Datphong.DaXem = 0";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			count = 0;
			while(rs.next()) {
				count++;
			}
			   btnNewButton_1.setForeground(Color.BLACK);
			   btnNewButton_1.setBackground(new Color(255, 255, 255));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2, "Error List",  JOptionPane.PLAIN_MESSAGE);
		}
	}
	public void fill() {
		comboBoxSearch.addItem("MaUser");
		comboBoxSearch.addItem("Username");
		comboBoxSearch.addItem("Password");
		comboBoxSearch.addItem("Hoten");
		comboBoxSearch.addItem("Ngaysinh");
		comboBoxSearch.addItem("Gioitinh");
		comboBoxSearch.addItem("SĐT");
		comboBoxSearch.addItem("Quocgia");
		comboBoxSearch.addItem("Role");
		comboBoxoder.addItem("MaUser");
		comboBoxoder.addItem("Username");
		comboBoxoder.addItem("Password");
		comboBoxoder.addItem("Hoten");
		comboBoxoder.addItem("Ngaysinh");
		comboBoxoder.addItem("Gioitinh");
		comboBoxoder.addItem("SĐT");
		comboBoxoder.addItem("Quocgia");
	}

	public void Reciever() throws IOException, ClassNotFoundException {
        ServerSocket ss;
		try {
			while(true) {
				ss = new ServerSocket(7777);
		        System.out.println("ServerSocket awaiting connections...");
		        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
		        System.out.println("Connection from " + socket + "!");

		        // get the input stream from the connected socket
		        InputStream inputStream = socket.getInputStream();
		        // create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

		        // read the list of messages from the socket
		        List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
		        System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
		        // print out the text of every message
		        System.out.println("All messages:");
		        listOfMessages.forEach((msg)-> System.out.println(msg.getText()));
		        listOfMessages.forEach((msg)-> JOptionPane.showMessageDialog( null, msg.getText() , "Message", 1));

		        System.out.println("Closing sockets.");
		        ss.close();
		        socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void refesh() {
		try {
			String sql = "EXEC khackhang_Select";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog( null, e2 , "Message", 1);
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ManagementAdmin() throws ClassNotFoundException, IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Trang Chủ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseUserLogin cul = new ChooseUserLogin();
				cul.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thoát");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(224, 255, 255));
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 105, 1160, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(187, 11, 57, 62);
		panel.add(lblNewLabel);
		
		tfsearch = new JTextField();
		tfsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String sql = "SELECT 'Mã User' = Mauser, Username, Password, 'Họ và Tên' = Hoten, 'Ngày Sinh' = Ngaysinh, 'Giới Tính' = Gioitinh, "
							+ "'Số Điện Thoại' = SĐT, 'Quốc Gia' = Quocgia, Role FROM Khackhang WHERE [" + comboBoxSearch.getSelectedItem() + "] = '" 
							+ tfsearch.getText() + "'" ;
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					JOptionPane.showMessageDialog( null, e , "Message", 1);
				}
			}
		});
		
		tfsearch.setBounds(353, 34, 335, 20);
		panel.add(tfsearch);
		tfsearch.setColumns(10);
		
		
		comboBoxSearch.setBounds(254, 34, 89, 20);
		panel.add(comboBoxSearch);
		
		JButton btnNewButton = new JButton("Tạo mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refesh();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(727, 26, 97, 33);
		panel.add(btnNewButton);
		
		JButton btnCreate = new JButton("Tạo tài khoản");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNew crn = new CreateNew();
				crn.setVisible(true);
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreate.setBounds(878, 26, 160, 33);
		panel.add(btnCreate);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src/images/iconfinder_search_925911.png"));
		lblNewLabel_1.setBounds(156, 11, 32, 62);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 46, 14);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(245, 255, 250)));
		scrollPane.addMouseListener(new MouseAdapter() {


		});

		scrollPane.setBounds(0, 201, 1160, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					try {
						int row = table.getSelectedRow();
						String MaUser = (table.getModel().getValueAt(row, 0)).toString();
						String sql = "EXEC Datphong_SELECT '"+ MaUser  + "'";
						PreparedStatement pst = cn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Message", 1);
					}
				}
				else if(e.getButton() ==  3) {
					try {
						int row = table.getSelectedRow();
						String MaUser = (table.getModel().getValueAt(row, 0)).toString();
						String sql = "EXEC Khackhang_Select_Table '" + MaUser + "'";
						PreparedStatement pst = cn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							UpdateAndDeleteKhackhang ud = new UpdateAndDeleteKhackhang();
							ud.tfuser.setText(rs.getString("Username"));
							ud.tfpass.setText(rs.getString("Password"));
							ud.tfhoten.setText(rs.getString("Hoten"));
							ud.tfngaysinh.setText(rs.getString("Ngaysinh"));
							ud.tfsdt.setText(rs.getString("SĐT"));
							ud.tfquocgia.setText(rs.getString("Quocgia"));
							if (rs.getString("Gioitinh").equals("Nam")) {
								ud.radioButton.setSelected(true);
							}
							else {
								ud.radioButton_1.setSelected(true);
							}
							ud.setVisible(true);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Message", 1);
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 431, 351, 202);
		contentPane.add(panel_1);
		
		JLabel lblOrderBy = new JLabel("Sắp xếp theo");
		lblOrderBy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderBy.setBounds(12, 13, 96, 22);
		panel_1.add(lblOrderBy);
		
		
		comboBoxoder.setBounds(110, 12, 101, 26);
		panel_1.add(comboBoxoder);
		
		JButton btnTngDn = new JButton("Tăng dần");
		btnTngDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "SELECT 'Mã User' = Mauser, Username, Password, 'Họ và Tên' = Hoten, 'Ngày Sinh' = Ngaysinh,"
							+ " 'Giới Tính' = Gioitinh, 'Số Điện Thoại' = SĐT, 'Quốc Gia' = Quocgia, Role FROM Khackhang "
							+ "ORDER BY [" + comboBoxoder.getSelectedItem() + "]";
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnTngDn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTngDn.setBounds(223, 12, 119, 36);
		panel_1.add(btnTngDn);
		
		JButton btnGimDn = new JButton("Giảm dần");
		btnGimDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT 'Mã User' = Mauser, Username, Password, 'Họ và Tên' = Hoten, 'Ngày Sinh' = Ngaysinh,"
							+ " 'Giới Tính' = Gioitinh, 'Số Điện Thoại' = SĐT, 'Quốc Gia' = Quocgia, Role FROM Khackhang "
							+ "ORDER BY [" + comboBoxoder.getSelectedItem() + "] DESC";
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnGimDn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGimDn.setBounds(223, 59, 118, 36);
		panel_1.add(btnGimDn);
		
		JButton btnLnNht = new JButton("Lớn nhất");
		btnLnNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT 'Mã User' = Mauser, Username, Password, 'Họ và Tên' = Hoten, 'Ngày Sinh' = Ngaysinh, 'Giới Tính' = Gioitinh,"
							+ " 'Số Điện Thoại' = SĐT, 'Quốc Gia' = Quocgia, Role FROM Khackhang WHERE [" + comboBoxoder.getSelectedItem() + "] = "
							+ "( SELECT Max([" + comboBoxoder.getSelectedItem() + "]) FROM Khackhang)" ;
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}	
		});
		btnLnNht.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLnNht.setBounds(224, 107, 118, 36);
		panel_1.add(btnLnNht);
		
		JButton btnNhNht = new JButton("Nhỏ nhất");
		btnNhNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT 'Mã User' = Mauser, Username, Password, 'Họ và Tên' = Hoten, 'Ngày Sinh' = Ngaysinh,"
							+ " 'Giới Tính' = Gioitinh, 'Số Điện Thoại' = SĐT, 'Quốc Gia' = Quocgia, Role FROM Khackhang "
							+ "WHERE [" + comboBoxoder.getSelectedItem() + "] = "
							+ "( SELECT MIN([" + comboBoxoder.getSelectedItem() + "]) FROM Khackhang)" ;
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNhNht.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNhNht.setBounds(224, 154, 118, 36);
		panel_1.add(btnNhNht);
		
		JLabel lblNewLabel_3 = new JLabel("Thông Báo Mới :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(12, 106, 119, 36);
		panel_1.add(lblNewLabel_3);
		
		btnNewButton_1 = new JButton("Xem ngay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int counts = 0;
				String sql = "SELECT Khackhang.MaUser, Khackhang.Username , Khackhang.Hoten, Datphong.Maphong, Datphong.Loaiphong, Datphong.Ngaydat " + 
						"FROM Khackhang, Datphong WHERE Khackhang.Mauser = Datphong.MaUser AND Datphong.DaXem = 0";
				String sql1 = "UPDATE Datphong SET DaXem = '0' WHERE DaXem = 1";
				String categories[] = new String[10];
				try {
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						counts++;
						System.out.println(rs.getString("MaUser"));
						System.out.println(rs.getString("Hoten"));
						categories[counts] = ""+ counts +". Khách hàng : " + rs.getString("Hoten") + 
								" Đã đặt phòng : " + rs.getString("Maphong") + " Vào lúc :" + rs.getString("Ngaydat") + "\n";
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2, "Error List",  JOptionPane.PLAIN_MESSAGE);
				}
				try {
					Statement stmt = cn.createStatement();
					int n = stmt.executeUpdate(sql1);
				} catch (Exception e2) {
				}
				JScrollPane scrollpane = new JScrollPane(); 
			       JList list = new JList(categories);
			       
			       scrollpane = new JScrollPane(list);
			       scrollpane.setPreferredSize(new Dimension(600,300));

			       JPanel panel = new JPanel(); 
			       panel.add(scrollpane);

			       scrollpane.getViewport().add(list);
			       JOptionPane.showMessageDialog(null, scrollpane, "Error List",  
			                                              JOptionPane.PLAIN_MESSAGE);
					getCount();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(19, 148, 105, 42);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quản Lý Thông Tin Khách Sạn");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(277, 31, 540, 49);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();

		scrollPane_1.setBounds(363, 431, 797, 202);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UpdateAndDeleteDatphong ud = new UpdateAndDeleteDatphong();
				if (arg0.getButton() == 3) {
					int row = table_1.getSelectedRow();
					String MaUser = (table_1.getModel().getValueAt(row, 1)).toString();
					String sql1 = "SELECT * FROM Datphong WHERE Maphong = '" + MaUser + "'";
					try {
						PreparedStatement pst = cn.prepareStatement(sql1);
						ResultSet rs = pst.executeQuery();
								
						while (rs.next()) {
							ud.tfmauser.setText(rs.getString("MaUser"));
							if (rs.getString("Loaiphong").equals("A")) {
								ud.radioButton_A.setSelected(true);
								ud.lblgiaphong.setText("200000");
							}
							else if (rs.getString("Loaiphong").equals("B")) {
								ud.radioButton_B.setSelected(true);
								ud.lblgiaphong.setText("150000");
							}
							else  {
								ud.radioButton_C.setSelected(true);
								ud.lblgiaphong.setText("120000");
							}
							ud.comboBoxphong.removeAllItems();
							ud.comboBoxphong.addItem(rs.getString("Maphong"));
							ud.lblloaiphong.setText(rs.getString("Loaiphong"));
							ud.tfngayden.setText(rs.getString("Ngayden"));
							ud.tfngaydi.setText(rs.getString("Ngaydi"));
							ud.setVisible(true);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e, "", 1);
					}
				}
					
			}
		});
		getCount();
		scrollPane_1.setViewportView(table_1);
		  tm = new Timer(60, new ActionListener() {
			   
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   if (count > 0) {
					   int n = rand.nextInt(150);
					   int h = rand.nextInt(30);
					   int k = rand.nextInt(10);
					   n += 10;
					   h += 90;
					   k += 10;
					   Color myWhite = new Color(255, 255, 255); // Color white
					   btnNewButton_1.setForeground(myWhite);
					   btnNewButton_1.setBackground(new Color(n,h,k));
				   }
			   }
			  });
			  
			  tm.start();
		fill();
		
		refesh();
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	checkCount();
		            	try {
							Reciever();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        }, 
		        1000 
		);
	}
}
