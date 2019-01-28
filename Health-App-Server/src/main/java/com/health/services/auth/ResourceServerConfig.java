package com.health.services.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer config) throws Exception {
        config.resourceId("healthApp#36")
        .stateless(false);
    }

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/oauth/token", "/user")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}