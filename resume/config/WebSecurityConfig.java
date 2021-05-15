package com.sedia.resume.config;

import com.sedia.resume.security.CustomAuthenticationProvider;
import com.sedia.resume.security.JWTAuthenticationFilter;
import com.sedia.resume.security.LoginFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] allowPass = { "/", "/login", "/actuator/**", "/test/**", "/v3/api-docs/**", "/swagger-ui/**",
                "/swagger-ui.html" };
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
                .authorizeRequests().antMatchers(POST, "/user").permitAll().and().authorizeRequests()
                .antMatchers(allowPass).permitAll().and().authorizeRequests().anyRequest().authenticated().and()
                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)// 添加過濾器，針對/login的請求，交給LoginFilter處理
                // 添加過濾器，針對其他請求進行JWT的驗證
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class).headers()
                .frameOptions().disable().and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
