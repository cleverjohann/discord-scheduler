package com.example.discord_scheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Column(nullable = false)
    private String content;

    @NotNull(message = "La fecha de envío es obligatoria")
    @Future(message = "La fecha de envío debe estar en el futuro")
    @Column(nullable = false)
    private LocalDateTime scheduledTime;
}
