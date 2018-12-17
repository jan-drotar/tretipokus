package treti.pokus.entity;

public class Notification {

	private int id;
	private int physicianId;
	private String message;

	public void setId(int id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "(" + id + ")" + physicianId + ": " + message;
	}

}
