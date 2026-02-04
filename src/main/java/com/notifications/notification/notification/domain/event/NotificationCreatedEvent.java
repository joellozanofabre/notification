package com.notifications.notification.notification.domain.event;

import com.notifications.notification.notification.domain.valueobject.NotificationId;
import com.notifications.notification.shared.util.shared.common.DomainEvent;

public record NotificationCreatedEvent(
        NotificationId notificationId
) implements DomainEvent {
}
