package com.notifications.notification.notification.domain.port.in;

import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.valueobject.NotificationContent;
import com.notifications.notification.notification.domain.valueobject.NotificationId;
import com.notifications.notification.notification.domain.valueobject.NotificationTitle;
import com.notifications.notification.notification.domain.valueobject.UserId;

import java.util.List;

public interface NotificationUseCase {
//- devuelve NotificationId
NotificationId create(UserId userId, NotificationTitle title, NotificationContent content, NotificationChannel channel);
    void update(NotificationId id, NotificationTitle title, NotificationContent content);
    void delete(NotificationId id);
    List<NotificationId> findByUser(UserId userId);
}
