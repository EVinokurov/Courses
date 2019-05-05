package ru.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@ComponentScan("ru.itis")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "customUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    private AuthenticationProvider authenticationProvider;

    @Autowired
    public WebSecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sign-up", "/sign-up-teacher", "/sign-up-student").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/sign-in")
                .usernameParameter("login")
                .defaultSuccessUrl("/sign-up")
                .failureUrl("/sign-in?error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/sign-in")
                .permitAll();
        http.csrf().disable();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider);
    }
}