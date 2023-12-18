package com.projects.ruleengine.rest;

import com.projects.ruleengine.dto.TranReqDto;
import com.projects.ruleengine.dto.TranResDto;
import com.projects.ruleengine.service.TranService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tran")
public class TranController {

    private final TranService tranService;

    public TranController(TranService tranService) {
        this.tranService = tranService;
    }

    @PostMapping("/executeRules")
    public ResponseEntity<TranResDto> executeRules(@RequestBody TranReqDto tranReqDto){
        return tranService.executeRules(tranReqDto);
    }

}
