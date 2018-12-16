package treti.pokus.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import treti.pokus.entity.Physician;

public class MysqlPhysicianDao implements PhysicianDao{

	JdbcTemplate jdbcTemplate;
	
	public MysqlPhysicianDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void add(Physician physician) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.setTableName("physician");
		insert.setGeneratedKeyName("id");
		insert.usingColumns("name" , "surname" , "password");
		
		Map <String, Object> values = new HashMap<>();
		values.put("name", physician.getName());
		values.put("surname", physician.getSurname());
		values.put("password", physician.getPassword());
		
		physician.setId(insert.executeAndReturnKey(values).longValue());
	}

	@Override
	public void update(Physician physician) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Physician> getAll() {
		String sql = "SELECT id, name, surname, password FROM physician;";
		List<Physician> physicians = jdbcTemplate.query(sql, new RowMapper<Physician>() {

			@Override
			public Physician mapRow(ResultSet rs, int rowNum) throws SQLException {
				Physician physician = new Physician();
				physician.setId(rs.getLong("id"));
				physician.setName(rs.getString("name"));
				physician.setSurname(rs.getString("surname"));
				physician.setPassword(rs.getString("password"));
				return physician;
			}
			
		});
		return physicians;
	}

}
