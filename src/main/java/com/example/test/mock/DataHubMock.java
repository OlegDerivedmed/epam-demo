package com.example.test.mock;

import com.example.test.mock.model.DataHub;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class DataHubMock {

    public JSONObject getDirectionManagerByPrimarySkill(String primarySkill) {
        return new JSONObject(new DataHub("1", "Roman", "roman.cmanager@epam.com"));
    }
}
