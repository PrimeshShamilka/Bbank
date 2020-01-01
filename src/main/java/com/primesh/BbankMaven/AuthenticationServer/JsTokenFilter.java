package com.primesh.BbankMaven.AuthenticationServer;
import javax.annotation.Priority;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import response.BaseResponse;
import util.JwTokenHelper;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
	

@Provider   
@JsonTokenNeeded   
@Priority(Priorities.AUTHENTICATION) 
public class JsTokenFilter implements ContainerRequestFilter {
   
   private static final String AUTHORIZATION_SERVICE_PATH = "authenticationserver";  
   private static final String PRIVATE_KEY = "privateKey";   
   private JwTokenHelper jwTokenHelper = JwTokenHelper.getInstance();
   
   @Override
    public void filter(ContainerRequestContext request) {  	    
	    // Get the Authorization header from the request
	    String privateKeyHeaderValue = request.getHeaderString(PRIVATE_KEY);
	    System.out.println(privateKeyHeaderValue);
        
	     // Validate the Authorization header
        if (privateKeyHeaderValue == null || privateKeyHeaderValue.isEmpty()) 
        {
            throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is missing in header"));          
        }
        try 
        {
        	//validate the key
             jwTokenHelper.claimKey(privateKeyHeaderValue);   
        } catch(Exception e) 
        {
            if (e instanceof ExpiredJwtException) 
            {
                throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is expired"));
            } else if (e instanceof MalformedJwtException) 
            {
                throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is not correct"));
            }
        }
        
   }
   
    private Response getUnAuthorizeResponse(String message) {
       return Response.ok(BaseResponse.FAILURE, message).status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).build();
    }
    
    
}
