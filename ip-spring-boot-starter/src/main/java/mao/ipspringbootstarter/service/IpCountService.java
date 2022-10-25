package mao.ipspringbootstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Project name(项目名称)：spring_boot_starter_demo3
 * Package(包名): mao.ipspringbootstarter.service
 * Class(类名): IpCountService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/25
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class IpCountService
{
    private final Map<String, Integer> ipCountMap = new ConcurrentHashMap<>();

    private static final Logger log = LoggerFactory.getLogger(IpCountService.class);

    @Autowired
    private HttpServletRequest request;

    /**
     * 记录某个IP访问该网站的次数
     */
    public void count()
    {
        String ipAddress = request.getRemoteAddr();
        if (ipCountMap.containsKey(ipAddress))
        {
            synchronized (ipAddress.intern())
            {
                ipCountMap.put(ipAddress, ipCountMap.get(ipAddress) + 1);
            }
        }
        else
        {
            ipCountMap.put(ipAddress, 1);
        }
        log.debug("IP:" + ipAddress);
    }
}
