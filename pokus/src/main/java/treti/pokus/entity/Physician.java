package treti.pokus.entity;

public class Physician {
	private Long id;
	private String login;
	private String password;
	private String name;
	private String surname;

	// posle spravu
	// nastavi pocet darovani
	// nastavi datum darovania

	
	
	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Physician [id=" + id + ", password=" + password + ", name=" + name + ", surname=" + surname + "]";
	}

}
