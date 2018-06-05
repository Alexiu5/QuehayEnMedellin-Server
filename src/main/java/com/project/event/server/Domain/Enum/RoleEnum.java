package com.project.event.server.Domain.Enum;

public enum RoleEnum {
    ADMIN(0L, "ADMIN"),
    USER(1L, "USER"),
    COMPANY(2L, "COMPANY");

    private final Long index;
    private final String name;

    RoleEnum(Long index, String name) {
        this.index = index;
        this.name = name;
    }

    public Long getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
