package com.framework.Framework.vo;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class FrameworkQuestionVO {

    private Long frameworkQuestionId;
    private QuestionVO questionVO;

    private List<FrameworkRatingVO> frameworkRatingVOS;


    public Long getFrameworkQuestionId() {
        return frameworkQuestionId;
    }

    public void setFrameworkQuestionId(Long frameworkQuestionId) {
        this.frameworkQuestionId = frameworkQuestionId;
    }

    public QuestionVO getQuestionVO() {
        return questionVO;
    }

    public void setQuestionVO(QuestionVO questionVO) {
        this.questionVO = questionVO;
    }

    public List<FrameworkRatingVO> getFrameworkRatingVOS() {
        if(CollectionUtils.isEmpty(frameworkRatingVOS))
            frameworkRatingVOS = new ArrayList<>();
        return frameworkRatingVOS;
    }

    public void setFrameworkRatingVOS(List<FrameworkRatingVO> frameworkRatingVOS) {
        this.frameworkRatingVOS = frameworkRatingVOS;
    }
}
