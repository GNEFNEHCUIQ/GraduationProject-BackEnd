package com.sise.makerSpace.config;

import com.sise.makerSpace.config.component.JwtAuthenticationTokenFilter;
import com.sise.makerSpace.config.component.RestAuthorizationEntryPoint;
import com.sise.makerSpace.config.component.RestfulAccessDeniedHandler;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    /*@Autowired
    private CustomFilter customFilter;

    @Autowired
    private CustomUrlDecisionManager customUrlDecisionManager;*/

    @Override//身份验证管理生成器
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //重写这个方法是因为，让登录的时候请求走自己重写的登录方法 UserDetailsService userDetailsService()
        //userDetailsService() 获取了用户名
        //asswordEncoder(passwordEncoder())密码匹配是通过BCryptPasswordEncoder加密来完成的
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//        auth.userDetailsService(userDetailsService()).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                //放行的资源路径
                "/login",
                "/logout",
                "/css/**",
                "/js/**",
                "/index.html",
                "favicon.ico",
                "/doc.html",
                "/captcha",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/ws/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .cacheControl();

        http.addFilterBefore(jwtAuthenticationTokenFilter(),UsernamePasswordAuthenticationFilter.class);
        //添加自定义 未授权 和 未登录 结果返回
        http.exceptionHandling()
                //自定义 未授权
                .accessDeniedHandler(restfulAccessDeniedHandler)
                //自定义 未登录结果返回
                .authenticationEntryPoint(restAuthorizationEntryPoint);
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return  username ->{
            User user=userService.getUserByUserName(username);
            if(null!=user){
                return user;
            }
            throw new UsernameNotFoundException("用户名或密码不正确！");
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        //Security中默认的密码实现  BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }

    //拦截器
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }
}
