package com.mx.iledudev.ilemarket.web.security;


import com.mx.iledudev.ilemarket.domain.service.security.IleUserDetails;
import com.mx.iledudev.ilemarket.web.filter.JWTFilterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final IleUserDetails ileUserDetails;
    private final JWTFilterRequest jwtFilterRequest;
    @Override

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(ileUserDetails);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate-user" , "/v2/api-docs", "/configuration/ui", "/**/swagger-resources/**",
                        "/**/configuration/**", "/**/swagger-ui/index.html", "/**/swagger-ui/**", "/webjars/**" , "/**/srf")
                .permitAll().anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }


}
