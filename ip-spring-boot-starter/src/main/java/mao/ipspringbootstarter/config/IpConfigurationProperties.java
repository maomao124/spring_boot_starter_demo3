package mao.ipspringbootstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Project name(项目名称)：spring_boot_starter_demo3
 * Package(包名): mao.ipspringbootstarter.config
 * Class(类名): IpConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/25
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@ConfigurationProperties(prefix = "tools.ip")
public class IpConfigurationProperties
{

    /**
     * 日志显示周期
     */
    private long cycle = 10L;


    /**
     * 是否周期内重置数据
     */
    private Boolean cycleReset = false;


    /**
     * 日志输出模式 detail:明细模式 simple:极简模式
     */
    private String mode = LogModel.DETAIL.value;


    /**
     * The enum Log model.
     */
    public enum LogModel
    {
        /**
         * Detail log model.
         */
        DETAIL("detail"),
        /**
         * Simple log model.
         */
        SIMPLE("simple");

        private String value;

        LogModel(String value)
        {
            this.value = value;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public String getValue()
        {
            return value;
        }
    }


    /**
     * Instantiates a new Ip configuration properties.
     */
    public IpConfigurationProperties()
    {

    }

    /**
     * Instantiates a new Ip configuration properties.
     *
     * @param cycle      the cycle
     * @param cycleReset the cycle reset
     * @param mode       the mode
     */
    public IpConfigurationProperties(long cycle, Boolean cycleReset, String mode)
    {
        this.cycle = cycle;
        this.cycleReset = cycleReset;
        this.mode = mode;
    }

    /**
     * Gets cycle.
     *
     * @return the cycle
     */
    public long getCycle()
    {
        return cycle;
    }

    /**
     * Sets cycle.
     *
     * @param cycle the cycle
     */
    public void setCycle(long cycle)
    {
        this.cycle = cycle;
    }

    /**
     * Gets cycle reset.
     *
     * @return the cycle reset
     */
    public Boolean getCycleReset()
    {
        return cycleReset;
    }

    /**
     * Sets cycle reset.
     *
     * @param cycleReset the cycle reset
     */
    public void setCycleReset(Boolean cycleReset)
    {
        this.cycleReset = cycleReset;
    }

    /**
     * Gets mode.
     *
     * @return the mode
     */
    public String getMode()
    {
        return mode;
    }

    /**
     * Sets mode.
     *
     * @param mode the mode
     */
    public void setMode(String mode)
    {
        this.mode = mode;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("cycle：").append(cycle).append('\n');
        stringbuilder.append("cycleReset：").append(cycleReset).append('\n');
        stringbuilder.append("mode：").append(mode).append('\n');
        return stringbuilder.toString();
    }
}
