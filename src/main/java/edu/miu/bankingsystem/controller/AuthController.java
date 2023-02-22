package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domain.dto.request.LoginRequest;
import edu.miu.bankingsystem.domain.dto.request.RefreshTokenRequest;
import edu.miu.bankingsystem.domain.dto.response.LoginResponse;
import edu.miu.bankingsystem.service.AuthService;

import lombok.extern.java.Log;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin()
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

//    @PostMapping("/refreshToken")
//    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
//        return authService.refreshToken(refreshTokenRequest);
//    }

}
