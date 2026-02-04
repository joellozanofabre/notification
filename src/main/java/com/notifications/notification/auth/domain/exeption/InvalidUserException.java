package com.notifications.notification.auth.domain.exeption;

import com.notifications.notification.notification.domain.exception.DomainException;

public class InvalidUserException extends DomainException {
    public InvalidUserException(String message) {
        super(message);
    }
}
