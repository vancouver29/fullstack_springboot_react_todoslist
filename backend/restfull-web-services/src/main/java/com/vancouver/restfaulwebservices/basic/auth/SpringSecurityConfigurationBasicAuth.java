package com.vancouver.restfaulwebservices.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http
                // Disable csrf authentication security
                .csrf().disable()
                .authorizeRequests()
                // accept option's request to all URLs. Authenticate all the other requests
                // and use http basic authentication
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest()).authenticated()
                .and())
                //.formLogin().and()
        )
                .httpBasic();
    }
}
