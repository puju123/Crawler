package com.pujun.webcrawler.entity;

public class ProxyKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column proxy.ip
     *
     * @mbg.generated Sun Apr 16 17:07:34 CST 2017
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column proxy.port
     *
     * @mbg.generated Sun Apr 16 17:07:34 CST 2017
     */
    private Integer port;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column proxy.ip
     *
     * @return the value of proxy.ip
     *
     * @mbg.generated Sun Apr 16 17:07:34 CST 2017
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column proxy.ip
     *
     * @param ip the value for proxy.ip
     *
     * @mbg.generated Sun Apr 16 17:07:34 CST 2017
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column proxy.port
     *
     * @return the value of proxy.port
     *
     * @mbg.generated Sun Apr 16 17:07:34 CST 2017
     */
    public Integer getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column proxy.port
     *
     * @param port the value for proxy.port
     *
     * @mbg.generated Sun Apr 16 17:07:34 CST 2017
     */
    public void setPort(Integer port) {
        this.port = port;
    }
}