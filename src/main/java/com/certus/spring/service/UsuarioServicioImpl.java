package com.certus.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.certus.spring.Dto.UsuarioRegistroDto;
import com.certus.spring.models.Rol;
import com.certus.spring.models.Usuario;
import com.certus.spring.repository.UsuarioRepository;

@Service
public class UsuarioServicioImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepository usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDto registroDTO) {
        Usuario usuario = new Usuario(
            registroDTO.getNombres(),
            registroDTO.getApellidos(),
            registroDTO.getCorreo(),
            registroDTO.getUsername(),
            passwordEncoder.encode(registroDTO.getPassword()),
            Arrays.asList(new Rol("ROLE_USER"))
        );
        System.out.println("Usuario creado: " + usuario);
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByUsername(username);
        if (usuario == null) {
            System.out.println("Usuario no encontrado: " + username);
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        System.out.println("Usuario encontrado: " + usuario.getUsername());
        return new User(usuario.getUsername(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}

