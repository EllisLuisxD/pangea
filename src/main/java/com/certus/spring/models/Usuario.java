package com.certus.spring.models;

import java.util.Collection;
import java.util.Arrays;
import javax.persistence.*;

@Entity
@Table(name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    
    @Column(unique = true)
    private String username;
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

    // Constructores existentes
    public Usuario() {
        super();
    }

    public Usuario(String nombres, String apellidos, String correo, String username, String password, Collection<Rol> roles) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(Long id, String nombres, String apellidos, String correo, String username, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Nuevos métodos estáticos para crear usuarios y administradores
    public static Usuario crearUsuario(String nombres, String apellidos, String correo, String username, String password) {
        return new Usuario(nombres, apellidos, correo, username, password, Arrays.asList(new Rol("ROLE_USER")));
    }

    // Getters y setters existentes
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

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}