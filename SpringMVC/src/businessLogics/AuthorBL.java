package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Author;

public class AuthorBL {
	private static final JdbcTemplate jdbc = CSDL2.getJdbc();

	public static List<Author> docTatCa() {
		String query = "select * from Author";
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
		String query = "Insert into Author(AuthorName) values(?)";
		return jdbc.update(query, au.getName());
	}

	public static int xoa(Author au) {
		String query = "Delete from Author where AuthorId = ?";
		return jdbc.update(query, au.getId());
	}

	public static int sua(Author au) {
		String query = "update Author set AuthorName = ? where AuthorId = ?";
		return jdbc.update(query, au.getName(), au.getId());
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Author au = docTheoId(27); System.out.println(au.getId() + " - " +
	 * au.getName()); au.setName("Gee Gee"); int row = sua(au); Author au1 =
	 * docTheoId(27); System.out.println(au.getId() + " - " + au.getName());
	 * 
	 * int row = them(au); if (row > 0) { System.err.println("Thêm thành công"); }
	 * else { System.err.println("Thất bại"); } Author au = docTheoId(28); int row =
	 * xoa(au);
	 * 
	 * List<Author> lst = docTatCa(); for (Author a : lst) {
	 * System.out.println(a.getId() + " - " + a.getName()); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
