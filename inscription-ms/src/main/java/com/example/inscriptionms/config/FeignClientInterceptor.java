package com.example.inscriptionms.config;

import com.example.inscriptionms.dto.SecurityParams;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpHeaders;
import java.util.Objects;

@Component
@Slf4j
public class FeignClientInterceptor implements RequestInterceptor {


    private final static String AUTHORIZATION_HEADER = "Authorization";
    private final static String TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate requestTemplate) {

        HttpServletRequest request = ( (ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        log.info(request.getHeader(SecurityParams.JWT_HEADER_NAME));
        String jwt = request.getHeader(SecurityParams.JWT_HEADER_NAME);
        requestTemplate.header(SecurityParams.JWT_HEADER_NAME, jwt);

    }
}
