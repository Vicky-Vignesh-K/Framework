package com.framework.Framework.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "framework_version")
public class FrameworkVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_version_id")
    private Long frameworkVersionId;

    @Column(name = "framework_version_status")
    private String frameworkVersionStatus;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "approve_date")
    private Date ApproveDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "frameworkVersion",fetch = FetchType.LAZY)
    private List<FrameworkRating> frameworkRatings;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "frameworkVersion",fetch = FetchType.LAZY)
    private List<FrameworkDomain> frameworkDomains;


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

    public List<FrameworkRating> getFrameworkRatings() {
        if(CollectionUtils.isEmpty(frameworkRatings))
            frameworkRatings = new ArrayList<>();
        return frameworkRatings;
    }

    public void setFrameworkRatings(List<FrameworkRating> frameworkRatings) {
        this.frameworkRatings = frameworkRatings;
    }

    public List<FrameworkDomain> getFrameworkDomains() {
        if(CollectionUtils.isEmpty(frameworkDomains))
            frameworkDomains = new ArrayList<>();
        return frameworkDomains;
    }

    public void setFrameworkDomains(List<FrameworkDomain> frameworkDomains) {
        this.frameworkDomains = frameworkDomains;
    }
}
