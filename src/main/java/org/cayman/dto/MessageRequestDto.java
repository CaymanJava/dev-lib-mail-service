package org.cayman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDto {
    private int userId;
    private String email;
    private String message;
}
