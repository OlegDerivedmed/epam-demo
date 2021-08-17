package com.example.test.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaTopicListener {

    @Autowired
    private List<String> memCache;


    @Autowired
    private ProcessEngine camunda;

    @KafkaListener(topicPattern = ".*", groupId = "epam-demo-app")
    public void listenInterviewFinishedTopic(ConsumerRecord<String, String> message) {
        String topic = message.topic();
        if (memCache.contains(topic)) {
            String kafkaTopicBody = topic + "Body";
            camunda.getRuntimeService().createMessageCorrelation(topic)
                    .setVariable(kafkaTopicBody, message.value())
                    .setVariable("kafkaTopicBodyName", kafkaTopicBody)
                    .correlate();
        }

    }
}
