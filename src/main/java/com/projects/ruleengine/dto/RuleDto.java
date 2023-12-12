package com.projects.ruleengine.dto;

import com.projects.ruleengine.model.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RuleDto {

    private Long ruleId;
    private String ruleName;
    private String conditions;
    private String action;

    public Rule toEntity(){
        Rule rule = new Rule();
        rule.setRuleId(this.ruleId);
        rule.setRuleName(this.ruleName);
        rule.setConditions(this.conditions);
        rule.setAction(this.action);
        return rule;
    }
}
