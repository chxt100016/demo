package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity()
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
//        http.authorizeRequests().anyRequest().authenticated().and()
//                .formLogin().loginPage("/login1.html").loginProcessingUrl("/login")
//                .failureHandler(new MyFailureHandler())
//                .defaultSuccessUrl("/loginSuccess.html").permitAll()
//                .authenticationDetailsSource(new CaptchaAuthenticationDetailsSource())
//                .and().logout().logoutUrl("/myLogout").invalidateHttpSession(true).deleteCookies("cookie1", "cookie2")
//                .and().sessionManagement().invalidSessionUrl("/session/invalid")
//                .and().rememberMe().userDetailsService(this.userService).key("55555")// TODO
//               // .and().exceptionHandling().authenticationEntryPoint(new MyAuthenticationEntryPoint())
////                .and().addFilterAt(this.myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .and().csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/back")
                .antMatchers("/captcha.jpg");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(this.passwordEncoder())
        .and().authenticationProvider(this.userAuthenticationProvider());
    }

//    @Bean
//    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
//        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
////        filter.setAuthenticationSuccessHandler(new SuccessHandler());
////        filter.setAuthenticationFailureHandler(new FailureHandler());
//        filter.setFilterProcessesUrl("/login");
//
//        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
//        filter.setAuthenticationManager(authenticationManagerBean());
//        return filter;
//    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserAuthenticationProvider userAuthenticationProvider(){
        return new UserAuthenticationProvider();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
