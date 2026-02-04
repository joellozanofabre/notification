package com.notifications.notification.auth.domain.port.out;

import com.notifications.notification.auth.domain.User;
import com.notifications.notification.notification.domain.valueobject.UserId;

import java.util.Optional;

public interface UserRepository {

    public User save(User user);

    //- Esta búsqueda puede o no devolver un resultado”.
    Optional<User> findById(UserId userId);
    // boolean existsByEmail(String email);
}
