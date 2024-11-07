package com.framework.Framework.controller;

import com.framework.Framework.service.ICommonService;
import com.framework.Framework.vo.RatingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    private ICommonService commonService;

    @PostMapping("saveRating")
    public ResponseEntity<RatingVO> saveRating(@RequestBody RatingVO ratingVO) {
        return commonService.saveRating(ratingVO);
    }

}
