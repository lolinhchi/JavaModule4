package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.Product;

public class ProductBL {
	private static final DriverManagerDataSource dataSource = CSDL2.getJdbc();
	
	public static int count() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = "Select count(*) as total from product";
		return jdbc.queryForObject(query, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getInt("total");
			}
		});
	}
	
	public static List<Product> getproducts(int page, int size) {
		String query = "Select * from product limit ?,?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		return jdbc.query(query, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product pd = new Product();
				pd.setId(rs.getInt("productId"));
				pd.setTitle(rs.getString("title"));
				pd.setIsbn(rs.getString("isbn"));
				pd.setPages(rs.getInt("pages"));
				pd.setPrice(rs.getInt("price"));
				return pd;
				
			}
			
		}, (page -1)*size, size);
	}

}
