package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterFace extends Remote{
	public int loginUser(String a, String b) throws RemoteException;
	public int loginAdmin(String a, String b) throws RemoteException;
	public int registerUser(String a, String b, String c, String d, String e, String f, String g) throws RemoteException;
	public int UpdateUser(String a, String b, String c, String d, String e) throws RemoteException;
	public int DeleteUser(String a) throws RemoteException;
	public int BookRoomUser(String a, String b, String c, String d, String e) throws RemoteException;
	public int ChangePassword(String a, String b, String c) throws RemoteException;
	public int checkUser(String a) throws RemoteException;
	public int DeleteAccount(String a) throws RemoteException;
	public int UpdateAccount(String a, String b, String c, String d, String e, String f, String g) throws RemoteException;
	public void registerUser(String a, String b, String c, String d) throws RemoteException;
}