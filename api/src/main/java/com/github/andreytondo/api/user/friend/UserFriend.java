package com.github.andreytondo.api.user.friend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.andreytondo.api.enums.UserFriendStatus;
import com.github.andreytondo.api.user.User;
import com.github.andreytondo.utils.crud.Identifiable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "userfriend")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class UserFriend implements Identifiable<Integer> {

    @Id
    @Column(name = "userfriendid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friendid")
    private User friend;

    @Enumerated(EnumType.STRING)
    private UserFriendStatus status;

    private LocalDateTime createdAt;
}
