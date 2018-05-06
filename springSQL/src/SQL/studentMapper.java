package SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class studentMapper implements RowMapper<student>{
	public student mapRow(ResultSet rs, int rowNum) throws SQLException {
	      student student = new student();
	      student.setId(rs.getInt("id"));
	      student.setName(rs.getString("name"));
	      student.setAge(rs.getInt("age"));
	      return student;
	   }
}
