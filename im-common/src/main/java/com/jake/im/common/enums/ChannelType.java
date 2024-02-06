package com.jake.im.common.enums;

import lombok.Getter;

@Getter
public enum ChannelType {
    PERSONAL(1), SINGLE(2), GROUP(200), SUPERGROUP(5000);

    ChannelType(int userCountLimit) {
        this.userCountLimit = userCountLimit;
    }

    private final int userCountLimit;

    public boolean isGroup() {
        return this == GROUP || this == SUPERGROUP;
    }
}
