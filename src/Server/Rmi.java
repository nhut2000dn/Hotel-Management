package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import Client.User.*;
import Client.Connection_Login.*;
import Client.Admin.*;

public class Rmi extends UnicastRemoteObject implements InterFace{
	ConnectionSQL cnn = new ConnectionSQL();
	Connection cn = cnn.conect();
	protected Rmi() throws RemoteException {
		int a,b;
		// TODO Auto-generated constructor stub
	}
	public int loginUser(String user, String password) {
		try {
			int count = 0;
			String sql = "SELECT Username,Password FROM Khackhang WHERE Username=? AND Password=? AND Role = 1";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count++;
			}
			if (count == 1) {
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e2) {
			return 0;
		}
	}
	@Override
	public int checkUser(String Username) throws RemoteException {
		try {
			String sql = "SELECT * FROM khackhang WHERE UserName = '" + Username + "'";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 1;
	}
	@Override
	public int registerUser(String UserName, String PassWord, String Hoten, String Ngaysinh, String Gioitinh, String SĐT, String Quocgia) throws RemoteException {
		try {
			String sql = "INSERT INTO Khackhang(UserName,PassWord,Hoten,Ngaysinh,Gioitinh,SĐT,Quocgia,Role) "
					+ "VALUES('" + UserName + "','" + PassWord + "',N'" + Hoten + "','" 
					+ Ngaysinh + "',N'" + Gioitinh 
					+ "','" + SĐT + "',N'" + Quocgia + "','" + 1 + "')";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.executeUpdate();
			return 1;
		} catch (Exception e2) {
			return 0;
		}
	}
	@Override
	public int UpdateUser(String Maphong, String Loaiphong, String Ngayden, String Ngaydi, String MaUser) throws RemoteException {
		String sql = "UPDATE Datphong SET Maphong = '" + Maphong + "', Loaiphong = '" + Loaiphong 
		+ "', Ngayden = '" + Ngayden + "', Ngaydi = '"  + Ngaydi + "' WHERE MaUser = '" + MaUser + "'";
		try {
			Statement stmt = cn.createStatement();
			int n = stmt.executeUpdate(sql);
			return 1;
		} catch (Exception e2) {
			return 0;
		}
	}
	@Override
	public int DeleteUser(String Maphong) throws RemoteException {
		try {
			String sql = "DELETE FROM Datphong WHERE Maphong = '" + Maphong + "'" ;
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e2) {
		}
		try {
			String sql = "UPDATE Phong SET Tinhtrang = '0' WHERE Phong.Maphong = '" + Maphong + "'" ;
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog( null, e2 , "Message", 1);
		}
		return 0;
	}
	@Override
	public int BookRoomUser(String MaKH, String MaPhong, String LoaiPhong, String NgayDen, String NgayDi) throws RemoteException {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			JOptionPane.showMessageDialog( null, sdf.format(date) , "Message", 1);
			String sql = "INSERT INTO Datphong VALUES('"  + MaKH + "','" + MaPhong + "','" + LoaiPhong 
			+ "','" + NgayDen + "','" 
					+ NgayDi +  "','"+ sdf.format(date) +"','0')" ;
			String sql1 = "UPDATE Phong SET Tinhtrang = '1' WHERE Maphong = '" + MaPhong + "'";
			PreparedStatement pst = cn.prepareStatement(sql);
			int n = pst.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e , "Message", 1);
		}
		try {
			String sql1 = "UPDATE Phong SET Tinhtrang = '1' WHERE Maphong = '" + MaPhong + "'";
			PreparedStatement pst = cn.prepareStatement(sql1);
			int n = pst.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e , "Message", 1);
		}
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int ChangePassword(String UserName, String PasswordCu, String PasswordMoi) {
		String sql1 = "SELECT * FROM Khackhang WHERE Username = '" + UserName + "' AND Password = '" + PasswordCu + "'";
		try {
			PreparedStatement pst = cn.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				try {
					String sql = "UPDATE Khackhang SET Password = '" + PasswordMoi + "' WHERE Username = '" + UserName + "'";
					PreparedStatement pst1 = cn.prepareStatement(sql);
					int n = pst1.executeUpdate();
					return 1;
				} catch (Exception e2) {
				}
			}
		} catch (Exception e2) {
		}
		return 0;
	}
	@Override
	public int loginAdmin(String User, String Password) throws RemoteException {
		try {
			int count = 0;
			String sql = "SELECT * FROM Khackhang WHERE Username=? AND Password=? AND Role = '0'";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, User);
			pst.setString(2, Password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count++;
			}
			if (count == 1) {
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public int DeleteAccount(String Username) throws RemoteException {
		try {
			String sql = "DELETE FROM Khackhang WHERE UserName='" +Username+ "'" ;
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.executeUpdate();
			return 1;
		} catch (Exception e2) {
		}
		return 0;
	}
	@Override
	public int UpdateAccount(String Username, String Password, String Hoten, String Ngaysinh, String Gioitinh, String SĐT, String Quocgia) throws RemoteException {
		String sql = "UPDATE Khackhang SET Username = '" + Username + "', Password = '" + Password + "', Hoten = N'" + Hoten 
		+ "', Ngaysinh = '" + Ngaysinh + "', Gioitinh = N'" + Gioitinh + "', SĐT = '" + SĐT
		+ "', Quocgia = N'" + Quocgia + "' WHERE Username = '" + Username + "'";
		try {
			Statement stmt = cn.createStatement();
			int n = stmt.executeUpdate(sql);
			return 1;
		} catch (Exception e2) {
		}
		return 0;
	}
	@Override
	public void registerUser(String a, String b, String c, String d) throws RemoteException {

		System.out.println(a+b+c+d);
	}
}
