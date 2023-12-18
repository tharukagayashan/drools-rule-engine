package com.projects.ruleengine.service;

import com.projects.ruleengine.dto.RuleCreateReqDto;
import com.projects.ruleengine.dto.RuleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RuleService {
    ResponseEntity<RuleDto> addRule(RuleCreateReqDto ruleCreateReqDto);

    ResponseEntity<List<RuleDto>> getAllRules();

    ResponseEntity<String> deleteRule(Long ruleId);

}
