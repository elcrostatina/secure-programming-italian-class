package com.example.test.user.application.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class JwtService {
    private static final String SECRET_KEY = "MY_SUPER_SECRET_UNSAFE_KEY";

    public static DecodedJWT validateAndReadJwt(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
            return verifier.verify(token);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}