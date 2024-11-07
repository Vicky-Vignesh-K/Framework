package com.framework.Framework.vo;

public class FrameworkRatingVO {

    private Long frameworkRatingId;
//    private FrameworkVersionVO frameworkVersionVO;
    private RatingVO ratingVO;
    private Double frameworkRatingScore;


    public Long getFrameworkRatingId() {
        return frameworkRatingId;
    }

    public void setFrameworkRatingId(Long frameworkRatingId) {
        this.frameworkRatingId = frameworkRatingId;
    }

//    public FrameworkVersionVO getFrameworkVersionVO() {
//        return frameworkVersionVO;
//    }
//
//    public void setFrameworkVersionVO(FrameworkVersionVO frameworkVersionVO) {
//        this.frameworkVersionVO = frameworkVersionVO;
//    }

    public RatingVO getRatingVO() {
        return ratingVO;
    }

    public void setRatingVO(RatingVO ratingVO) {
        this.ratingVO = ratingVO;
    }

    public Double getFrameworkRatingScore() {
        return frameworkRatingScore;
    }

    public void setFrameworkRatingScore(Double frameworkRatingScore) {
        this.frameworkRatingScore = frameworkRatingScore;
    }
}
