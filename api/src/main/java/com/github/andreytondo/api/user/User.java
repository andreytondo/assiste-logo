package com.github.andreytondo.api.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.andreytondo.api.user.friend.UserFriend;
import com.github.andreytondo.api.user.media.UserMedia;
import com.github.andreytondo.utils.crud.Identifiable;
import jakarta.persistence.*;
import lombok.*;
import org.wildfly.common.annotation.NotNull;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User implements Identifiable<Integer> {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @JsonBackReference
    private String password;

    @NotNull
    private String email;

    @Builder.Default
    @Column(name = "createdat", columnDefinition= "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    private List<UserFriend> friends;

    @OneToMany(mappedBy = "user")
    private List<UserMedia> media;

    private byte[] image;

    public User(Integer id) {
        this.id = id;
    }
}
