package org.simple.oa.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

public enum  LeaveType {
    AFFAIR(1,"事假"),SICK(2,"病假"),YEAR(3,"年假");

    @Getter
    @EnumValue
    private int value;
    @Getter
    private String label;
    private LeaveType(int value,String label){
        this.value=value;
        this.label=label;

    }


}
