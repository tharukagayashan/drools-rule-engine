package com.projects.ruleengine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TranReqDto {
    private String tranType;
    private Float tranAmount;
}
