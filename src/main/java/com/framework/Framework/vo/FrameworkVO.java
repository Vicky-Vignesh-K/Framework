package com.framework.Framework.vo;

import com.framework.Framework.config.ResponseStructure;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class FrameworkVO extends ResponseStructure {

    private Long frameworkId;

    private String frameworkName;

    private String frameworkStatus;

    private List<FrameworkVersionVO> frameworkVersionVos;

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

    public List<FrameworkVersionVO> getFrameworkVersionVos() {
        if (CollectionUtils.isEmpty(frameworkVersionVos))
            frameworkVersionVos = new ArrayList<>();
        return frameworkVersionVos;
    }

    public void setFrameworkVersionVos(List<FrameworkVersionVO> frameworkVersionVos) {
        this.frameworkVersionVos = frameworkVersionVos;
    }
}
