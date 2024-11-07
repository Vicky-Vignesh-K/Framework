package com.framework.Framework.service;

import com.framework.Framework.vo.DomainVO;
import com.framework.Framework.vo.QuestionVO;
import com.framework.Framework.vo.RatingVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICommonService {

     ResponseEntity<QuestionVO> saveQuestion(QuestionVO questionVO);

     ResponseEntity<DomainVO> saveDomain(DomainVO domainVO);

     ResponseEntity<RatingVO> saveRating(RatingVO ratingVO);

}
