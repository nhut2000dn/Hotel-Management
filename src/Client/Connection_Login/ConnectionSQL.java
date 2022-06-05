package Client.Connection_Login;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionSQL {
	Connection cn;
	public Connection conect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSan;", "sa", "sa");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection SQL sucessful", "Message", 1);
		}
		return cn;
	}
}
