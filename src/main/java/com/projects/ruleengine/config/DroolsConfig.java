package com.projects.ruleengine.config;

import com.projects.ruleengine.dao.RuleDao;
import com.projects.ruleengine.model.Rule;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintWriter;
import java.util.List;

@Configuration
public class DroolsConfig {

    private String RULES_DRL = "rules.drl";

    private final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_DRL));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    public String writeRulesToDrlFile(RuleDao ruleDao) {
        List<Rule> ruleList = ruleDao.findAll();

        StringBuilder drl = new StringBuilder();

        StringBuilder ruleStr = new StringBuilder();
        for (Rule rule : ruleList) {
            ruleStr.append("rule \"").append(rule.getRuleName()).append("\"\n")
                    .append("   when\n")
                    .append("      TranReqDto(").append(rule.getConditions()).append(")\n")
                    .append("   then\n")
                    .append("      response.setMessage(\"").append(rule.getAction()).append("\");\n")
                    .append("end;\n\n");
        }

        drl.append("import com.projects.ruleengine.dto.TranReqDto;\n")
                .append("global com.projects.ruleengine.dto.TranResDto response;\n\n")
                .append("dialect \"mvel\"\n\n")
                .append(ruleStr);

        System.out.println(drl);

        try {
            PrintWriter writer = new PrintWriter(RULES_DRL);
            writer.write(drl.toString());
            System.out.println("Write to file: " + RULES_DRL);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return drl.toString();
    }

}