package com.revature.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    private static final String secret ="super secret string noone else should ever have";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    // put in the parameters that you want to be in the body of your jwt,
    public static String generate(String USER_FIRST_NAME, String USER_LAST_NAME, int USER_ROLE_ID){

        // builder design pattern
        String token = JWT.create()
                .withClaim("USER_FIRST_NAME", USER_FIRST_NAME) // add data to the payload
                .withClaim("USER_LAST_NAME", USER_LAST_NAME)
                .withClaim("USER_ROLE_ID", USER_ROLE_ID)
                .sign(algorithm); // this will generate a signature based off of those claims

        return  token;
    }

    public static DecodedJWT isValidJWT(String token){
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            return  jwt;
    }
}
