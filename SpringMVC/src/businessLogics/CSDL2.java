package businessLogics;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL2 {

	private static DriverManagerDataSource dataSource;

	public static DriverManagerDataSource getJdbc() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/miniShop?useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

}
