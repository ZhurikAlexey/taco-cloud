package tacos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        auth.ldapAuthentication()
                //.userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
               // .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                //.passwordCompare()
                //.passwordEncoder(new BCryptPasswordEncoder())
                //.passwordAttribute("passcode")
                //.and()
                .contextSource()
               // .root("dc=tacocloud,dc=com")
                .ldif("classpath:users.ldif");*/
        auth.inMemoryAuthentication()
                .withUser("buzz")
                .password("{noop}infinity")
                .authorities("ROLE_USER")
                .and()
                .withUser("woody")
                .password("{noop}bullseye")
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /**for using h2 database*/
        http.authorizeRequests()
                .antMatchers("/h2console/**")
                .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/design").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin();

    }
}
