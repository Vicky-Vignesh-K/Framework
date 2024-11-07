package com.framework.Framework.business;

import com.framework.Framework.vo.DomainVO;
import com.framework.Framework.vo.QuestionVO;
import com.framework.Framework.vo.RatingVO;

public interface ICommonBO {

     QuestionVO saveQuestion(QuestionVO questionVO);

     DomainVO saveDomain(DomainVO domainVO);

     RatingVO saveRating(RatingVO ratingVO);

}
