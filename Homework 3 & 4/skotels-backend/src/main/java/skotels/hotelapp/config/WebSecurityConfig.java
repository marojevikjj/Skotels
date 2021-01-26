package skotels.hotelapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import skotels.hotelapp.service.implementation.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        // securedEnabled = true,
//        // jsr250Enabled = true,
//        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsService;
    //private final AuthEntryPointJwt unauthorizedHandler;
    //private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService,
                             //AuthEntryPointJwt unauthorizedHandler,
                             //JwtUtils jwtUtils,
                             PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        //this.unauthorizedHandler = unauthorizedHandler;
        //this.jwtUtils = jwtUtils;
    }

    //@Bean
    //public AuthTokenFilter authenticationJwtTokenFilter() {
    //    return new AuthTokenFilter(this.jwtUtils, this.userDetailsService);
    //}

    //@Override
    //public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    //    authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder);
    //}

    //@Bean
    //@Override
    //public AuthenticationManager authenticationManagerBean() throws Exception {
    //    return super.authenticationManagerBean();
    //}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                //.exceptionHandling()
                //.authenticationEntryPoint(unauthorizedHandler)
                //.and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();

        //http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}