package com.codegym.ss7_c0222g1.config;

import com.codegym.ss7_c0222g1.service.login.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
//                no need to login
        http.authorizeRequests()
                .antMatchers("/", "/myLogin", "/logout","/home").permitAll();
        http.authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/bootstrap413/**","/css/**", "/js/**","/image/**").permitAll();
//                role match
        http.authorizeRequests().antMatchers("/customer/**").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/employee/**").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/service/**").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/contract/**").access("hasAnyRole('ROLE_ADMIN')");
//                error 403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//                login form setup
        http.authorizeRequests().and().formLogin()
                .loginPage("/myLogin")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password");
                // Cấu hình cho Logout Page.
//                .and().logout().logoutUrl("/home").logoutSuccessUrl("/home");

        http.authorizeRequests().and().rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(24 * 60 * 60);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}
