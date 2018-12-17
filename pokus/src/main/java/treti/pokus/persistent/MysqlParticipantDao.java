package treti.pokus.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import treti.pokus.entity.Donation;
import treti.pokus.entity.Notification;
import treti.pokus.entity.Participant;
import treti.pokus.entity.Physician;
import treti.pokus.enumy.BloodType;
import treti.pokus.enumy.DonationType;
import treti.pokus.enumy.Gender;
import treti.pokus.enumy.Role;
import treti.pokus.interfaces.ParticipantDao;

public class MysqlParticipantDao implements ParticipantDao {
	private JdbcTemplate jdbcTemplate;

	public MysqlParticipantDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addParticipant(Participant participant) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("participant");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
		simpleJdbcInsert.usingColumns("role", "name", "surname", "insuranceId", "email", "password", "dateOfBirth",
				"gender", "weight", "dateOfLastDonation", "countOfDonations");
		Map<String, Object> values = new HashMap<>();
		values.put("role", participant.getRole());
		values.put("name", participant.getName());
		values.put("surname", participant.getSurname());
		values.put("insuranceId", participant.getInsuranceId());
		values.put("email", participant.getEmail());
		values.put("password", participant.getPassword());
		values.put("dateOfBirth", participant.getDateOfBirth());
		values.put("gender", participant.getGender());
		values.put("weight", participant.getWeight());
		values.put("dateOfLastDonation", participant.getDateOfLastDonation());
		values.put("countOfDonations", participant.getCountOfDonations());
		Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
		participant.setId(id);
//		insertNotifications(participant);
	}

//	private void insertNotifications(Participant participant) {
//		List<Notification> notifications = participant.getNotifications();
//		if (notifications != null && notifications.size() > 0) {
//			String insertSql = "INSERT INTO notification (id, physicianId, message) VALUES (?,?,?)";
//			for (Notification notification : notifications) {
//				jdbcTemplate.update(insertSql, notification.getId(), notification.getPhysicianId(),
//						notification.getMessage());
//			}
//		}
//	}

//		TODO SAVE 
//	@Override
//	public void save(Participant participant) {
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
//	}

	@Override
	public List<Participant> getAll() {
		String sql = "SELECT id, role, bloodType, name, surname, insuranceId, email, password, dateOfBirth, gender, weight, dateOfLastDonation, countOfDonations FROM participant";
		List<Participant> participants = jdbcTemplate.query(sql, new RowMapper<Participant>() {

			@Override
			public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
				Participant participant = new Participant();
				participant.setId(rs.getLong("id"));
				// FIXME moze vyskytnut' NullPointerException alebo IllegalArgumentException
				participant.setRole(Role.valueOf(rs.getString("role")));
				// FIXME moze vyskytnut' NullPointerException alebo IllegalArgumentException
				participant.setBloodType(BloodType.valueOf(rs.getString("bloodType")));
				participant.setName(rs.getString("name"));
				participant.setSurname(rs.getString("surname"));
				participant.setInsuranceId(rs.getString("insuranceId"));
				participant.setEmail(rs.getString("email"));
				participant.setPassword(rs.getString("password"));
				Timestamp timestampDateOfBirth = rs.getTimestamp("dateOfBirth");
				if (timestampDateOfBirth != null) {
					participant.setDateOfBirth(timestampDateOfBirth.toLocalDateTime().toLocalDate());
				}
				// FIXME moze vyskytnut' NullPointerException alebo IllegalArgumentException
				participant.setGender(Gender.valueOf(rs.getString("gender")));
				participant.setWeight(rs.getDouble("weight"));
				Timestamp timestampDateOfLastDonation = rs.getTimestamp("dateOfLastDonation");
				if (timestampDateOfLastDonation != null) {
					participant.setDateOfLastDonation(timestampDateOfLastDonation.toLocalDateTime().toLocalDate());
				}
				participant.setCountOfDonations(rs.getInt("countOfDonations"));

				return participant;
			}
		});
		return participants;
	}

	@Override
	public List<Participant> findPhysicianByInsuranceId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Participant> findPhysicianBySurname(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
