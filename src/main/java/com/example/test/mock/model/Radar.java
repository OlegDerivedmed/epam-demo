package com.example.test.mock.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Radar {

    private String id;
    private String candidateId;
    private boolean isPreselected;
}
