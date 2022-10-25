package mao.ipspringbootstarter.config;

import mao.ipspringbootstarter.interceptor.IpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Project name(项目名称)：spring_boot_starter_demo3
 * Package(包名): mao.ipspringbootstarter.config
 * Class(类名): SpringMvcConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/25
 * Time(创建时间)： 14:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer
{
    @Bean
    public IpInterceptor ipInterceptor()
    {
        return new IpInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //proxyBeanMethods默认为true，不是直接new，是从容器里拿
        registry.addInterceptor(ipInterceptor()).excludePathPatterns("/error");
    }


}
