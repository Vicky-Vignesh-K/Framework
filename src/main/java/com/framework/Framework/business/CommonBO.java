package com.framework.Framework.business;

import com.framework.Framework.config.Status;
import com.framework.Framework.entity.Domain;
import com.framework.Framework.entity.Question;
import com.framework.Framework.entity.Rating;
import com.framework.Framework.repository.IDomainRepository;
import com.framework.Framework.repository.IQuestionRepository;
import com.framework.Framework.repository.IRatingRepository;
import com.framework.Framework.vo.DomainVO;
import com.framework.Framework.vo.QuestionVO;
import com.framework.Framework.vo.RatingVO;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonBO implements ICommonBO {

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private IDomainRepository domainRepository;

    @Autowired
    private IRatingRepository ratingRepository;

    @Override
    public QuestionVO saveQuestion(QuestionVO questionVO) {
        if (questionVO != null && validate(questionVO)) {
            Question savedQuestion = questionRepository.save(setQuestionVOToQuestion(questionVO));
            if (savedQuestion != null) {
                return questionVO;
            }
        }
        return null;
    }

    @Override
    public DomainVO saveDomain(DomainVO domainVO) {
        if (domainVO != null && validate(domainVO)) {
            Domain savedDomain = domainRepository.save(setDomainVOToDomain(domainVO));
            if (savedDomain != null)
                return domainVO;
        }
        return null;
    }

    @Override
    public RatingVO saveRating(RatingVO ratingVO) {
        if (ratingVO != null && validate(ratingVO)) {
            Rating savedRating = ratingRepository.save(setRatingVOToRating(ratingVO));
            if (savedRating != null)
                return ratingVO;
        }
        return null;
    }

    private boolean validate(RatingVO ratingVO) {
        if (StringUtils.isBlank(ratingVO.getRatingName()))
            return false;
        else if (StringUtils.isBlank(ratingVO.getRatingType()))
            return false;
        else if (StringUtils.isBlank(ratingVO.getColorCode()))
            return false;
        else return true;
    }

    private boolean validate(DomainVO domainVO) {
        if (StringUtils.isBlank(domainVO.getDomainName()))
            return false;
        else if (StringUtils.isBlank(domainVO.getDomainDescription()))
            return false;
        else if (domainVO.getDomainOrder() <= 0)
            return false;
        else return true;
    }

    private boolean validate(QuestionVO questionVO) {
        if (StringUtils.isBlank(questionVO.getQuestionName()))
            return false;
        else if (StringUtils.isBlank(questionVO.getQuestionDescription()))
            return false;
        else return true;
    }

    private Question setQuestionVOToQuestion(QuestionVO questionVO) {
        Question question = new Question();
        question.setQuestionDescription(questionVO.getQuestionDescription());
        question.setQuestionName(questionVO.getQuestionName());
        if (StringUtils.isBlank(questionVO.getQuestionStatus()))
            question.setQuestionStatus(String.valueOf(Status.ACTIVE));
        else question.setQuestionStatus(questionVO.getQuestionStatus());
        return question;
    }

    private Domain setDomainVOToDomain(DomainVO domainVO) {
        Domain domain = new Domain();
        domain.setDomainName(domainVO.getDomainName());
        domain.setDomainDescription(domainVO.getDomainDescription());
        if (StringUtils.isBlank(domainVO.getDomainStatus()))
            domain.setDomainStatus(String.valueOf(Status.ACTIVE));
        else domain.setDomainStatus(domainVO.getDomainStatus());
        domain.setDomainOrder(domainVO.getDomainOrder());
        return domain;
    }

    private Rating setRatingVOToRating(RatingVO ratingVO) {
        Rating rating = new Rating();
        rating.setRatingName(ratingVO.getRatingName());
        if (StringUtils.isBlank(ratingVO.getRatingStatus()))
            rating.setRatingStatus(String.valueOf(Status.ACTIVE));
        else rating.setRatingStatus(rating.getRatingStatus());
        rating.setRatingType(ratingVO.getRatingType());
        rating.setColorCode(ratingVO.getColorCode());
        return rating;
    }
}
