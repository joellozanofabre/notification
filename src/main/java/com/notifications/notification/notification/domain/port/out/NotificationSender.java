package com.notifications.notification.notification.domain.port.out;
import com.notifications.notification.notification.domain.Notification;

//Envío por canal (Strategy)
public interface NotificationSender {
    NotificationSender send(Notification notification);

}
