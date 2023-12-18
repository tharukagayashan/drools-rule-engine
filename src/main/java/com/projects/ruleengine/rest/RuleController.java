package com.projects.ruleengine.rest;

import com.projects.ruleengine.dto.RuleCreateReqDto;
import com.projects.ruleengine.dto.RuleDto;
import com.projects.ruleengine.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rule")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public ResponseEntity<RuleDto> addRule(@RequestBody RuleCreateReqDto ruleCreateReqDto){
        return ruleService.addRule(ruleCreateReqDto);
    }

    @GetMapping
    public ResponseEntity<List<RuleDto>> getAllRules(){
        return ruleService.getAllRules();
    }

    @DeleteMapping("/{ruleId}")
    public ResponseEntity<String> deleteRule(@PathVariable Long ruleId){
        return ruleService.deleteRule(ruleId);
    }

}
