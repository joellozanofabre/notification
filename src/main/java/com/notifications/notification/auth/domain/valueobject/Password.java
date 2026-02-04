package com.notifications.notification.auth.domain.valueobject;

import com.notifications.notification.auth.domain.exeption.InvalidUserException;

public record Password(String password) {
 public  Password {
     if (password == null || password.length() < 6 )
         throw new InvalidUserException("Password should have 6 characters long");
 }
}
