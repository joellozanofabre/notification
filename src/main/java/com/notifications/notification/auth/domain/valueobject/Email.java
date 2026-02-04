package com.notifications.notification.auth.domain.valueobject;

import com.notifications.notification.auth.domain.exeption.InvalidUserException;
import com.notifications.notification.notification.domain.port.out.NotificationEventPublisher;

public record Email(String value)  {
    public Email {
        if (!value.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new InvalidUserException("Invalid email format");
        }
    }
}
