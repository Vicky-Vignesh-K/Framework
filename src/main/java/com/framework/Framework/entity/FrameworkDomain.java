package com.framework.Framework.entity;

import jakarta.persistence.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "framework_domain")
public class FrameworkDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_domain_id")
    private Long frameworkDomainId;

    @ManyToOne(cascade = CascadeType.ALL)
    private FrameworkVersion frameworkVersion;

    @ManyToOne(cascade = CascadeType.ALL)
    private Domain domain;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "frameworkDomain")
    private List<FrameworkQuestion> frameworkQuestions;


    public Long getFrameworkDomainId() {
        return frameworkDomainId;
    }

    public void setFrameworkDomainId(Long frameworkDomainId) {
        this.frameworkDomainId = frameworkDomainId;
    }

    public FrameworkVersion getFrameworkVersion() {
        return frameworkVersion;
    }

    public void setFrameworkVersion(FrameworkVersion frameworkVersion) {
        this.frameworkVersion = frameworkVersion;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public List<FrameworkQuestion> getFrameworkQuestions() {
        if(CollectionUtils.isEmpty(frameworkQuestions))
            frameworkQuestions = new ArrayList<>();
        return frameworkQuestions;
    }

    public void setFrameworkQuestions(List<FrameworkQuestion> frameworkQuestions) {
        this.frameworkQuestions = frameworkQuestions;
    }
}
