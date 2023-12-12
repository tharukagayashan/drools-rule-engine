package com.projects.ruleengine.service.impl;

import com.projects.ruleengine.dao.RuleDao;
import com.projects.ruleengine.dto.RuleCreateReqDto;
import com.projects.ruleengine.dto.RuleDto;
import com.projects.ruleengine.model.Rule;
import com.projects.ruleengine.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final RuleDao ruleDao;

    public RuleServiceImpl(RuleDao ruleDao) {
        this.ruleDao = ruleDao;
    }

    @Override
    public ResponseEntity<RuleDto> addRule(RuleCreateReqDto ruleCreateReqDto) {
        try {

            Rule rule = new Rule();
            rule.setRuleName(ruleCreateReqDto.getRuleName());
            rule.setConditions(ruleCreateReqDto.getConditions());
            rule.setAction(ruleCreateReqDto.getAction());

            rule = ruleDao.save(rule);
            if (rule.getRuleId() == null) {
                throw new RuntimeException("Rule not saved");
            } else {
                return ResponseEntity.ok(rule.toDto());
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<RuleDto>> getAllRules() {
        try {
            List<Rule> ruleList = ruleDao.findAll();
            if (ruleList.isEmpty()) {
                throw new RuntimeException("No rules found");
            } else {
                List<RuleDto> ruleDtoList = new ArrayList<>();
                for (Rule r : ruleList) {
                    ruleDtoList.add(r.toDto());
                }
                return ResponseEntity.ok(ruleDtoList);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
