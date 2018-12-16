package treti.pokus.persistent;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum PhysicianDaoFactory {
	INSTANCE;
	
	private PhysicianDao physicianDao;
	
	public PhysicianDao getPhysicianDao() {
		if(physicianDao == null)
			
			physicianDao = getMysqlPhysicianDao();
		return physicianDao;
	}
	
	public MysqlPhysicianDao getMysqlPhysicianDao() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("paz1c");
		dataSource.setPassword("paz1c");
		dataSource.setDatabaseName("prvodarca");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return new MysqlPhysicianDao(jdbcTemplate);
	}

}
