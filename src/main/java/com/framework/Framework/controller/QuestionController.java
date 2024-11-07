package com.framework.Framework.controller;

import com.framework.Framework.service.ICommonService;
import com.framework.Framework.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private ICommonService commonService;

    @PostMapping("saveQuestion")
    public ResponseEntity<QuestionVO> saveQuestion(@RequestBody QuestionVO questionVO) {
        return commonService.saveQuestion(questionVO);
    }

}
