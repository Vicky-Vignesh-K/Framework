package com.framework.Framework.controller;

import com.framework.Framework.service.ICommonService;
import com.framework.Framework.vo.DomainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domain")
public class DomainController {

    @Autowired
    private ICommonService commonService;

    @PostMapping("saveDomain")
    public ResponseEntity<DomainVO> saveDomain(@RequestBody DomainVO domainVO) {
        return commonService.saveDomain(domainVO);
    }

}
