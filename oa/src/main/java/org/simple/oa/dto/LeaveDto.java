package org.simple.oa.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.simple.oa.enums.LeaveType;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@TableName("t_oa_leave")
public class LeaveDto extends BaseDto{
    public static final String procInstKey="leave";
    public static final String tableName="t_oa_leave";

    private String leaveId;
    @NotNull(message = "请假原因不能为空")
    private String reason;
    @NotNull
    private int leaveDays;//请假天数
    @NotNull
    private Date leaveDate;//请假日期
    @NotNull
    private LeaveType leaveType;//1事假，2年假，3病假，4婚假
    private String status;//审批状态：0已提交，1审批成功，2审批失败
    private String userId;//请假人，流程发起人
    private String procInstId;//流程Id
    private String examineId;//审核人
    private String examineDate;//审核日期

    //获取activiti流程 busikey
    public String getProcBusinessKey(){
        return tableName+":"+leaveId;
    }

    public void generalId(){
        this.leaveId= UUID.randomUUID().toString().replace("-","");
    }

}
