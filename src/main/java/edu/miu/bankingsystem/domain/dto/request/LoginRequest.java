package edu.miu.bankingsystem.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class LoginRequest {
    private String email;
    private String password;
}
