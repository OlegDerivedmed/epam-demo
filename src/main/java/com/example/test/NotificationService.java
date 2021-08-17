package com.example.test;

import com.example.test.mock.model.NotificationServiceEmailMock;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var email = delegateExecution.getVariable("email");
        var message = delegateExecution.getVariable("message");
        log.info("Message to be send to notification service: " + new NotificationServiceEmailMock((String) email, (String) message));

    }
}
