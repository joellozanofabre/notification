package com.notifications.notification.notification.domain.valueobject;

import com.notifications.notification.notification.domain.exception.InvalidNotificationException;

//- constructor compacto
public record NotificationTitle(String value) {
public NotificationTitle {
    if (value == null || value.isBlank()) {
        throw new InvalidNotificationException("value is null or blank");
    }
}

}
