//package com.emi.gateway.security;
//
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class JWTAuthorizationFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        /*
//         * Adding headers to the response for CORS fixing and informing purposes
//         *
//         * */
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization");
//        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
//        response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH");
//        /*
//         * if it is an OPTIONS request the response is
//         * allowing different requests to be executed by the backend
//         * */
//        if (request.getMethod().equals("OPTIONS")) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//        /*Assures that the token is giving in the header
//        by other filters
//        * */
//        else if (request.getRequestURI().equals("/login")) {
//            filterChain.doFilter(request, response);
//            return;
//        } else {
//
//            String jwtToken = request.getHeader(SecurityParams.JWT_HEADER_NAME);
//            System.out.println("Token" + jwtToken);
//            if (jwtToken == null || !jwtToken.startsWith(SecurityParams.HEADER_PREFIX)) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//            /*
//             * Verification of the Token via SECRET
//             * */
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.SECRET)).build();
//            String jwt = jwtToken.substring(SecurityParams.HEADER_PREFIX.length());
//            DecodedJWT decodedJWT = verifier.verify(jwt);
//            System.out.println("JWT " + decodedJWT);
//            String username = decodedJWT.getSubject();
//            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
//            System.out.println("username " + username);
//            System.out.println("roles " + roles);
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//            roles.forEach(roleName -> {
//                authorities.add(new SimpleGrantedAuthority(roleName));
//            });
//
//            /*
//             * Authenticate the user and update Spring Security Context
//             * By adding users' information.
//             * */
//            UsernamePasswordAuthenticationToken userAuthentication =
//                    new UsernamePasswordAuthenticationToken(username, null, authorities);
//            SecurityContextHolder.getContext().setAuthentication(userAuthentication);
//            filterChain.doFilter(request, response);
////        System.out.println(SecurityContextHolder.getContext().getAuthentication()+"   ddd");
//
//        }
//    }
//
//}
//
