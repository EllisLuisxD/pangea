package com.certus.spring.Dto;

public class UsuarioRegistroDto {

	private Long id;

    private String nombres;
    private String apellidos;
    private String correo;
    private String username;
    private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsuarioRegistroDto(String nombres, String apellidos, String correo, String username, String password) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.username = username;
		this.password = password;
	}
	public UsuarioRegistroDto() {
		super();
	}
	
	@Override
	public String toString() {
	    return "UsuarioRegistroDto{" +
	            "id=" + id +
	            ", nombres='" + nombres + '\'' +
	            ", apellidos='" + apellidos + '\'' +
	            ", correo='" + correo + '\'' +
	            ", username='" + username + '\'' +
	            ", password='" + (password != null ? "No null" : "Null") + '\'' +
	            '}';
	}

    

}