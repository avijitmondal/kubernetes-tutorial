package com.avijitmondal.tutorial.k8s.model;

public class Details {
    private String port;
    private String hostname;
    private String ip;

    public Details() {

    }

    public Details(String port, String hostname, String ip) {
        this.port = port;
        this.hostname = hostname;
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public String getHostname() {
        return hostname;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Details{" +
                "Hostname=" + hostname +
                ", Ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
