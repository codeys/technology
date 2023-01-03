package com.technical.terchnicalsummary.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogEntity {

    private String operator;

    private String operatorTime;

    private String operatorContent;
}
