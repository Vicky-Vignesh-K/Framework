package com.framework.Framework.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "framework_question")
public class FrameworkQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_question_id")
    private Long frameworkQuestionId;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private FrameworkVersion frameworkVersion;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private FrameworkDomain frameworkDomain;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Question question;

    public Long getFrameworkQuestionId() {
        return frameworkQuestionId;
    }

    public void setFrameworkQuestionId(Long frameworkQuestionId) {
        this.frameworkQuestionId = frameworkQuestionId;
    }

    public FrameworkVersion getFrameworkVersion() {
        return frameworkVersion;
    }

    public void setFrameworkVersion(FrameworkVersion frameworkVersion) {
        this.frameworkVersion = frameworkVersion;
    }

    public FrameworkDomain getFrameworkDomain() {
        return frameworkDomain;
    }

    public void setFrameworkDomain(FrameworkDomain frameworkDomain) {
        this.frameworkDomain = frameworkDomain;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
