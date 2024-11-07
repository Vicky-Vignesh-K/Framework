package com.framework.Framework.controller;

import com.framework.Framework.entity.Framework;
import com.framework.Framework.service.IFrameworkService;
import com.framework.Framework.vo.FrameworkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("framework")
public class FrameworkController {
    @Autowired
    private IFrameworkService frameworkService;

    @PostMapping("saveFramework")
    public ResponseEntity<FrameworkVO> saveFramework(@RequestBody FrameworkVO frameworkVO) {
        return frameworkService.saveFramework(frameworkVO);
    }

    @PostMapping("findFrameworkData")
    public ResponseEntity<FrameworkVO> findFrameworkData(@RequestBody FrameworkVO frameworkVO){
        return frameworkService.findFrameworkData(frameworkVO);
    }

}
