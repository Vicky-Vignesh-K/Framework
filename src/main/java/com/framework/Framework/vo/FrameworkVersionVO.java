package com.framework.Framework.vo;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrameworkVersionVO {

    private Long frameworkVersionId;
    private String frameworkVersionStatus;
    private Date createdDate;
    private Date expiryDate;
    private Date ApproveDate;
    private List<FrameworkRatingVO> frameworkRatings;
    private List<FrameworkDomainVO> frameworkDomains;


    public Long getFrameworkVersionId() {
        return frameworkVersionId;
    }

    public void setFrameworkVersionId(Long frameworkVersionId) {
        this.frameworkVersionId = frameworkVersionId;
    }

    public String getFrameworkVersionStatus() {
        return frameworkVersionStatus;
    }

    public void setFrameworkVersionStatus(String frameworkVersionStatus) {
        this.frameworkVersionStatus = frameworkVersionStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getApproveDate() {
        return ApproveDate;
    }

    public void setApproveDate(Date approveDate) {
        ApproveDate = approveDate;
    }

    public List<FrameworkRatingVO> getFrameworkRatings() {
        if(CollectionUtils.isEmpty(frameworkRatings))
            frameworkRatings = new ArrayList<>();
        return frameworkRatings;
    }

    public void setFrameworkRatings(List<FrameworkRatingVO> frameworkRatings) {
        this.frameworkRatings = frameworkRatings;
    }

    public List<FrameworkDomainVO> getFrameworkDomains() {
        if(CollectionUtils.isEmpty(frameworkDomains))
            frameworkDomains = new ArrayList<>();
        return frameworkDomains;
    }

    public void setFrameworkDomains(List<FrameworkDomainVO> frameworkDomains) {
        this.frameworkDomains = frameworkDomains;
    }
}
