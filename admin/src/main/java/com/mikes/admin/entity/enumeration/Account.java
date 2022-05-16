package com.mikes.admin.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Account {

    //启用
    START(0,"已启用"),
    //封禁
    STOP(1, "已停用");

    private final int code;
    private final String message;
}
