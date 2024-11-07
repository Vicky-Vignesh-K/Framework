package com.framework.Framework.business;

import com.framework.Framework.config.NoDataException;
import com.framework.Framework.config.Status;
import com.framework.Framework.entity.*;
import com.framework.Framework.repository.IDomainRepository;
import com.framework.Framework.repository.IFrameworkRepository;
import com.framework.Framework.repository.IQuestionRepository;
import com.framework.Framework.repository.IRatingRepository;
import com.framework.Framework.vo.*;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class FrameworkBO implements IFrameworkBO {
    @Autowired
    private IFrameworkRepository frameworkRepository;

    @Autowired
    private IDomainRepository domainRepository;

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private IRatingRepository ratingRepository;

    @Override
    public FrameworkVO saveFramework(FrameworkVO frameworkVO) {
        try {
            if (frameworkVO != null) {
                validate(frameworkVO);
                Framework savedFramework = frameworkRepository.save(setFrameworkVOToFrameworkObj(frameworkVO));
                if (savedFramework != null) {
                    return frameworkVO;
                }
            }
        } catch (NoDataException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Framework setFrameworkVOToFrameworkObj(FrameworkVO frameworkVO) {
        Framework framework = new Framework();
        framework.setFrameworkName(frameworkVO.getFrameworkName());
        if (StringUtils.isBlank(frameworkVO.getFrameworkStatus()))
            framework.setFrameworkStatus(String.valueOf(Status.ACTIVE));
        else
            framework.setFrameworkStatus(frameworkVO.getFrameworkStatus());
        /*framework.setFrameworkVersions(*/
        setFrameworkVersionVOListToFrameworkVersion(frameworkVO, framework)/*)*/;
        return framework;
    }

    private void setFrameworkVersionVOListToFrameworkVersion(FrameworkVO frameworkVO, Framework framework) {
        frameworkVO.getFrameworkVersionVos()
                .forEach(frameworkVersionVO -> {
                    FrameworkVersion frameworkVersion = new FrameworkVersion();
                    if (StringUtils.isBlank(frameworkVersionVO.getFrameworkVersionStatus()))
                        frameworkVersion.setFrameworkVersionStatus(String.valueOf(Status.ACTIVE));
                    else frameworkVersion.setFrameworkVersionStatus(frameworkVersionVO.getFrameworkVersionStatus());
                    frameworkVersion.setExpiryDate(frameworkVersionVO.getExpiryDate());
                    /*frameworkVersion.setFrameworkDomains(*/
                    setFrameworkDomainVOListToFrameworkDomain(frameworkVersionVO, frameworkVersion)/*)*/;
                    /*frameworkVersion.setFrameworkRatings(*/
                    setFrameworkRatingVOListToFrameworkVersion(frameworkVersionVO, frameworkVersion)/*)*/;

                    framework.getFrameworkVersions().add(frameworkVersion);
                });
        /*return framework.getFrameworkVersions();*/

    }

    private void setFrameworkRatingVOListToFrameworkVersion(FrameworkVersionVO frameworkVersionVO, FrameworkVersion frameworkVersion) {

        frameworkVersionVO.getFrameworkRatings()
                .forEach(frameworkRatingVO -> {
                    try {
                        FrameworkRating frameworkRating = new FrameworkRating();
                        frameworkRating.setFrameworkRatingScore(frameworkRatingVO.getFrameworkRatingScore());
                        frameworkRating.setFrameworkVersion(frameworkVersion);
                        frameworkRating.setRating(getRatingObj(frameworkRatingVO.getRatingVO().getRatingId()));
                        frameworkVersion.getFrameworkRatings().add(frameworkRating);
                    } catch (NoDataException e) {
                        throw new RuntimeException(e);
                    }
                });
//        return frameworkVersion.getFrameworkRatings();

    }

    private Rating getRatingObj(Long ratingId) throws NoDataException {
        if (ratingId > 0) {
            Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new NoDataException("Rating not available for the given id " + ratingId));
            return rating;
        } else throw new NoDataException("Rating Id should be Greater then 0");
    }

    private void setFrameworkDomainVOListToFrameworkDomain(FrameworkVersionVO frameworkVersionVO, FrameworkVersion frameworkVersion) {
        frameworkVersionVO.getFrameworkDomains()
                .forEach(frameworkDomainVO -> {
                    try {
                        FrameworkDomain frameworkDomain = new FrameworkDomain();
                        frameworkDomain.setFrameworkVersion(frameworkVersion);
                        frameworkDomain.setDomain(getDomainObj(frameworkDomainVO.getDomainVO().getDomainId()));
                        /*frameworkDomain.setFrameworkQuestions(*/
                        setFrameworkQuestionVOListToFrameworkQuestion(frameworkDomainVO, frameworkVersion, frameworkDomain)/*)*/;
                        frameworkVersion.getFrameworkDomains().add(frameworkDomain);
                    } catch (NoDataException e) {
                        throw new RuntimeException(e);
                    }
                });
//        return frameworkVersion.getFrameworkDomains();
    }


    private Domain getDomainObj(Long domainId) throws NoDataException {
        if (domainId > 0) {
            Domain domain = domainRepository.findById(domainId)
                    .orElseThrow(() -> new NoDataException("Domain Not available For the given Id " + domainId));
            return domain;
        } else throw new NoDataException("Domain Id should be Greater Than 0");
    }

    private void setFrameworkQuestionVOListToFrameworkQuestion(FrameworkDomainVO frameworkDomainVO, FrameworkVersion frameworkVersion, FrameworkDomain frameworkDomain) {
        frameworkDomainVO.getFrameworkQuestionVos()
                .forEach(frameworkQuestionVO -> {
                    try {
                        FrameworkQuestion frameworkQuestion = new FrameworkQuestion();
                        frameworkQuestion.setFrameworkVersion(frameworkVersion);
                        frameworkQuestion.setFrameworkDomain(frameworkDomain);
                        frameworkQuestion.setQuestion(getQuestionObj(frameworkQuestionVO.getQuestionVO().getQuestionId()));
                        frameworkDomain.getFrameworkQuestions().add(frameworkQuestion);
                    } catch (NoDataException e) {
                        throw new RuntimeException(e);
                    }
                });
//        return frameworkDomain.getFrameworkQuestions();
    }

    private Question getQuestionObj(Long questionId) throws NoDataException {
        if (questionId > 0) {
            Question question = questionRepository.findById(questionId)
                    .orElseThrow(() -> new NoDataException("Question Not available for the Given Id " + questionId));
            return question;
        } else throw new NoDataException("Question Id should be Greater than 0");
    }

    private void validate(FrameworkVO frameworkVO) throws NoDataException {
        if (StringUtils.isBlank(frameworkVO.getFrameworkName())) {
            throw new NoDataException("Framework Name is Null or Empty");
        } else if (CollectionUtils.isEmpty(frameworkVO.getFrameworkVersionVos())) {
            throw new NoDataException("Framework Version List is Empty or Null");
        }
    }


    public FrameworkVO findFrameworkData(FrameworkVO frameworkVO){
        try {
            Framework framework = frameworkRepository.findById(frameworkVO.getFrameworkId()).orElseThrow(() -> new NoDataException("Framework not available for the give id"));
            if(framework != null){
                setFrameworkToFrameworkVO(framework,frameworkVO);
                return frameworkVO;
            }
        } catch (NoDataException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void setFrameworkToFrameworkVO(Framework framework,FrameworkVO frameworkVO) {
        frameworkVO.setFrameworkName(framework.getFrameworkName());
        frameworkVO.setFrameworkStatus(framework.getFrameworkStatus());
        frameworkVO.setFrameworkVersionVos(setFrameworkVersionListToVOList(frameworkVO,framework));
    }

    private List<FrameworkVersionVO> setFrameworkVersionListToVOList(FrameworkVO frameworkVO,Framework framework) {
        framework.getFrameworkVersions()
                .forEach(frameworkVersion -> {
                    FrameworkVersionVO frameworkVersionVO = new FrameworkVersionVO();
                    frameworkVersionVO.setFrameworkVersionId(frameworkVersion.getFrameworkVersionId());
                    frameworkVersionVO.setFrameworkVersionStatus(frameworkVersion.getFrameworkVersionStatus());
                    frameworkVersionVO.setCreatedDate(frameworkVersion.getCreatedDate());
                    frameworkVersionVO.setApproveDate(frameworkVersion.getApproveDate());
                    frameworkVersionVO.setExpiryDate(frameworkVersion.getExpiryDate());
                    frameworkVersionVO.setFrameworkRatings(setFrameworkRatingToVOList(frameworkVersion,frameworkVersionVO));
                    frameworkVersionVO.setFrameworkDomains(setFrameworkDomainListToVOList(frameworkVersion,frameworkVersionVO));
                    frameworkVO.getFrameworkVersionVos().add(frameworkVersionVO);
                });
        return frameworkVO.getFrameworkVersionVos();
    }

    private List<FrameworkRatingVO> setFrameworkRatingToVOList(FrameworkVersion frameworkVersion,FrameworkVersionVO frameworkVersionVO) {
        frameworkVersion.getFrameworkRatings()
                .forEach(frameworkRating -> {
                        FrameworkRatingVO frameworkRatingVO = new FrameworkRatingVO();
                        frameworkRatingVO.setFrameworkRatingId(frameworkRating.getFrameworkRatingId());
                        frameworkRatingVO.setFrameworkRatingScore(frameworkRating.getFrameworkRatingScore());
                        frameworkRatingVO.setRatingVO(getRatingVOObj(frameworkRating.getRating()));
                        frameworkVersionVO.getFrameworkRatings().add(frameworkRatingVO);
                });
                return frameworkVersionVO.getFrameworkRatings();
    }

    private RatingVO getRatingVOObj(Rating rating) {
        RatingVO ratingVO = new RatingVO();
        ratingVO.setRatingId(rating.getRatingId());
        ratingVO.setRatingName(rating.getRatingName());
        ratingVO.setRatingStatus(rating.getRatingStatus());
        ratingVO.setRatingType(rating.getRatingType());
        ratingVO.setColorCode(rating.getColorCode());
        return ratingVO;
    }

    private List<FrameworkDomainVO> setFrameworkDomainListToVOList(FrameworkVersion frameworkVersion,FrameworkVersionVO frameworkVersionVO) {

        frameworkVersion.getFrameworkDomains()
                .forEach(frameworkDomain -> {
                    FrameworkDomainVO frameworkDomainVO = new FrameworkDomainVO();
                    frameworkDomainVO.setFrameworkDomainId(frameworkDomain.getFrameworkDomainId());
                    frameworkDomainVO.setDomainVO(getDomainVOObj(frameworkDomain.getDomain()));
                    frameworkDomainVO.setFrameworkQuestionVos(setFrameworkQuestionListToVOList(frameworkDomain,frameworkDomainVO,frameworkVersionVO));
                    frameworkVersionVO.getFrameworkDomains().add(frameworkDomainVO);
                });
        return frameworkVersionVO.getFrameworkDomains();
    }

    private List<FrameworkQuestionVO> setFrameworkQuestionListToVOList(FrameworkDomain frameworkDomain,FrameworkDomainVO frameworkDomainVO,FrameworkVersionVO frameworkVersionVO) {
        frameworkDomain.getFrameworkQuestions()
                .forEach(frameworkQuestion -> {
                    FrameworkQuestionVO frameworkQuestionVO = new FrameworkQuestionVO();
                    frameworkQuestionVO.setFrameworkQuestionId(frameworkQuestion.getFrameworkQuestionId());
                    frameworkQuestionVO.setQuestionVO(getQuestionVOObj(frameworkQuestion.getQuestion()));
                    frameworkQuestionVO.setFrameworkRatingVOS(frameworkVersionVO.getFrameworkRatings());
                    frameworkDomainVO.getFrameworkQuestionVos().add(frameworkQuestionVO);
                });
        return frameworkDomainVO.getFrameworkQuestionVos();
    }

    private QuestionVO getQuestionVOObj(Question question) {
        QuestionVO questionVO = new QuestionVO();
        questionVO.setQuestionId(question.getQuestionId());
        questionVO.setQuestionName(question.getQuestionName());
        questionVO.setQuestionDescription(question.getQuestionDescription());
        questionVO.setQuestionStatus(question.getQuestionStatus());
        return questionVO;
    }

    private DomainVO getDomainVOObj(Domain domain) {
        DomainVO domainVO = new DomainVO();
        domainVO.setDomainId(domain.getDomainId());
        domainVO.setDomainName(domain.getDomainName());
        domainVO.setDomainDescription(domain.getDomainDescription());
        domainVO.setDomainOrder(domain.getDomainOrder());
        domainVO.setDomainStatus(domain.getDomainStatus());
        return domainVO;
    }
}
