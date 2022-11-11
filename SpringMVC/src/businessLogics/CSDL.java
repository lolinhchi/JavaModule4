package businessLogics;


import java.sql.Connection;
import java.sql.DriverManager;

public class CSDL {
	private static Connection ketNoi;
	private static String url = "jdbc:mysql://localhost:3306/qlbansua?useUsenicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";

	public static Connection getKetNoi() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ketNoi = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			
		}
		return ketNoi;
	}

	public static void main(String[] args) {
		Connection kn = getKetNoi();
		if (kn != null) {
			System.out.println("Ket noi thanh cong");
		} else {
			System.out.println("Ket noi that bai");
		}
	}

}
