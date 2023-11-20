package com.twitter.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.authentication.HeaderAuthentication;
import com.twitter.api.dto.TwitterDto;
import com.twitter.api.dto.UserIdDto;
import com.twitter.api.service.TwitterService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class TwitterController 
{
	@Autowired
	TwitterService service;
	
	@Autowired
	HeaderAuthentication headerAuthentication;
	
	
	
	
	@PostMapping(value = {"/searchUser"} , produces = "application/json")
	public  ResponseEntity<Object> searchUser ( HttpServletRequest request,@RequestBody TwitterDto twitterDto)
	{
		Map<String, String> userId = new HashMap<>();
		try 
		{
			userId = service.getUserId(twitterDto);
			if(!userId.isEmpty())
				return ResponseEntity.ok(userId);
			
			else
				return ResponseEntity.badRequest().body("'"+twitterDto.getUserName()+"' is a invalid userName. Please provide a valid userName.");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send userName. Please try again.");
		}
	}
	
	
	
	@PostMapping(value = {"/getTweets"} , produces = "application/json")
	public  ResponseEntity<String> getTweets ( HttpServletRequest request, @RequestHeader Map<String, String> headers , @RequestBody UserIdDto userIdDto)
	{
		 String tweets="" ;
		 boolean headerValidate;
		try 
		{
			headerValidate =  headerAuthentication.validateHeader(request,headers);
			if(headerValidate)
			{
				tweets = service.getTweets(userIdDto);
				if(!tweets.isBlank())
					return ResponseEntity.ok(tweets);
				
				else
					return ResponseEntity.badRequest().body("'"+userIdDto.getUserId()+"' is a invalid userId. Please provide a valid userId.");
			}
			else
				return ResponseEntity.badRequest().body("Invalid Client Details.");
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(500).body("Failed to send userId. Please try again.");
		}
		    
	}

}
