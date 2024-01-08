package com.projects.ruleengine;

import com.projects.ruleengine.config.DroolsConfig;
import com.projects.ruleengine.dao.RuleDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class RuleEngineApplication {

	private static RuleDao ruleDao;

	public RuleEngineApplication(RuleDao ruleDao) {
		this.ruleDao = ruleDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(RuleEngineApplication.class, args);

//		DroolsConfig customMethods = new DroolsConfig();
//
//		customMethods.writeRulesToDrlFile(ruleDao);

	}

}
