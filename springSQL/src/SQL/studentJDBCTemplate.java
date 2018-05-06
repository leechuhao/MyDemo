package SQL;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class studentJDBCTemplate implements studentDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; 

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "insert into Student (name, age) values(?, ?)";
		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created record name = " + name + " Age = " + age);
		return;
	}

	@Override
	public student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Student where id = ?";
		student stu = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new studentMapper());
		return stu;
	}

	@Override
	public List<student> listStudents() {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		List<student> stu = jdbcTemplateObject.query(sql, new studentMapper());
		return stu;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Deleted record with id = " + id);
		return ;
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String sql = "update student set age = ? where id = ?";
		jdbcTemplateObject.update(sql, age , id);
		System.out.println("Updated record with id = " + id);
		return;
	}

}
