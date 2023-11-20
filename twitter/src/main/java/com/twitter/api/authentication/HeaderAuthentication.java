package com.twitter.api.authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twitter.api.repo.TwitterRepo;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class HeaderAuthentication 
{

	@Autowired
	TwitterRepo repo;
	
	 final String[] predifinedHeaders = {
	            "content-type",
	            "user-agent",
	            "accept",
	            "postman-token",
	            "host",
	            "accept-encoding",
	            "connection",
	            "content-length"
	    };
	
	public boolean validateHeader(HttpServletRequest request,Map<String, String> headers)
	{
		String clientId ="",getClientId="",clientSecret="";
		boolean isValidate = false;
		Map<String,String> clientDetails  = new HashMap<>();
		try
		{
			 Map<String, String> customHeaders = headers.entrySet().stream()
		                .filter(entry -> !isPredefinedHeader(entry.getKey()))
		                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			 if (!customHeaders.isEmpty()) 
			 {
				    clientId = customHeaders.keySet().iterator().next();
				     clientDetails = repo.getClientId(clientId.toUpperCase());
				    if(clientDetails!=null && !clientDetails.isEmpty())
				    {
				    	 getClientId = clientDetails.get("CLIENT_ID").toString();
				    	 clientSecret = clientDetails.get("CLIENT_SECRET").toString();
				    	
				    	if(getClientId.equalsIgnoreCase(clientId) && (customHeaders.get(clientId)).equals(clientSecret))
				    			isValidate = true;
				    }
				    
				} 
			 return isValidate;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return isValidate;
	}
	
	 
	 private boolean isPredefinedHeader(String headerName) 
	 {
		 
	        for (String ignoredHeader : predifinedHeaders) {
	            if (ignoredHeader.equalsIgnoreCase(headerName)) {
	                return true;
	            }
	        }
	        return false;
	    }
}
