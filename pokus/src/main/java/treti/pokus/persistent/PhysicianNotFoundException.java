package treti.pokus.persistent;

public class PhysicianNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4188159083083625503L;

	private long physicianId;

	public PhysicianNotFoundException(long physicianId) {
		this.physicianId = physicianId;
	}

	public long getPhysicianId() {
		return physicianId;
	}
}
