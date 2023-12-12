package com.projects.ruleengine.model;

import com.projects.ruleengine.dto.RuleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "RULE")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "RULE")
    @Column(name = "RULE_ID")
    private Long ruleId;

    @Column(name = "RULE_NAME")
    private String ruleName;

    @Column(name = "CONDITIONS")
    private String conditions;

    @Column(name = "ACTION")
    private String action;

    public RuleDto toDto(){
        RuleDto ruleDto = new RuleDto();
        ruleDto.setRuleId(this.ruleId);
        ruleDto.setRuleName(this.ruleName);
        ruleDto.setConditions(this.conditions);
        ruleDto.setAction(this.action);
        return ruleDto;
    }

}
