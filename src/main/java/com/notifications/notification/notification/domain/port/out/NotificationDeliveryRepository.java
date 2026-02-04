package com.notifications.notification.notification.domain.port.out;

import com.notifications.notification.notification.domain.NotificationDelivery;

public interface NotificationDeliveryRepository {
    NotificationDelivery save(NotificationDelivery delivery);
}
