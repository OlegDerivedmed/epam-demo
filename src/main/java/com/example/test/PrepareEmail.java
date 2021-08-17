package com.example.test;

import com.example.test.util.Constants;
import com.example.test.util.JsonObjectUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class PrepareEmail implements JavaDelegate {
    private String email;
    private String message;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var interviewBody = new JSONObject((String) delegateExecution.getVariable(Constants.INTERVIEW_BODY));
        var dataHubBody = JsonObjectUtils.getNestedJsonObjByPropName(interviewBody, Constants.DATA_HUB_BODY);
        prepareEmail(dataHubBody);
        prepareMessage(dataHubBody, interviewBody);
        delegateExecution.setVariable("email", email);
        delegateExecution.setVariable("emailMessage", message);
    }

    private void prepareEmail(JSONObject dataHubBody) {
        this.email = dataHubBody.get("email").toString();
    }
    private void prepareMessage(JSONObject dataHubBody, JSONObject interviewBody) {
        this.message = String.format("Hello, %s! Interview %s was finished successfully! Candidate ready to work!", dataHubBody.get("name"),
                interviewBody.get("interviewId"));
    }
}
