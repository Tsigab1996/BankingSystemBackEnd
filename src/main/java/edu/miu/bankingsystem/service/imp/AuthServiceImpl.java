package edu.miu.bankingsystem.service.imp;


import edu.miu.bankingsystem.domain.dto.request.LoginRequest;
import edu.miu.bankingsystem.domain.dto.request.RefreshTokenRequest;
import edu.miu.bankingsystem.domain.dto.response.LoginResponse;
import edu.miu.bankingsystem.service.AuthService;
import edu.miu.bankingsystem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
       var role= userDetails.getAuthorities();

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken, role.stream().map(a->a.getAuthority()).collect(Collectors.toList()));
        return loginResponse;
    }

  //  @Override
//    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
//        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
//        if (isRefreshTokenValid) {
//            // TODO (check the expiration of the accessToken when request sent, if the is recent according to
//            //  issue Date, then accept the renewal)
//            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
//            if(isAccessTokenExpired)
//                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
//            else
//                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
//            var sth= userDetails.getAuthorities();
//            final String accessToken = jwtUtil.doGenerateToken(  jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
//            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken(), sth.stream().map(a->a.getAuthority()).collect(Collectors.toList()));
//            // TODO (OPTIONAL) When to renew the refresh token?
//            return loginResponse;
//        }
//        return new LoginResponse();
//    }
}
