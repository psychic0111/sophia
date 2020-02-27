package com.yz.sophia.stargaze.model.vo;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String userName;

    public User() {
    }

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
