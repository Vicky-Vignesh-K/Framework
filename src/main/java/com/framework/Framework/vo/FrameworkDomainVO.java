package com.framework.Framework.vo;

import com.framework.Framework.entity.Domain;
import com.framework.Framework.entity.FrameworkQuestion;
import com.framework.Framework.entity.FrameworkVersion;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class FrameworkDomainVO {

    private Long frameworkDomainId;
//    private FrameworkVersionVO frameworkVersionVO;
    private DomainVO domainVO;
    private List<FrameworkQuestionVO> frameworkQuestionVos;


    public Long getFrameworkDomainId() {
        return frameworkDomainId;
    }

    public void setFrameworkDomainId(Long frameworkDomainId) {
        this.frameworkDomainId = frameworkDomainId;
    }

//    public FrameworkVersionVO getFrameworkVersionVO() {
//        return frameworkVersionVO;
//    }
//
//    public void setFrameworkVersionVO(FrameworkVersionVO frameworkVersionVO) {
//        this.frameworkVersionVO = frameworkVersionVO;
//    }

    public DomainVO getDomainVO() {
        return domainVO;
    }

    public void setDomainVO(DomainVO domainVO) {
        this.domainVO = domainVO;
    }

    public List<FrameworkQuestionVO> getFrameworkQuestionVos() {
        if(CollectionUtils.isEmpty(frameworkQuestionVos))
            frameworkQuestionVos = new ArrayList<>();
        return frameworkQuestionVos;
    }

    public void setFrameworkQuestionVos(List<FrameworkQuestionVO> frameworkQuestionVos) {
        this.frameworkQuestionVos = frameworkQuestionVos;
    }
}
