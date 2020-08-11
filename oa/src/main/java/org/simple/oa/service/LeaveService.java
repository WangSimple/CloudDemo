package org.simple.oa.service;

import org.simple.oa.dto.LeaveDto;

public interface LeaveService {
    void leaveApply(LeaveDto leaveDto) throws Exception;
}
