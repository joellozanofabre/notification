package com.notifications.notification.notification.domain;

import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.enums.NotificationStatus;
import com.notifications.notification.notification.domain.valueobject.NotificationContent;
import com.notifications.notification.notification.domain.valueobject.NotificationId;
import com.notifications.notification.notification.domain.valueobject.NotificationTitle;
import com.notifications.notification.notification.domain.valueobject.UserId;

import java.nio.channels.Channel;
import java.time.Instant;
import java.util.UUID;

/**
 * Aggregate Root that represents a Notification created by a user.
 */
public class Notification {

    private final NotificationId id;
    private final UserId userId;
    private NotificationTitle title;
    private NotificationContent content;
    private final NotificationChannel channel;
    private NotificationStatus status;
    private final Instant createdAt;

    private Notification(
            NotificationId id,
            UserId userId,
            NotificationTitle title,
            NotificationContent content,
            NotificationChannel channel
    ) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.channel = channel;
        this.status = NotificationStatus.CREATED;
        this.createdAt = Instant.now();
    }

    public static Notification create(
            UserId userId,
            NotificationTitle title,
            NotificationContent content,
            NotificationChannel channel
    ) {
        return new Notification(
                new NotificationId(UUID.randomUUID()),
                userId,
                title,
                content,
                channel
        );
    }

    /**
     * Marks the notification as successfully sent.
     * Called after a successful NotificationDelivery.
     */
    public void markAsSent() {
        this.status = NotificationStatus.SENT;
    }

    /**
     * Marks the notification as failed.
     */
    public void markAsFailed() {
        this.status = NotificationStatus.FAILED;
    }

    // --- Getters ---

    public NotificationId getId() {
        return id;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public NotificationStatus getStatus() {
        return status;
    }
}
