package com.primesh.BbankMaven.AuthenticationServer;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import response.AuthorizationResponse;
import response.BaseResponse;
import util.JwTokenHelper;

@Path("authenticationserver")
public class AuthenticationServer {
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authorizationService(@FormParam("username") String userName, @FormParam("password") String password) {
        try {
            // Authenticate the user using the credentials provided
            authenticate(userName, password);

            // Issue a token for the user
            String token = issueToken(userName,password);

            // Return the token on the response
            return Response.ok(token).build();
            
//            return getResponse(new AuthorizationResponse(BaseResponse.SUCCESS, "You're authenticated successfully. Private key will be valid for 30 mins", privateKey));


        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        } 
        
        
    }
    
    private void authenticate(String userName, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    	
    }

    private String issueToken(String userName,String password) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
    	String privateKey = JwTokenHelper.getInstance().generatePrivateKey(userName, password);
    	return privateKey;
    }
}

