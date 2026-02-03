package com.notifications.notification.notification.domain;

import com.notifications.notification.notification.domain.enums.NotificationChannel;
import com.notifications.notification.notification.domain.enums.NotificationStatus;
import com.notifications.notification.notification.domain.valueobject.NotificationContent;
import com.notifications.notification.notification.domain.valueobject.NotificationId;
import com.notifications.notification.notification.domain.valueobject.NotificationTitle;
import com.notifications.notification.notification.domain.valueobject.UserId;

import java.time.Instant;

public class Notification {
    /***
     *
     Gestión de Notificaciones- Crear una notificación (campos: título, contenido, canal).-
     Modificar una notificación existente.- Eliminar una notificación.-
     Consultar todas las notificaciones propias.
     */
    private final NotificationId id;
    private final UserId userId;
    private NotificationTitle title;
    private NotificationContent content;
    private final NotificationChannel channel;
    private NotificationStatus notificationStatus;
    private final Instant created;


    public Notification(NotificationTitle title, NotificationContent content, NotificationChannel channel, NotificationId id, UserId userId) {
        this.title = title;
        this.content = content;
        this.channel = channel;
        this.id = id;
        this.userId = userId;
        this.notificationStatus = NotificationStatus.CREATED;
        this.created = Instant.now();
    }

}
