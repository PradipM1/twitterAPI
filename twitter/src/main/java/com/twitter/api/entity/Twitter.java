package com.twitter.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_DETAILS",uniqueConstraints = @UniqueConstraint(columnNames = "USER_ID"))
public class Twitter {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
	
	@Column(name = "USER_ID")
	String userId;
	
	@Column(name = "USER_NAME")
	String userName;
	
	@Column(name = "CLIENT_ID")
	String clientId;
	

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	
	   

	
}
