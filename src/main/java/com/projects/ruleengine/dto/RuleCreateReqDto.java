package com.projects.ruleengine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RuleCreateReqDto {
    @NotNull
    @NotEmpty
    private String ruleName;
    @NotNull
    @NotEmpty
    private String conditions;
    @NotNull
    @NotEmpty
    private String action;
}
