package com.example.test.util;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class KafkaUtils {

    public static String getKafkaBodyParamName(DelegateExecution execution) {
        var kafkaBodyName = execution.getVariable("kafkaTopicBodyName").toString();
        return execution.getVariable(kafkaBodyName).toString();
    }
}
