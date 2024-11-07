package com.framework.Framework.business;

import com.framework.Framework.vo.FrameworkVO;
import org.springframework.stereotype.Component;

@Component
public interface IFrameworkBO {

    FrameworkVO saveFramework(FrameworkVO frameworkVO);

    FrameworkVO findFrameworkData(FrameworkVO frameworkVO);

}
