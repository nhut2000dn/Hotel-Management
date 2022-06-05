package Server;

import java.rmi.Naming;

public class ClientTest {
	public static void main(String arg[]) {
		try {
			InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
			c.registerUser("hello", "helo", "helo", "helo");
					
		} catch (Exception e) {
			System.out.println("no");
		}
	}
}
