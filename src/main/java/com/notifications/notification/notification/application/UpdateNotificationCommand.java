package com.notifications.notification.notification.application;

import com.notifications.notification.auth.domain.valueobject.UserId;
import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.valueobject.NotificationContent;
import com.notifications.notification.notification.domain.valueobject.NotificationTitle;

public record UpdateNotificationCommand(UserId userId,
                                        NotificationContent content,
                                        NotificationTitle title,
                                        NotificationChannel channel) {
}
