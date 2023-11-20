package com.twitter.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.api.dto.TwitterDto;
import com.twitter.api.dto.UserIdDto;
import com.twitter.api.repo.TwitterRepo;

@Service
public class TwitterServiceImpl implements TwitterService{

	@Autowired
	TwitterRepo repo;
	public Map<String, String> getUserId( TwitterDto twitterDto) 
	{
		String userId;
		Map<String, String> user = new HashMap<>();

		try 
		{
			userId = repo.getUserIdByUserName(twitterDto.getUserName());
			
			if(userId!=null)
				user.put("userId", userId);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return user;
		}
		
		return user;
	}
	
	public String getTweets(UserIdDto userIdDto) 
	{
        List<String> tweetList = new ArrayList<>();
        Map<String, List<String>> tweetsByUser = new HashMap<>();
        List<String> tweetMaps = new ArrayList<>();
        List<String> tweetMap =new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse ="";
        try 
        {
            tweetList = repo.getTweetsByUserId(userIdDto.getUserId());
            tweetList.forEach(s -> System.out.println(s));
            if (!tweetList.isEmpty()) 
            {
                for (String tweet : tweetList) 
                    tweetMap.add(tweet);
                
                
              tweetMaps.addAll(tweetMap);
              tweetsByUser.put(userIdDto.getUserId(), tweetMaps);
              jsonResponse  = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tweetsByUser);
            }
        }
		catch (Exception e) 
		{
			e.printStackTrace();
			return jsonResponse;
		}
		
		return jsonResponse;
	}
	
	

}
