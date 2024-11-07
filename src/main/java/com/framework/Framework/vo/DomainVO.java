package com.framework.Framework.vo;

import com.framework.Framework.config.ResponseStructure;
import org.springframework.stereotype.Component;


public class DomainVO extends ResponseStructure {

    private Long domainId;

    private String domainName;

    private Long domainOrder;

    private String domainStatus;

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
