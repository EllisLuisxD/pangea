package com.certus.spring.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.certus.spring.interfaces.ILoginRepository;
import com.certus.spring.models.Usuario;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private ILoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = loginRepository.loadUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER") // Puedes ajustar los roles según tu aplicación
                .build();
    }
}



