package vn.loh.web_springsecurity.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import vn.loh.web_springsecurity.repositories.UserInforRepository;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserInforRepository userInforRepository;

    @Bean
    UserDetailsService userDetailsService() {
        return new UserInforService(userInforRepository);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF (for testing purposes)
//                .authorizeHttpRequests(auth -> auth
//                        // Allow all users to access the login page
//                        .requestMatchers("/user/new").permitAll()
//                        // Allow all users to access the homepage and static resources
//                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
//                        // Protect customer pages (require authentication)
//                        .requestMatchers("/customer/**").authenticated()
//                        // Allow all other pages explicitly mentioned
//                        // .anyRequest().permitAll() // Permit all remaining pages
//                )
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }

}
