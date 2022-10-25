package mao.ipspringbootstarter.service;

import mao.ipspringbootstarter.config.IpConfigurationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

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
    private IpConfigurationProperties ipConfigurationProperties;

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


    /**
     * 定时打印一个表格
     */
    @Scheduled(cron = "0/#{ipConfigurationProperties.cycle} * * * * ?")
    public void print()
    {

        //模式切换
        if (ipConfigurationProperties.getMode().equals(IpConfigurationProperties.LogModel.DETAIL.getValue()))
        {
            //明细模式
            detailPrint();
        }
        else if (ipConfigurationProperties.getMode().equals(IpConfigurationProperties.LogModel.SIMPLE.getValue()))
        {
            //极简模式
            simplePrint();
        }

        //周期内重置数据
        if (ipConfigurationProperties.getCycleReset())
        {
            ipCountMap.clear();
        }
    }


    /**
     * 更详细的输出
     */
    private void detailPrint()
    {
        StringBuilder stringBuilder = new StringBuilder(" IP访问监控\n");
        stringBuilder.append("+-----ip-address-----+--num--+\n");

        for (Map.Entry<String, Integer> info : ipCountMap.entrySet())
        {
            String key = info.getKey();
            Integer count = info.getValue();
            String lineInfo = String.format("|%18s |%6d |", key, count);
            stringBuilder.append(lineInfo).append("\n");
        }
        stringBuilder.append("+--------------------+-------+");
        log.info(stringBuilder.toString());
    }


    /**
     * 简单的输出
     */
    private void simplePrint()
    {
        StringBuilder stringBuilder = new StringBuilder(" IP访问监控\n");
        stringBuilder.append("+-----ip-address--------+\n");

        for (Map.Entry<String, Integer> info : ipCountMap.entrySet())
        {
            String key = info.getKey();
            String lineInfo = String.format("|%18s   |", key);
            stringBuilder.append(lineInfo).append("\n");
        }
        stringBuilder.append("+--------------------+-------+");
        log.info(stringBuilder.toString());
    }


}
