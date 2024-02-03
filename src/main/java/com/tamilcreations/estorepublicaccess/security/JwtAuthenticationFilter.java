package com.tamilcreations.estorepublicaccess.security;

import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import com.tamilcreations.estorepublicaccess.users.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.http.HttpServletRequest;

public class JwtAuthenticationFilter {

    private static final String SECRET_KEY = "abc";
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds
    private static final SecretKey key = Jwts.SIG.HS256.key().build();
    
    public static String generateToken(String subject, List<String> role, String uuid) {
    
//    	 String secretKeyString = "9629006706";
//
//         // Convert the string secret key to a byte array
//         byte[] secretKeyBytes = secretKeyString.getBytes();
//
//         // Create a SecretKey instance using SecretKeySpec
//         SecretKey secretKey = new SecretKeySpec(secretKeyBytes, "HmacSHA256");

    	
        String token =  Jwts.builder()
        		.claim("role", role)
        		.claim("uuid", uuid)
                .subject(subject)
               
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
        
    	System.out.println("Generated Token in Public Service:"+token);
    	return token;
    }
    
    public static User validateToken(String jwtToken) throws Exception {
    	 try {
    	     Jws<Claims> claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(jwtToken);
    	     String uuid = claims.getPayload().get("uuid").toString();
    	     String phoneNumber = claims.getPayload().getSubject();
    	     String role = claims.getPayload().get("role").toString();
    	    		 
    	    		 //getPayload().get("role").toString();
    	     
    	     User user  = new User();
    	     user.setUuid(uuid);
    	     user.setPhoneNumber(phoneNumber);
    	     user.setRole(role);
    	     
             return user;
         } catch (SignatureException | MalformedJwtException e) {
             // Token signature or format is invalid
             throw new Exception("Invalid token");
         }
    }
    
    public static String getSubjectFromToken(String jwtToken) {
    	Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(jwtToken).getPayload();
    	return claims.getSubject();
    	
    }
    
    public static User getAuthorizationHeaderValueAndValidate(HttpServletRequest request) throws Exception
    {
    String authorizationHeader = request.getHeader("Authorization");
	 System.out.println("authorizationHeader: "+authorizationHeader);
       if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
           String jwtToken = authorizationHeader.substring(7); // Skip "Bearer " prefix

           User user = JwtAuthenticationFilter.validateToken(jwtToken);
           return user;
       }
       else
       {
       	throw new Exception("Please login to perform this action.");
       }
    }
}
