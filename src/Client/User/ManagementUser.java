package Client.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Connection_Login.*;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
public class ManagementUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JLabel labeltk = new JLabel("");
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	public JPasswordField labelmk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementUser frame = new ManagementUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refesh() {
		try {
			String sql = "EXEC Datphong_SELECT_User '" + labeltk.getText() + "'";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog( null, e2 , "Message", 1);
		}
	};


	/**
	 * Create the frame.
	 */
	public ManagementUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 662);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("Trang Chủ");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseUserLogin cul = new ChooseUserLogin();
				cul.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Thoát");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 1118, 456);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UpdateAndDelete ud = new UpdateAndDelete();
				int row = table.getSelectedRow();
				String MaUser = (table.getModel().getValueAt(row, 0)).toString();
				String Maphong = (table.getModel().getValueAt(row, 3)).toString();
				try {
					String sql = "SELECT Khackhang.MaUser,Khackhang.Username,Khackhang.Password FROM Khackhang WHERE MaUser='" + MaUser + "'";
					
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						ud.tfmauser.setText(rs.getString("MaUser"));
						ud.setVisible(true);
					}
					pst.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1, "Message", 1);
				}
				
				try {
					String sql1 = "SELECT Datphong.Loaiphong,Datphong.Ngayden,Datphong.Ngaydi,Phong.Giaphong,Datphong.Maphong FROM Datphong,Khackhang,Phong "
							+ "WHERE Datphong.MaUser = Khackhang.MaUser "
							+ "AND Khackhang.Username = '" + labeltk.getText() + "' AND Datphong.Maphong = Phong.Maphong AND Phong.Maphong = '" + Maphong + "'";
					PreparedStatement pst = cn.prepareStatement(sql1);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						ud.lblloaiphong.setText(rs.getString("Loaiphong"));
						ud.tfngayden.setText(rs.getString("Ngayden"));
						ud.tfngaydi.setText(rs.getString("Ngaydi"));
						ud.lblgiaphong.setText(rs.getString("Giaphong"));
						if (rs.getString("Loaiphong").equals("A")) {
							ud.radioButton_A.setSelected(true);
						}
						else if (rs.getString("Loaiphong").equals("B")) {
							ud.radioButton_B.setSelected(true);
						}
						else {
							ud.radioButton_C.setSelected(true);
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog( null, e , "Message", 1);
				}
				
				try {
					String sql1 = "SELECT TOP 1 Datphong.Maphong FROM Datphong,Khackhang,Phong WHERE Datphong.MaUser = Khackhang.MaUser "
							+ "AND Khackhang.Username = '" + labeltk.getText() + "' AND Datphong.Maphong = Datphong.Maphong AND Datphong.Maphong = '" + Maphong + "'";
					PreparedStatement pst = cn.prepareStatement(sql1);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						ud.comboBoxphong.addItem(rs.getString("Maphong"));
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog( null, e , "Message", 1);
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnPhngt = new JButton("Ph\u00F2ng \u0111\u00E3 \u0111\u1EB7t");
		btnPhngt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refesh();
			}
		});
		btnPhngt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPhngt.setBackground(Color.DARK_GRAY);
		btnPhngt.setForeground(Color.WHITE);
		btnPhngt.setBounds(10, 111, 151, 38);
		contentPane.add(btnPhngt);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 28, 117, 38);
		contentPane.add(lblNewLabel);
		labeltk.setForeground(new Color(60, 179, 113));
		labeltk.setFont(new Font("Tahoma", Font.BOLD, 15));
		labeltk.setBounds(137, 28, 195, 38);
		contentPane.add(labeltk);
		
		JLabel lblPassword = new JLabel("Mật khẩu ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 62, 88, 38);
		contentPane.add(lblPassword);
		
		JButton btnBookRoom = new JButton("Đặt phòng");
		btnBookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookRoomUser bk = new BookRoomUser();
				bk.tfusername.setText(labeltk.getText());
				try {
					String sql = "SELECT MaUser FROM Khackhang WHERE Username = '"+ labeltk.getText() +"'";
					PreparedStatement pst = cn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						bk.tfmakhachhang.setText(rs.getString(1));
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog( null, e , "Message", 1);
				}
				bk.setVisible(true);
			}
		});
		btnBookRoom.setForeground(Color.WHITE);
		btnBookRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBookRoom.setBackground(Color.DARK_GRAY);
		btnBookRoom.setBounds(236, 111, 151, 38);
		contentPane.add(btnBookRoom);
		
		labelmk = new JPasswordField();
		labelmk.setForeground(new Color(46, 139, 87));
		labelmk.setAutoscrolls(false);
		labelmk.setBorder(null);
		labelmk.setOpaque(false);
		labelmk.setBounds(137, 73, 195, 20);
		contentPane.add(labelmk);
		
		JButton btniMtKhu = new JButton("Đổi Mật Khẩu");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass cp = new ChangePass();
				cp.tfuser.setText(labeltk.getText());
				cp.setVisible(true);
			}
		});
		btniMtKhu.setForeground(Color.WHITE);
		btniMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btniMtKhu.setBackground(Color.DARK_GRAY);
		btniMtKhu.setBounds(457, 111, 151, 38);
		contentPane.add(btniMtKhu);
	}
}
