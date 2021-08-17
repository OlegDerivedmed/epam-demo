package com.example.test.mock;


import com.example.test.mock.model.Radar;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RadarMock {

    private Map<String, Radar> repository = Map.of("AI5590KX", new Radar("lohg1d", "AI5590KX", false),
            "anotherSamurai", new Radar("2ndHero", "anotherSamurai", true));

    public JSONObject getMockDataFromRadarByCandidateId(String candidateId) {
        return new JSONObject(repository.get(candidateId));
    }
}
