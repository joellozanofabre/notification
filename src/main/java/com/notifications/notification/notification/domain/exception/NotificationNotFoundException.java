package com.notifications.notification.notification.domain.exception;

import com.notifications.notification.notification.domain.valueobject.NotificationId;
//Excepción base del dominio.

public class NotificationNotFoundException extends DomainException {
    public NotificationNotFoundException(NotificationId id) {
        super("Notification with id " + id + " not found");
    }

}
