package com.joshua.kafka.consumer.high;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/8/2.
 */
public class JavaKafkaConsumerHighAPITest {

    @Test
    public void kafkaConsumerHighAPITest(){
        String zookeeper = "10.1.198.60:2181";
        String groupId = "group1";
        String topic = "test_sdc";
        int threads = 1;

        JavaKafkaConsumerHighAPI example = new JavaKafkaConsumerHighAPI(topic, threads, zookeeper, groupId);
        new Thread(example).start();

        example.run();
//        System.out.println(example.toString());
        // 执行10秒后结束
        int sleepMillis = 600;
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭
        example.shutdown();
    }
}