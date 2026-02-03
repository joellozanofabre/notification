package com.notifications.notification.auth.domain;

public record AuthUsername(String value) {
    public AuthUsername {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
    }
}
