package com.twitter.api.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twitter.api.entity.Twitter;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface TwitterRepo extends JpaRepository<Twitter, Long>
{
	@Query(value = "SELECT U.USER_ID FROM user_details U WHERE U.USER_NAME = :userName",nativeQuery = true)
    public String getUserIdByUserName(@Param("userName") String userName);
	
	@Query(value = "SELECT T.TWEET FROM tweets T WHERE T.USER_ID = :userId",nativeQuery = true)
    public List<String> getTweetsByUserId(@Param("userId") String userId);

	@Query(value = "SELECT * FROM client_details C WHERE C.CLIENT_ID = :clientId",nativeQuery = true)
    public Map<String,String> getClientId(@Param("clientId") String clientId);
	
	

}
