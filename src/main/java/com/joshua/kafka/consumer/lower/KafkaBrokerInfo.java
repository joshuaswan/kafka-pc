package com.joshua.kafka.consumer.lower;

/**
 * Kafka服务器连接参数
 * Created by joshua on 2017/8/1.
 */
public class KafkaBrokerInfo {
    //host
    public final String brokerHost;
    //port
    public final int brokerPort;

    public KafkaBrokerInfo(String brokerHost, int brokerPort) {
        this.brokerHost = brokerHost;
        this.brokerPort = brokerPort;
    }

    public KafkaBrokerInfo(String brokerHost) {
        this(brokerHost,9092);
    }

    public KafkaBrokerInfo(){
        this("127.0.0.1",9092);
    }
}
