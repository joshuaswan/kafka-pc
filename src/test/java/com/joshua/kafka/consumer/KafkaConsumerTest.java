package com.joshua.kafka.consumer;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/8/3.
 */
public class KafkaConsumerTest {
    @Test
    public void consume() throws Exception {
        ConsumerConnector consumer;
        Properties props = new Properties();
        //zookeeper 配置
        props.put("zookeeper.connect", "10.1.198.60:2181");

        //group 代表一个消费组
        props.put("group.id", "jd-group");

        //zk连接超时
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        //序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");

        ConsumerConfig config = new ConsumerConfig(props);

        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        //topicCountMap.put(KafkaProducer.TOPIC, new Integer(1));

        topicCountMap.put("MODEL_TYPETopicd149cc0b-a689-4e96-ac65-6b03a7e532c2", new Integer(1));
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

        Map<String, List<KafkaStream<String, String>>> consumerMap =
                consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get("MODEL_TYPETopicd149cc0b-a689-4e96-ac65-6b03a7e532c2").get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next().message());
        }
        consumer.shutdown();
        System.out.println("finish");
    }

}