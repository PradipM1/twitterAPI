package com.twitter.api.service;

import java.util.Map;

import com.twitter.api.dto.TwitterDto;
import com.twitter.api.dto.UserIdDto;

public interface TwitterService {
	
	public Map<String, String> getUserId( TwitterDto twitterDto);
	public String getTweets( UserIdDto userIdDto);

}
