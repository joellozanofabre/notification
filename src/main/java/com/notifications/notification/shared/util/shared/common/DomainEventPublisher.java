package com.notifications.notification.shared.util.shared.common;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
