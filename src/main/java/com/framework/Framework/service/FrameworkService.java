package com.framework.Framework.service;

import com.framework.Framework.business.IFrameworkBO;
import com.framework.Framework.entity.Framework;
import com.framework.Framework.vo.FrameworkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class
FrameworkService implements IFrameworkService {
    @Autowired
    private IFrameworkBO frameworkBO;

    @Override
    public ResponseEntity<FrameworkVO> saveFramework(FrameworkVO frameworkVO) {
        FrameworkVO savedFrameworkVO = frameworkBO.saveFramework(frameworkVO);
        if (savedFrameworkVO != null) {
            frameworkVO.setMessage("Framework Saved Successfully");
            frameworkVO.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(savedFrameworkVO, HttpStatus.CREATED);
        }
        frameworkVO.setMessage("Error in Saving Framework");
        frameworkVO.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(frameworkVO, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<FrameworkVO> findFrameworkData(FrameworkVO frameworkVO) {
        frameworkVO = frameworkBO.findFrameworkData(frameworkVO);
        if (frameworkVO != null) {
            frameworkVO.setMessage("Framework Data Found");
            frameworkVO.setStatusCode(HttpStatus.FOUND.value());
            return new ResponseEntity<>(frameworkVO, HttpStatus.FOUND);
        }
        frameworkVO.setMessage("Error in finding Framework Data");
        frameworkVO.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(frameworkVO, HttpStatus.NOT_FOUND);
    }
}
