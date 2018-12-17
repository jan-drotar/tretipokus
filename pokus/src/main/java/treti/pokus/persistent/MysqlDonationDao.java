package treti.pokus.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import treti.pokus.entity.Donation;
import treti.pokus.enumy.DonationType;
import treti.pokus.interfaces.DonationDao;

public class MysqlDonationDao implements DonationDao {

	private JdbcTemplate jdbcTemplate;

	public MysqlDonationDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addDonation(Donation donation) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("donation");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
		simpleJdbcInsert.usingColumns("donationType", "idDonor", "idRecipient", "idPhysician", "tested", "approved",
				"registered");
		Map<String, Object> values = new HashMap<>();
		values.put("donationType", donation.getDonationType());
		values.put("idDonor", donation.getIdDonor());
		values.put("idRecipient", donation.getIdRecipient());
		values.put("idPhysician", donation.getIdPhysician());
		values.put("tested", donation.isTested());
		values.put("approved", donation.isApproved());
		values.put("registered", donation.getRegistered());
		Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
		donation.setId(id);
	}

//		TODO SAVE 
	@Override
	public void save(Donation donation) {
//			if (workshop == null)
//			return null;
//		if (workshop.getId() == null) { //CREATE
//			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//			simpleJdbcInsert.withTableName("workshop");
//			simpleJdbcInsert.usingGeneratedKeyColumns("id");
//			simpleJdbcInsert.usingColumns("name", "start", "end", "price_full",
//					"price_student", "price_full_late", "price_student_late");
//			Map<String,Object> hodnoty = new HashMap<>();
//			hodnoty.put("name",workshop.getName());
//			hodnoty.put("start",workshop.getStart());
//			hodnoty.put("end", workshop.getEnd());
//			hodnoty.put("price_full", workshop.getPriceFull());
//			hodnoty.put("price_student", workshop.getPriceStudent());
//			hodnoty.put("price_full_late", workshop.getPriceFullLate());
//			hodnoty.put("price_student_late", workshop.getPriceStudentLate());
//			Long id = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
//			workshop.setId(id);
//		} else { //UPDATE
//			String sql = "UPDATE workshop SET "
//					+ "name = ?, start = ?, end = ?, price_full = ?, "
//					+ "price_student = ?, price_full_late = ?, price_student_late = ? "
//					+ "WHERE id = ?";
//			jdbcTemplate.update(sql,
//					workshop.getName(), workshop.getStart(),
//					workshop.getEnd(), workshop.getPriceFull(),
//					workshop.getPriceStudent(),	workshop.getPriceFullLate(),
//					workshop.getPriceStudentLate(),	workshop.getId());
//		}
//		return workshop;
	}

	@Override
	public List<Donation> getAll() {
		String sql = "SELECT id, donationType, idDonor, idRecipient, idPhysician, tested, approved, registered FROM donation";
		return jdbcTemplate.query(sql, new RowMapper<Donation>() {
			@Override
			public Donation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Donation donation = new Donation();
				donation.setId(rs.getLong("id"));
				// FIXME moze vyskytnut' NullPointerException alebo IllegalArgumentException
				donation.setDonationType(DonationType.valueOf(rs.getString("donationType")));
				donation.setIdDonor(rs.getLong("idDonor"));
				donation.setIdRecipient(rs.getLong("idRecipient"));
				donation.setIdPhysician(rs.getLong("idPhysician"));
				donation.setTested(rs.getBoolean("tested"));
				donation.setApproved(rs.getBoolean("approved"));
				Timestamp timestamp = rs.getTimestamp("registered");
				if (timestamp != null) {
					donation.setRegistered(timestamp.toLocalDateTime().toLocalDate());
				}
				return donation;
			}
		});
	}

	@Override
	public List<Donation> getUntested() {
		// TODO Auto-generated method stub
		return null;
	}
}
