package com.notifications.notification.notification.domain.port.out;

import com.notifications.notification.notification.domain.Notification;

//Este puerto abstrae Kafka. El dominio no sabe que existe Kafka, solo sabe que "publica un evento".
public interface NotificationEventPublisher {
void publishNotificationCreated(Notification notification);
}
