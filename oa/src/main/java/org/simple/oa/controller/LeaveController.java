package org.simple.oa.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.oa.dto.LeaveDto;
import org.simple.oa.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService  ;

    @PostMapping("apply")
    public String apply(@RequestBody @Valid LeaveDto leaveDto){
        try {
            leaveService.leaveApply(leaveDto);
        } catch (Exception e) {
            log.error("请假申请服务异常{}",e.getMessage());
            return e.toString();
        }
        return "";
    }
}
