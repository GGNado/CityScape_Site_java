package com.naado.cityscapesite.config;

import com.naado.cityscapesite.model.ServerAccount;
import com.naado.cityscapesite.repository.ServerAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
        ServerAccountRepo repoAcc;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/contact/**", "/images/**", "/contact/sendInfo").permitAll() // Consenti l'accesso a tutto il contenuto in /images/
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        List<UserDetails> usersAuth = new ArrayList<UserDetails>();
        List<ServerAccount> users = repoAcc.findAll();
        for (ServerAccount u : users) {
            //Vengono caricati tutti gli utenti registrati per
            //autorizzarli all'accesso
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(u.getNickname())
                    .password(u.getPassword())
                    .roles(u.getRole().getNome())
                    .build();
            usersAuth.add(user);

            System.out.println(u.getNickname() + " : " + u.getPassword() + " " + u.getRole().getNome());
        }

        return new InMemoryUserDetailsManager(usersAuth);
    }
}