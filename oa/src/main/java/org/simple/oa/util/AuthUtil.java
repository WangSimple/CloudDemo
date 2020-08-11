package org.simple.oa.util;

import org.simple.rbac.api.dto.UserDto;

public class AuthUtil {
    public static UserDto getCurrentUser(){
        return UserDto.getAdimn();
    }
}
