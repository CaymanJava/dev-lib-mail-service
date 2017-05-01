package org.cayman.messages.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;

    @Column(name = "send_date_time")
    private LocalDateTime sendDateTime;

    @Column(name = "new_one")
    private boolean newOne;
}
