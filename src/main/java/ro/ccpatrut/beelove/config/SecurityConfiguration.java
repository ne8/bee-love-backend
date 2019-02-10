package ro.ccpatrut.beelove.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@EnableResourceServer
@Configuration
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;

    // JDBC token store configuration


    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.tokenServices(this.tokenServices());
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(this.tokenStore());
        return defaultTokenServices;
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(HttpMethod.GET, "/slider").access("permitAll()")
                .antMatchers(HttpMethod.GET, "/banner").access("permitAll()")
                .antMatchers(HttpMethod.GET, "/about").access("permitAll()")
                .antMatchers(HttpMethod.GET, "/products").access("permitAll()")
                .antMatchers(HttpMethod.GET, "/posts").access("permitAll()")
                .antMatchers(HttpMethod.POST, "/checkout").access("permitAll()")
                .antMatchers(HttpMethod.GET, "/orders").access("permitAll()");
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(this.dataSource());
    }

    private DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(this.env.getProperty("spring.datasource.oauth2.url"));
        dataSource.setUsername(this.env.getProperty("spring.datasource.oauth2.username"));
        dataSource.setPassword(this.env.getProperty("spring.datasource.oauth2.password"));
        dataSource.setDriverClassName(this.env.getProperty("spring.datasource.driver-class-name"));

        return dataSource;
    }
}
