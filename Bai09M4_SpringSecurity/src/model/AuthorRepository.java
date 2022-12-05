package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public class AuthorRepository extends Repository {
	public List<Author> getAuthors(){
		
		return jdbc.query("SELECT * FROM Author", new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
			}
		});
	}
	public int add(Author obj) {
		return jdbc.update("INSERT INTO Author (AuthorName) VALUES(?)", obj.getName());
	}
	public int edit(Author obj) {
		return jdbc.update("UPDATE Author SET AuthorName = ? WHERE AuthorId = ?", obj.getName(), obj.getId());
	}
	public Author getAuthor(int id) {
		return jdbc.queryForObject("SELECT * FROM Author WHERE AuthorId = ?", new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
			}
		}, id);
	}
	public int delete(int id) {
		return jdbc.update("DELETE FROM Author WHERE AuthorId = ?", id);
	}
	public int delete(List<Integer> list) {
		for (Integer id : list) {
			jdbc.update("DELETE FROM Author WHERE AuthorId = ?", id);
		}
		return 1;
		
	}
	
}
