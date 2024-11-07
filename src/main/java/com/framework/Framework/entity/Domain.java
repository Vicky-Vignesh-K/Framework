package com.framework.Framework.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private Long domainId;

    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "domain_order")
    private Long domainOrder;

    @Column(name = "domain_status")
    private String domainStatus;

    @Column(name = "domain_description")
    private String domainDescription;

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Long getDomainOrder() {
        return domainOrder;
    }

    public void setDomainOrder(Long domainOrder) {
        this.domainOrder = domainOrder;
    }

    public String getDomainStatus() {
        return domainStatus;
    }

    public void setDomainStatus(String domainStatus) {
        this.domainStatus = domainStatus;
    }

    public String getDomainDescription() {
        return domainDescription;
    }

    public void setDomainDescription(String domainDescription) {
        this.domainDescription = domainDescription;
    }
}
