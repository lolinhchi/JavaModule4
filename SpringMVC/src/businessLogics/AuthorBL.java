package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javaBeans.Author;

public class AuthorBL {
	private static DriverManagerDataSource dataSource = CSDL2.getJdbc();

	public static List<Author> docTatCa() {
		String query = "select * from Author";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		return jdbc.query(query, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author au = new Author();
				au.setId(rs.getInt("AuthorId"));
				au.setName(rs.getString("AuthorName"));
				return au;
			}
		});
	}

	public static Author docTheoId(int id) {
		String query = "select * from Author where AuthorId = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		return jdbc.queryForObject(query, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int arg1) throws SQLException {
				Author au = new Author();
				au.setId(rs.getInt("AuthorId"));
				au.setName(rs.getString("AuthorName"));
				return au;
			}
		}, id);
	}

	public static int them(Author au) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = "Insert into Author(AuthorName) values(?)";
		return jdbc.update(query, au.getName());
	}

	public static int xoa(Author au) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = "Delete from Author where AuthorId = ?";
		return jdbc.update(query, au.getId());
	}

	public static int sua(Author au) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = "update Author set AuthorName = ? where AuthorId = ?";
		return jdbc.update(query, au.getName(), au.getId());
	}
	
	
	public static int them2() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String query = "insert into author(authorname) values(?)";
		int smt = 0;
		DefaultTransactionDefinition td = new DefaultTransactionDefinition();
		JdbcTransactionManager tm = new JdbcTransactionManager(dataSource);
		TransactionStatus ts = tm.getTransaction(td);
		try {
			smt += jdbc.update(query, "AA", "Sua AA");
			smt += jdbc.update(query, "BB", "Sua BB");
			smt += jdbc.update(query, "CC", "Sua CC");
			smt += jdbc.update(query, "AA", "Sua AA");
			tm.commit(ts);
		}catch (Exception e) {
			smt = 0;
			tm.rollback(ts);
		}
		return smt;
	}

	
	public static void main(String[] args) {

		/*
		 * Author au = docTheoId(27); System.out.println(au.getId() + " - " +
		 * au.getName()); au.setName("Gee Gee"); int row = sua(au);
		 */
		/*
		 * Author au1 = docTheoId(27); System.out.println(au.getId() + " - " +
		 * au.getName());
		 * 
		 * int row = them(au); if (row > 0) { System.err.println("Thêm thành công"); }
		 * else { System.err.println("Thất bại"); } Author au = docTheoId(28); int row =
		 * xoa(au);
		 */

		List<Author> lst = docTatCa();
		for (Author a : lst) {
			System.out.println(a.getId() + " - " + a.getName());
		}

	}
	 

}
