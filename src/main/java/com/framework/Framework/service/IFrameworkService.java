package com.framework.Framework.service;

import com.framework.Framework.vo.FrameworkVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IFrameworkService {

    ResponseEntity<FrameworkVO> saveFramework(FrameworkVO frameworkVO);

    ResponseEntity<FrameworkVO> findFrameworkData(FrameworkVO frameworkVO);

}
