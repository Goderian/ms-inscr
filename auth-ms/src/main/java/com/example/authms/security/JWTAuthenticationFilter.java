package com.example.authms.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.authms.dto.SecurityParams;
import com.example.authms.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User authentication with his credentials and JWT
 * creation using the users' information
 * */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    /*Authenticates the user by his credentials*/
    private AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    /**
     * Called du to an authentication attempt
     * Retrieving username and password from request
     * and sending the information to spring security
     * throws an error if the content of the request is invalid
     * */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
//            System.out.println(request.getInputStream());
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            System.out.println(user);
            System.out.println(new UsernamePasswordAuthenticationToken(user.getUsername(),
                    user.getPassword()));
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user1.getUsername(),
                            user1.getPassword()));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    /**
     * Called if attemptAuthentication executed successfully
     * and creats a JWT and send it back withing the response as a
     * value of Authorization header
     * */

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        System.out.println(user);
        List<String> roles = new ArrayList<>();
        user.getAuthorities().forEach(grantedAuthority -> {
            roles.add(grantedAuthority.getAuthority());
        });
        String jwt = JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                .sign(Algorithm.HMAC256(SecurityParams.SECRET));
        response.addHeader(SecurityParams.JWT_HEADER_NAME, jwt);
        System.out.println("ss "+jwt);
    }
}
