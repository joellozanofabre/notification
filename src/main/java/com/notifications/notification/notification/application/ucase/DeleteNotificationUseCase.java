package com.notifications.notification.notification.application.ucase;

import com.notifications.notification.notification.domain.valueobject.NotificationId;

public interface DeleteNotificationUseCase {
    NotificationId deleteNotification(NotificationId notificationId);
}
