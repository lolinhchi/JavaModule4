package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javaBeans.Category;

public class CategoryBL {

	private static final DriverManagerDataSource dataSource = CSDL2.getJdbc();
	
	public static List<Category> getParents() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = " select * from category where parentid is null";
		/*
		 * return jdbc.query(query, new RowMapper<Category>() {
		 * 
		 * @Override public Category mapRow(ResultSet rs, int arg1) throws SQLException
		 * { Category cat = new Category(); cat.setId(rs.getInt("categoryid"));
		 * cat.setName(rs.getString("categoryname"));
		 * cat.setParent(rs.getInt("parentid")); return cat; } });
		 */
		return jdbc.query(query, new AnhXaDong());
	}
	
	public static List<Category> getChildrens() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = " select * from category where parentid is not null";
		/*
		 * return jdbc.query(query, new RowMapper<Category>() {
		 * 
		 * @Override public Category mapRow(ResultSet rs, int arg1) throws SQLException
		 * { Category cat = new Category(); cat.setId(rs.getInt("categoryid"));
		 * cat.setName(rs.getString("categoryname"));
		 * cat.setParent(rs.getInt("parentid")); return cat; } });
		 */
		return jdbc.query(query, new AnhXaDong());
	}
	
	public static class AnhXaDong implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int numRow) throws SQLException {
			Category cat = new Category();
			cat.setId(rs.getInt("categoryid"));
			cat.setName(rs.getString("categoryname"));
			cat.setParent(rs.getInt("parentid"));
			return cat;
		}
	}
	
	public static int them(Category cat) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = "insert into category(categoryname, parentid) values (?, ?)";
		return jdbc.update(query, cat.getName(), cat.getParent());
	}
	public static void main(String[] args) {
//		List<Category> lst = getParents();
		List<Category> lst = getChildrens();
		lst.forEach(cat ->System.out.println(cat.getId() + " - " + cat.getName()));
	}
}
