package org.cayman.messages.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

    @Column(name = "ip")
    private String ip;

    @Column(name = "send_date_time")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime sendDateTime;

    @Column(name = "new_one")
    private boolean newOne;
}
