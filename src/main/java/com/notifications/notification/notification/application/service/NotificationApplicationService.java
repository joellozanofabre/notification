package com.notifications.notification.notification.application.service;


import com.notifications.notification.notification.application.CreateNotificationCommand;
import com.notifications.notification.notification.application.ucase.CreateNotificationUseCase;
import com.notifications.notification.notification.domain.Notification;
import com.notifications.notification.notification.domain.event.NotificationCreatedEvent;
import com.notifications.notification.notification.domain.port.out.NotificationRepository;
import com.notifications.notification.notification.domain.valueobject.NotificationId;
import com.notifications.notification.shared.util.shared.common.DomainEventPublisher;
/**
 * Application Service that orchestrates Notification-related use cases.
 *
 * Pattern: Application Service
 *
 * Responsibilities:
 * - Coordina el caso de uso de creación de notificaciones.
 * - Interactúa con el repositorio para persistir la entidad.
 * - Publica un evento de dominio tras la creación.
 * - No contiene reglas de negocio complejas: estas se aplican dentro del dominio (entidad Notification).
 *
 * Collaborators:
 * - NotificationRepository: puerto de salida para persistencia.
 * - DomainEventPublisher: puerto de salida para publicar eventos de dominio.
 *
 * Lifecycle:
 * 1. Recibe un comando de creación (CreateNotificationCommand).
 * 2. Construye la entidad Notification usando su método de fábrica.
 * 3. Persiste la entidad en el repositorio.
 * 4. Publica un evento NotificationCreatedEvent.
 * 5. Devuelve el identificador de la notificación creada.
 */

public class NotificationApplicationService  implements CreateNotificationUseCase {


    private final NotificationRepository notificationRepository;
    private final DomainEventPublisher eventPublisher;

    /**
     * Constructor del Application Service.
     *
     * @param notificationRepository Puerto de salida para persistencia de notificaciones.
     * @param eventPublisher Puerto de salida para publicar eventos de dominio.
     */

    public NotificationApplicationService(NotificationRepository notificationRepository,
                                          DomainEventPublisher eventPublisher) {
        this.notificationRepository = notificationRepository;
        this.eventPublisher = eventPublisher;
    }

    /**
     * Caso de uso: Crear una notificación.
     *
     * Flujo:
     * - Se construye la entidad Notification a partir del comando recibido.
     * - Se guarda en el repositorio.
     * - Se publica un evento de dominio indicando que la notificación fue creada.
     *
     * Importante:
     * - Las reglas de negocio (invariantes, validaciones) se aplican dentro de la entidad Notification.
     * - El Application Service solo orquesta y coordina dependencias externas.
     *
     * @param command Comando con los datos necesarios para crear la notificación.
     * @return NotificationId Identificador único de la notificación creada.
     */

    @Override
    public NotificationId create(CreateNotificationCommand command) {
        Notification notification = Notification.create(
                command.userId(),
                command.title(),
                command.content(),
                command.channel()
        );
        notificationRepository.save(notification);
        eventPublisher.publish(new NotificationCreatedEvent(notification.getId()));
        return notification.getId();
    }
}
