package com.example.authms.dto;
/**
 * GLOBAL parameters used in our authentication system
 * */
public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="ayoubmoumou@ayoubmoumou.net";
    public static final long EXPIRATION=10*24*3600*1000;
    public static final String HEADER_PREFIX="Bearer ";
}
