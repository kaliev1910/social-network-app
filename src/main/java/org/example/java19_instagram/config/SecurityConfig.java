package org.example.java19_instagram.config;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String USER_QUERY = "select username,password,enabled from users where username=?";
    private static final String AUTHORITIES_QUERY = """
            select u.username, au.authority
            from user_authorities ua inner join users u on u.user_id = ua.user_id
            inner join authorities au on au.id = ua.authority_id where u.user_id=?
            """;
    private final PasswordEncoder encoder;
    private final DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USER_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY)
                .passwordEncoder(new BCryptPasswordEncoder())

        ;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/profile")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .permitAll())
                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/profile").authenticated()
//                        .requestMatchers(HttpMethod.GET, "/vacancy").hasRole(AccountType.EMPLOYER.getValue())
//                        .requestMatchers(HttpMethod.GET, "/resumes").hasRole(AccountType.EMPLOYER.getValue())
//                        .requestMatchers(HttpMethod.GET, "/resume/**").authenticated()
//                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .anyRequest().permitAll()
                )
        ;

        return http.build();
    }

}
