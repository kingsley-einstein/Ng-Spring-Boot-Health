package com.health.services.auth;

import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authManager;

    @Value("${admin.user}")
    private String client;

    @Value("${admin.password}")
    private String password;

    @Override
    public void configure(ClientDetailsServiceConfigurer config) throws Exception {
        config.inMemory()
        .withClient(client)
        .secret(encoder.encode(password))
        .scopes("read", "write", "trust")
        .authorizedGrantTypes("client_credentials")
        .accessTokenValiditySeconds(400 * 800 * 900)
        .refreshTokenValiditySeconds(800 * 1600 * 1800)
        .resourceIds("healthApp#36");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer config) throws Exception {
        config.tokenStore(tokenStore)
        .authenticationManager(authManager);
    }
}