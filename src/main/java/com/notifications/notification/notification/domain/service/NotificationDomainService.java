package com.notifications.notification.notification.domain.service;

import com.notifications.notification.notification.domain.Notification;
import com.notifications.notification.notification.domain.port.out.NotificationEventPublisher;

public class NotificationDomainService {
    private final NotificationEventPublisher  eventPublisher;
    public NotificationDomainService(NotificationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    //- Este metodo debe disparar un evento de dominio cuando se crea una notificación
    public void publishNotificationCreated(Notification notification) {}
}
