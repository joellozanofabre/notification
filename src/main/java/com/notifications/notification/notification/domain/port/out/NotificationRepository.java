package com.notifications.notification.notification.domain.port.out;

import com.notifications.notification.notification.domain.Notification;
import com.notifications.notification.notification.domain.valueobject.NotificationId;
import com.notifications.notification.notification.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;
//Aquí usamos el Aggregate Root Notification, no entidades de JPA.
public interface NotificationRepository {
    Notification save(Notification notification);
    Optional<Notification> findById(NotificationId id);
    List<Notification> findByUserId(UserId id);
    void deleteById(NotificationId id);
}
