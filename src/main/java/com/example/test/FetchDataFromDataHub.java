package com.example.test;

import com.example.test.mock.DataHubMock;
import com.example.test.util.Constants;
import com.example.test.util.KafkaUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchDataFromDataHub implements JavaDelegate {
    @Autowired
    private DataHubMock dataHubMock;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var jsonObject = new JSONObject(KafkaUtils.getKafkaBodyParamName(delegateExecution));
        String primarySkill = jsonObject.get("primarySkill").toString();
        jsonObject.put(Constants.DATA_HUB_BODY, dataHubMock.getDirectionManagerByPrimarySkill(primarySkill));
        delegateExecution.setVariable(Constants.INTERVIEW_BODY, jsonObject.toString());
    }
}
