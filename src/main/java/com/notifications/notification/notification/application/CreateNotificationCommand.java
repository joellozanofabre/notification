package com.notifications.notification.notification.application;


import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.valueobject.NotificationContent;
import com.notifications.notification.notification.domain.valueobject.NotificationTitle;
import com.notifications.notification.notification.domain.valueobject.UserId;

import java.nio.channels.Channel;

public record CreateNotificationCommand(UserId userId,
                                        NotificationTitle title,
                                        NotificationContent content,
                                        NotificationChannel channel)
{
}
