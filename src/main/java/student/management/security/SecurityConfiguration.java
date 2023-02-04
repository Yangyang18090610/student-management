package student.management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public AuthenticationManager authenticationManager(
            HttpSecurity http,
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder
    ) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors(withDefaults())



//                phân quyền : authorizeHttpRequests
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests
                                .antMatchers(HttpMethod.DELETE)
                                .hasAuthority("ADMIN")
                                .antMatchers(HttpMethod.POST, "/api/v1/students/**", "/api/v1/schools/**")
                                .hasAnyAuthority("ADMIN", "MANAGER")
                                .antMatchers(HttpMethod.PUT, "/api/v1/students/**", "/api/v1/schools/**")
                                .hasAnyAuthority("ADMIN", "MANAGER")

                                .antMatchers("/api/v1/auth/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(formLogin ->
                                formLogin
//                                Đường dẫn của trang login
                                        .loginPage("/page/auth/login/index.html")
//                                Đường dẫn đến người xử lý
                                        .loginProcessingUrl("/api/v1/auth/login")
                                        .defaultSuccessUrl("/index.html")
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/api/v1/auth/logout")
                                .deleteCookies("JSESSIONID")
                )
                .rememberMe(rememberMe -> rememberMe.key("uniqueAndSecret"))


                .httpBasic();
        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(
                "/",
                "/index.html",
                "/common/**",
                "/page/**"
        );
    }

}
