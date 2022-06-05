package Client.Connection_Login;

import java.awt.BorderLayout;
import Client.Admin.*;
import Client.Connection_Login.*;
import Client.User.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
public class ChooseUserLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseUserLogin frame = new ChooseUserLogin();
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
	public ChooseUserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUser = new JButton("Ng\u01B0\u1EDDi D\u00F9ng");
		btnUser.setIcon(new ImageIcon("src/images/iconfinder_selected_user_1902265.png"));
		btnUser.setBounds(53, 343, 240, 67);
		contentPane.add(btnUser);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUser ru = new LoginUser();
				ru.setVisible(true);
				dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Qu\u1EA3n Tr\u1ECB Vi\u00EAn");
		btnNewButton.setIcon(new ImageIcon("src/images/iconfinder_admin_87402.png"));
		btnNewButton.setBounds(345, 343, 258, 67);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin la = new LoginAdmin();
				la.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Ph\u1EA7n M\u1EC1m Qu\u1EA3n L\u00FD Kh\u00E1ch S\u1EA1n");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setBackground(new Color(105, 105, 105));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel.setBounds(30, 120, 604, 74);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vui l\u00F2ng ch\u1ECDn h\u00ECnh th\u1EE9c \u0111\u0103ng nh\u1EADp");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(165, 269, 327, 42);
		contentPane.add(lblNewLabel_1);
	}
}
