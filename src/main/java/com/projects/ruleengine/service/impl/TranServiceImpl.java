package com.projects.ruleengine.service.impl;

import com.projects.ruleengine.dto.TranReqDto;
import com.projects.ruleengine.dto.TranResDto;
import com.projects.ruleengine.service.TranService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TranServiceImpl implements TranService {

    private final KieContainer kieContainer;

    public TranServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    @Override
    public ResponseEntity<TranResDto> executeRules(TranReqDto tranReqDto) {
        try {

            TranResDto tranResDto = new TranResDto();
            KieSession kieSession = kieContainer.newKieSession();
            kieSession.insert(tranResDto);
            kieSession.insert(tranReqDto);
            kieSession.setGlobal("response", tranResDto);
            kieSession.fireAllRules();
            kieSession.dispose();
            return ResponseEntity.ok(tranResDto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
