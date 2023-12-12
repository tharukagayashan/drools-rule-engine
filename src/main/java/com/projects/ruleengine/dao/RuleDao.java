package com.projects.ruleengine.dao;

import com.projects.ruleengine.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleDao extends JpaRepository<Rule, Long> {
}
