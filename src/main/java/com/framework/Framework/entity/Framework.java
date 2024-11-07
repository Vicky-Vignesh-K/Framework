package com.framework.Framework.entity;

import jakarta.persistence.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "framework")
public class Framework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_id")
    private Long frameworkId;
    @Column(name = "framework_name")
    private String frameworkName;
    @Column(name = "framework_status")
    private String frameworkStatus;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FrameworkVersion> frameworkVersions;

    public Long getFrameworkId() {
        return frameworkId;
    }

    public void setFrameworkId(Long frameworkId) {
        this.frameworkId = frameworkId;
    }

    public String getFrameworkName() {
        return frameworkName;
    }

    public void setFrameworkName(String frameworkName) {
        this.frameworkName = frameworkName;
    }

    public String getFrameworkStatus() {
        return frameworkStatus;
    }

    public void setFrameworkStatus(String frameworkStatus) {
        this.frameworkStatus = frameworkStatus;
    }

    public List<FrameworkVersion> getFrameworkVersions() {
        if (CollectionUtils.isEmpty(frameworkVersions))
            frameworkVersions = new ArrayList<>();
        return frameworkVersions;
    }

    public void setFrameworkVersions(List<FrameworkVersion> frameworkVersions) {
        this.frameworkVersions = frameworkVersions;
    }
}
