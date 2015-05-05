package ie.cit.group3.controller;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static PasswordEncoder encoder;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/auth/**").authenticated();

        http.formLogin()
                .defaultSuccessUrl("/auth")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        if(encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }

        return encoder;
    }
} */

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration			//tells Spring this file contains configuration information
@EnableWebMvcSecurity  //enables Springs security's for web (pulls in default SpringSecurity/Spring MVC integration)
@EnableGlobalMethodSecurity(prePostEnabled = true) //enables SpringEL that inspects input parameters and return types.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
/* Configurer Adapter. Construct default bean configurations and contain empty methods that are to be overwritten.
*/
{ 
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {  
 /*  configure(HttpSecurity) method defines which URL paths should be secured and which should not.
   configure default success URL, error routing, where to send logouts etc.
   Paths: "/" & "/home" are configured to not require any authentication. All other paths must be authenticated.*/
    	
    	// @formatter:off
    	http
            .authorizeRequests()
//              .antMatchers("/", "/home").permitAll() //.antMatchers("/**").hasRole("USER")
//               .antMatchers("/").hasRole("USER") //.antMatchers("/**").hasRole("USER")
                .antMatchers("/", "/home").permitAll() //hasRole("ADMIN") //.antMatchers("/**").hasRole("USER")
   //.antMatcher("/", etc).permitAll() = allow any user (including authorised ones) to access this URL 
   //.antMatcher("/admin/**).hasRole("ADMIN") = allow only ADMIN User to access this page.         
            	.antMatchers("/login").hasRole("USER") //.antMatchers("/**").hasRole("USER")
                .antMatchers("/login").hasRole("ADMIN") //.antMatchers("/**").hasRole("USER")
                //.anyRequest().authenticated() 		//All remaining URLs require that the user be successfully authenticated
                .and() //done configuring 'authorizeRequests' & move onto next item to configure.
            .formLogin()   //updates http object itself.
                .loginPage("/login") //tells Spring Security where to re-direct if login required. 
 //new               .failureUrl("/login?error") //
                .permitAll()  //allows all users to access page "/login" (and any URL that form "/login" uses)
                .and()
            .logout()
                .permitAll();
    	// @formatter:on
    }
    
/*    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
           .antMatchers("/browse/**"); // Ignore any request that starts with "/browse/"...this also strips all Bootstrap formatting!! 
    }*/
    
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated();
        http
                .formLogin().failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .permitAll();
    }*/
    
    @Autowired
    private DataSource datasource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//can get a handle on the SpringBoot auto configuration of UserDetails service using: auth.getDefaultUserDetailsService();
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager(); //create new instance of UserDetailsService() provided by Spring.
        userDetailsService.setDataSource(datasource); //associate a datasource to the UserDetailsService()
        PasswordEncoder encoder = new BCryptPasswordEncoder();	//Used to store passwords securely

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);  
        auth.jdbcAuthentication().dataSource(datasource);	//Use JDBC backed Authentication Manager

        if(!userDetailsService.userExists("john")) //test if user "user" exists and creates one if not.
        { 
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            User userDetails = new User("john", encoder.encode("password"), authorities);

            userDetailsService.createUser(userDetails);
        }
    }
    
  /*  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //Uses an in memory user/password/role.
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN","USER");
          }*/
    }
