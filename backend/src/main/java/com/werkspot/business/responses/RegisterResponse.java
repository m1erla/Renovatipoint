package com.werkspot.business.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterResponse {

    String message;
    int userId;
    String email;
}