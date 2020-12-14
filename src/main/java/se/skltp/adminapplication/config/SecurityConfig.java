package se.skltp.adminapplication.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("default")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception {
    auth.inMemoryAuthentication().withUser("user")
        .password(passwordEncoder().encode("password")).roles("USER");
  }

  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest().authenticated()
        .and().formLogin()
        .loginPage("/login").permitAll();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  /*@Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception {
    *//* With this embedded auth in place there is no need to use a datasource to lookup the users *//*
    auth.inMemoryAuthentication()
        .withUser("user").password("password").roles("USER");
  }*/

  /*@Autowired
  private DataSource dataSource;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    //throws Exception {
    try {
      Connection con = dataSource.getConnection("tpadminuser", "tpadminpassword");
      String query = "select anvandarnamn AS username, losenord_hash AS password, true AS enabled from Anvandare where anvandarnamn = 'hbragman'";
      try (Statement stmt = con.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
          String anvnamn = rs.getString("username");
          String password = rs.getString("password");
          System.out.println(anvnamn);
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }

      auth.jdbcAuthentication().dataSource(dataSource)
          .passwordEncoder(new ShaPasswordEncoder())
          .usersByUsernameQuery("select anvandarnamn AS username, losenord_hash AS password, true AS enabled from Anvandare where anvandarnamn = ?")
          .authoritiesByUsernameQuery("select anvandarnamn AS username, CASE WHEN administrator = 1 THEN 'ROLE_ADMIN' ELSE 'ROLE_USER' END AS authority from Anvandare where anvandarnamn = ?");
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }


  @Override
  protected void configure(HttpSecurity http) { //throws Exception {
    try {
      http.authorizeRequests()
          .antMatchers("/**").hasAnyRole("ADMIN", "USER")
          .anyRequest().anonymous().and().httpBasic();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }*/
}

