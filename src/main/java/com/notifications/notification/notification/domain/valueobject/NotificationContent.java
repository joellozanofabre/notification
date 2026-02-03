package com.notifications.notification.notification.domain.valueobject;

import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.exception.InvalidNotificationException;

public record NotificationContent(String value) {

    public void ValidateChannel(NotificationChannel notificationChannel) {
      if (notificationChannel == NotificationChannel.SMS && value.length() >  160) {
          throw new InvalidNotificationException("Sms exceeds 160 characters");

      }
    }
}
