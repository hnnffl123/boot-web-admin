package com.sgg.admin.config;

import com.sgg.admin.interceptor.LoginLnterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huangruiqing
 * @Description
 * @date 2022-10-09 17:21
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginLnterceptor())
                .addPathPatterns("/**")//静态资源被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**",
                        "/js/**","/druid/**");//放行的请求
    }
}
