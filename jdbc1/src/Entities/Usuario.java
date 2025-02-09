package Entities;

public class Usuario {
	private Integer id;
	private String name;
	private String email;
	
	 
	public Usuario(Integer id,String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Usuario() {}
	
	public Usuario(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@Override
	public String toString() {
		return String.format("ID -> %d%nNAME -> %s%nEMAIL -> %s%n",getId(), getName(), getEmail());
	}
	
}
