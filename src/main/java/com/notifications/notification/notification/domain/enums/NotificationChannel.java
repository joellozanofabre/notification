package com.notifications.notification.notification.domain.enums;

import com.notifications.notification.notification.domain.exception.InvalidNotificationException;

import java.util.Map;

public enum NotificationChannel {

    EMAIL("E", "Email"),
    SMS("S", "Mensajes de Texto"),
    PUSH("P", "Push Notification");


    private final String code;
    private final String description;

    private NotificationChannel(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    private static final Map<String, NotificationChannel> BY_CODE = Map.ofEntries(
            Map.entry("E", EMAIL),
            Map.entry("S", SMS),
            Map.entry("P", PUSH)
    );

    public static NotificationChannel fromCode(String code) {
        NotificationChannel type = BY_CODE.get(code);
        if (type == null) {
            throw new InvalidNotificationException("Invalid Channel Code");
        }
        return type;
    }

}
