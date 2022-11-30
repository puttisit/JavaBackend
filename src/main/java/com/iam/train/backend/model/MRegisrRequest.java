package com.iam.train.backend.model;

import lombok.Data;

@Data
public class MRegisrRequest {
    private String email;
    private String password;
    private String name;
}
