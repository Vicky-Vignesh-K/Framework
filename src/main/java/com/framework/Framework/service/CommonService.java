package com.framework.Framework.service;

import com.framework.Framework.business.CommonBO;
import com.framework.Framework.vo.DomainVO;
import com.framework.Framework.vo.QuestionVO;
import com.framework.Framework.vo.RatingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class CommonService implements ICommonService {

    @Autowired
    private CommonBO commonBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<QuestionVO> saveQuestion(QuestionVO questionVO) {
        QuestionVO savedQuestion = commonBO.saveQuestion(questionVO);
        if (savedQuestion != null) {
            savedQuestion.setMessage("Question Saved Successfully");
            savedQuestion.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
        }
        questionVO.setMessage("Error in Saving Question");
        questionVO.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(questionVO, HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<DomainVO> saveDomain(DomainVO domainVO) {
        DomainVO savedDomain = commonBO.saveDomain(domainVO);
        if (savedDomain != null) {
            savedDomain.setMessage("Domain Data Saved Successfully");
            savedDomain.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(savedDomain, HttpStatus.CREATED);
        }
        domainVO.setMessage("Error in saving Domain Data");
        domainVO.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(domainVO, HttpStatus.NOT_FOUND);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<RatingVO> saveRating(RatingVO ratingVO) {
        RatingVO savedRating = commonBO.saveRating(ratingVO);
        if (savedRating != null) {
            savedRating.setMessage("Rating Saved Successfully");
            savedRating.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<RatingVO>(savedRating, HttpStatus.CREATED);
        }
        ratingVO.setMessage("Error in Saving Rating");
        ratingVO.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(ratingVO, HttpStatus.NOT_FOUND);
    }

}
