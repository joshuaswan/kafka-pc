package com.joshua.kafka.consumer.lower;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua on 2017/8/1.
 */
public class JavaKafkaSimpleConsumerAPITest {
    @Test
    public void consumerAPITest(){
        JavaKafkaSimpleConsumerAPI example = new JavaKafkaSimpleConsumerAPI();
        long maxReads = 300;
        String topic = "test_sdc";
        int partitionID = 0;

        KafkaTopicPartitionInfo topicPartitionInfo = new KafkaTopicPartitionInfo(topic, partitionID);
        List<KafkaBrokerInfo> seeds = new ArrayList<KafkaBrokerInfo>();
        seeds.add(new KafkaBrokerInfo("10.1.198.60", 9092));

        try {
            example.run(maxReads, topicPartitionInfo, seeds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取该topic所属的所有分区ID列表
        System.out.println(example.fetchTopicPartitionIDs(seeds, topic, 100000, 64 * 1024, "client-id"));
    }

}