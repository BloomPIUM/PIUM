package com.bloom.pium.data;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    USER("일반사용자"), ADMIN("관리자");

    private final String roleName;

    UserRoleEnum(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }
}
