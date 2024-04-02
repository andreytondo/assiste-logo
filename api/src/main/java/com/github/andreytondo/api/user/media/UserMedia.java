package com.github.andreytondo.api.user.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.andreytondo.api.enums.MediaStatus;
import com.github.andreytondo.api.enums.MediaType;
import com.github.andreytondo.api.user.User;
import com.github.andreytondo.utils.crud.Identifiable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Entity @Builder
@Table(name = "usermedia")
@AllArgsConstructor @NoArgsConstructor
public class UserMedia implements Identifiable<Integer> {

    @Id
    @Column(name = "usermediaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userid")
    private User user;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    private Integer mediaId;

    @Enumerated(EnumType.STRING)
    private MediaStatus status;

    private Integer rating;

    private String review;

    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
