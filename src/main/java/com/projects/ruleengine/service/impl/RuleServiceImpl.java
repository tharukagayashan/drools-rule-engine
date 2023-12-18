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
import java.util.Optional;

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

    @Override
    public ResponseEntity<String> deleteRule(Long ruleId) {
        try {
            if (ruleId == null) {
                throw new RuntimeException("Rule Id is null");
            } else {
                Optional<Rule> rule = ruleDao.findById(ruleId);
                if (rule.isPresent()) {
                    ruleDao.delete(rule.get());
                    Optional<Rule> rule1 = ruleDao.findById(ruleId);
                    if (rule1.isPresent()) {
                        throw new RuntimeException("Rule not deleted");
                    } else {
                        return ResponseEntity.ok("Rule deleted successfully");
                    }
                } else {
                    throw new RuntimeException("Rule not found");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}