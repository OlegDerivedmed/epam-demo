package com.example.test;

import com.example.test.mock.RadarMock;
import com.example.test.util.Constants;
import com.example.test.util.KafkaUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchDataFromRadar implements JavaDelegate {

    @Autowired
    private RadarMock radarMock;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var jsonObject = new JSONObject(KafkaUtils.getKafkaBodyParamName(delegateExecution));
        var radarData = radarMock.getMockDataFromRadarByCandidateId((String) jsonObject.get("candidateId"));
        jsonObject.put(Constants.RADAR_BODY, radarData.toString());
        delegateExecution.setVariable(Constants.INTERVIEW_BODY, jsonObject.toString());
        delegateExecution.setVariable("isPreselected", radarData.get("preselected"));
    }
}
