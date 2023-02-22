package edu.miu.bankingsystem.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private List<String> roles;
}
