package com.projects.ruleengine.service;

import com.projects.ruleengine.dto.TranReqDto;
import com.projects.ruleengine.dto.TranResDto;
import org.springframework.http.ResponseEntity;

public interface TranService {
    ResponseEntity<TranResDto> executeRules(TranReqDto tranReqDto);
}
