package edu.miu.bankingsystem.service;


import edu.miu.bankingsystem.domain.dto.request.LoginRequest;
import edu.miu.bankingsystem.domain.dto.request.RefreshTokenRequest;
import edu.miu.bankingsystem.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    //LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
