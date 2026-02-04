package com.notifications.notification.notification.application.ucase;

import com.notifications.notification.notification.application.CreateNotificationCommand;
import com.notifications.notification.notification.domain.valueobject.NotificationId;

/***
 * Principios / patrones
 * * DIP: dependemos de abstracciones
 * * Hexagonal: puerto de entrada
 * * ISP: interfaz pequeña y específica
 */
public interface CreateNotificationUseCase {
    NotificationId  create(CreateNotificationCommand command);


}
