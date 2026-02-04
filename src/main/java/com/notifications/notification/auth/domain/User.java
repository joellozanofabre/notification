package com.notifications.notification.auth.domain;

import com.notifications.notification.auth.domain.valueobject.Password;
import com.notifications.notification.auth.domain.valueobject.Email;
import com.notifications.notification.auth.domain.valueobject.UserId;

import java.util.UUID;

public class User {
    private UserId id;
    private Password password;
    private Email email;

    private User(UserId id, Password password, Email email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    //factory method : semántica de dominio que Encapsula la creación del objeto.
    //Garantiza invariantes y generación de ID.
    public static User create(UserId userId, Password password, Email email) {
        return new User(new UserId(UUID.randomUUID()),  password,email);
    }

    // Getters
    public UserId getId() {    return id;    }

    public Email getEmail() {   return email;  }
}
