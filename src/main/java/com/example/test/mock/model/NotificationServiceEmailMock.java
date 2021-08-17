package com.example.test.mock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class NotificationServiceEmailMock {
    private String managerEmail;
    private String message;
}
