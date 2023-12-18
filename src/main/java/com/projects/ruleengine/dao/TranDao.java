package com.projects.ruleengine.dao;

import com.projects.ruleengine.model.Tran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranDao extends JpaRepository<Tran, Long> {
}
