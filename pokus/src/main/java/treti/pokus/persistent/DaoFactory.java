package treti.pokus.persistent;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

import treti.pokus.interfaces.DonationDao;
import treti.pokus.interfaces.ParticipantDao;
import treti.pokus.interfaces.PhysicianDao;

public enum DaoFactory {
	INSTANCE;

	private PhysicianDao physicianDao;
	private DonationDao donationDao;
	private ParticipantDao participantDao;
	private JdbcTemplate jdbcTemplate;

	public PhysicianDao getPhysicianDao() {
		if (physicianDao == null)

			physicianDao = new MysqlPhysicianDao(getJdbcTemplate());
		return physicianDao;
	}

	public DonationDao getDonationDao() {
		if (donationDao == null)

			donationDao = new MysqlDonationDao(getJdbcTemplate());
		return donationDao;
	}

	public ParticipantDao getParticipantDao() {
		if (participantDao == null)

			participantDao = new MysqlParticipantDao(getJdbcTemplate());
		return participantDao;
	}

	private JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("paz1c");
			dataSource.setPassword("paz1c");
			dataSource.setDatabaseName("prvodarca");
//				dataSource.setUseSSL(true);
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

}