package mao.ipspringbootstarter.config;

import mao.ipspringbootstarter.service.IpCountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Project name(项目名称)：spring_boot_starter_demo3
 * Package(包名): mao.ipspringbootstarter.config
 * Class(类名): IpAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/25
 * Time(创建时间)： 13:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EnableScheduling
@Configuration
@EnableConfigurationProperties(IpConfigurationProperties.class)
public class IpAutoConfiguration
{
    @Bean
    @ConditionalOnMissingBean
    public IpCountService ipCountService()
    {
        return new IpCountService();
    }
}
