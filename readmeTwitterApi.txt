

Data to get USER ID
   
	USER_NAME        USER_ID                       CLIENT_ID
1	John Doe	     john_doe123	               D02000
2	Jane Smith	     jane_smith456	               D02001
3	Bob Johnson	     bob_johnson789	               D02002
4	Alice Brown	     alice_brown101			       D02003
5	Charlie Davis	 charlie_davis202	           D02005
6	Eva White	     eva_white303	               D02006
7	Samuel Green	 samuel_green404    	       D02007
8	Olivia Black	 olivia_black505	           D02008
9	William Grey	  william_grey606	           D02009
10	Sophia Red	    sophia_red707	               D02010



Data For Headers

  CLIENT_ID  CLIENT_NAME   CLIENT_SECRET
1	D02001	IBOOK	    ibooksecret
2	D02002  CTMWS	    ctmwssecret
3	D02003	TCIL	    tcilsecret
4	D02004	SOTC	    sotcsecret
5	D02005	TATA SONS	tatasonssecret
6	D02006	RELIANCE	reliancesecret
7	D02007	DICE	    dicesecret
8	D02008	CANVAS	    scanvasecret
9	D02009	ORACLE	    oraclesecret
10	D020010	TATA AIA	tataaiasecret
			
			
			URl to get USER_ID : http://localhost:8080/api/searchUser
			request : {
                        "userName" : "John Doe"

                      }
					  
			URl to get Tweets : http://localhost:8080/api/getTweets		  
					  
			request : {
                       "userId" : "john_doe123"

                       }
			
					  
					  
					  