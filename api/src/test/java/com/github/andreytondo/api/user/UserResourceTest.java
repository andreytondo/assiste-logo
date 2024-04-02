package com.github.andreytondo.api.user;

import com.github.andreytondo.TransactionalQuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@TransactionalQuarkusTest
public class UserResourceTest {

    @Inject
    UserService userService;

    ZoneId brazilZoneId = ZoneId.of("America/Sao_Paulo"); // Brazil's time zone
    ZoneOffset offset = brazilZoneId.getRules().getOffset(LocalDateTime.now());

    @Test
    @DisplayName("Should create a user")
    public void shouldCreateUser() {
        User user = User.builder()
                .email("teste")
                .password("teste2")
                .name("nome")
                .build();
        userService.create(user);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    @DisplayName("Should read a user")
    public void shouldReadUser() {
        User user = User.builder()
                .email("teste")
                .password("teste2")
                .name("nome")
                .build();
        userService.create(user);
        User userRead = userService.read(user.getId());
        Assertions.assertAll(
                () -> Assertions.assertEquals(user.getEmail(), userRead.getEmail()),
                () -> Assertions.assertEquals(user.getPassword(), userRead.getPassword()),
                () -> Assertions.assertEquals(user.getName(), userRead.getName()),
                () -> Assertions.assertEquals(user.getCreatedAt(), userRead.getCreatedAt())
        );
    }
}
