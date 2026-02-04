package com.notifications.notification.notification.domain;

import com.notifications.notification.notification.domain.enums.DeliveryStatus;
import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.valueobject.DeliveryId;
import com.notifications.notification.notification.domain.valueobject.NotificationId;

import java.time.Instant;
import java.util.UUID;

/**
 * Domain Entity that represents the delivery of a Notification
 * through a specific channel.
 *
 * It records WHEN, HOW and with WHAT RESULT a notification was sent.
 *
 * This class does NOT send notifications.
 * It only represents the business fact of a delivery.
 */
public class NotificationDelivery {

    private final DeliveryId id;
    private final NotificationId notificationId;
    private final NotificationChannel channel;
    private final DeliveryStatus status;
    private final Instant deliveredAt;
    private final String target;

    private NotificationDelivery(
            DeliveryId id,
            NotificationId notificationId,
            NotificationChannel channel,
            DeliveryStatus status,
            Instant deliveredAt,
            String target
    ) {
        this.id = id;
        this.notificationId = notificationId;
        this.channel = channel;
        this.status = status;
        this.deliveredAt = deliveredAt;
        this.target = target;
    }

    /**
     * Factory method used when a notification is successfully delivered.
     */
    public static NotificationDelivery success(
            Notification notification,
            String target
    ) {
        return new NotificationDelivery(
                new DeliveryId(UUID.randomUUID()),
                notification.getId(),
                notification.getChannel(),
                DeliveryStatus.SENT,
                Instant.now(),
                target
        );
    }

    // --- Getters (no setters, entity is immutable) ---

    public DeliveryId getId() {
        return id;
    }

    public NotificationId getNotificationId() {
        return notificationId;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public Instant getDeliveredAt() {
        return deliveredAt;
    }

    public String getTarget() {
        return target;
    }
}
