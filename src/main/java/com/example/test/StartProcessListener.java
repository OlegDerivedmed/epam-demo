package com.example.test;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartProcessListener implements ExecutionListener {

    @Autowired
    private List<String> memCache;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        memCache.add((String) delegateExecution.getVariable("topicId"));
    }
}
