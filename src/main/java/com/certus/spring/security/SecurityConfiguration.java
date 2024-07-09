package com.certus.spring.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.certus.spring.service.UsuarioService;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UsuarioService usuarioServicio;
    public SecurityConfiguration(UsuarioService usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                "/registro/**",
                "/js/**",
                "/css/**",
                "/img/**",
                "/mdbootstrap/**",
                "/uploads/**",
                "inicio","/","/registro/usuario","/pangea/Administrador","/dashboard","/pangea/nosotros",
                "/pangea/contacto",
                "/paquetes/listarPromociones",
                "/paquetes/detalle/{id}",
                "/paquetes/add",
                "/addpaquete",
                "/usuarios",
                "/edit",
                "/add",
                "/activo",
                "/pendiente",
                "/expirado",
        		"/pangea/cart","/administradorLogin").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/loginUsuario")
                .defaultSuccessUrl("/inicioLogueado",true)
                .permitAll()
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/loginUsuario?logout")
            .permitAll();
    }
}