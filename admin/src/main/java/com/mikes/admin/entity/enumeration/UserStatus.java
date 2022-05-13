package com.mikes.admin.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    //启用
    START(1,"已启用"),
    //封禁
    STOP(0, "已停用");

    private final int code;
    private final String message;
}
