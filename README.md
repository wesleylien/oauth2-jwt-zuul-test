# oauth2-jwt-zuul-test
POST: localhost:5000/oauth/token    
RETURN:    
JWT(password):   
```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyMSAiOnsicGFzc3dvcmQiOm51bGwsInVzZXJuYW1lIjoidXNlcl8xIiwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9XSwiYWNjb3VudE5vbkV4cGlyZWQiOnRydWUsImFjY291bnROb25Mb2NrZWQiOnRydWUsImNyZWRlbnRpYWxzTm9uRXhwaXJlZCI6dHJ1ZSwiZW5hYmxlZCI6dHJ1ZX0sInVzZXIyICI6eyJwYXNzd29yZCI6bnVsbCwidXNlcm5hbWUiOiJ1c2VyXzEiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJhY2NvdW50Tm9uRXhwaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiY3JlZGVudGlhbHNOb25FeHBpcmVkIjp0cnVlLCJlbmFibGVkIjp0cnVlfSwidGVzdCI6ImhhaGFoYSIsInVzZXJfbmFtZSI6InVzZXJfMSIsInNjb3BlIjpbInNjb3BlXzEiXSwiZXhwIjoxNTI2MzUxMzQzLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiZGQ4MDYxMTYtZTBjMi00NzM5LWI5OTktNTE2MTg2NzVkMWIzIiwiY2xpZW50X2lkIjoiY2xpZW50XzEifQ.g7pBdsL6lgvs_Dr5K6YLGF4qdiKSFcckefwnZJi2AzNMuAConPQjWVnyZPlr76PD6YsHfnmd6RXOU2l4f9QkwY0Y_X_31kUVlfx9W2YEe4RXkFblR2ZjJk_M1Gk09vWtxmGHm8lLpSTeJyEpZNZeqdgk-aGFEtKd2ArgSKU7dPTsYMNb3FQslApP0llqCdnOnnEflmxOPR_wSMZZjFCWgwEPukVHmKZDexFi2X013gGeqJP_Ds32h-cZluSSeBgqTt1w7lVOf9rW42xBZfDLRhjHKocgdLp1-70azb-TKgnEcIX74RiE6CDSox2iQF-R7440iNmjsgbfXoHnlKBHCA",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "scope_1",
    "user1 ": {
        "password": null,
        "username": "user_1",
        "authorities": [
            {
                "authority": "ROLE_USER"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    },
    "user2 ": {
        "password": null,
        "username": "user_1",
        "authorities": [
            {
                "authority": "ROLE_USER"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    },
    "test": "hahaha",
    "jti": "dd806116-e0c2-4739-b999-51618675d1b3"
}
```
```
{
  "user1 ": {
    "password": null,
    "username": "user_1",
    "authorities": [
      {
        "authority": "ROLE_USER"
      }
    ],
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true,
    "enabled": true
  },
  "user2 ": {
    "password": null,
    "username": "user_1",
    "authorities": [
      {
        "authority": "ROLE_USER"
      }
    ],
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true,
    "enabled": true
  },
  "test": "hahaha",
  "user_name": "user_1",
  "scope": [
    "scope_1"
  ],
  "exp": 1526351343,
  "authorities": [
    "ROLE_USER"
  ],
  "jti": "dd806116-e0c2-4739-b999-51618675d1b3",
  "client_id": "client_1"
}
```
JWT(client_credentials):
```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZXN0IjoiaGFoYWhhIiwic2NvcGUiOlsic2NvcGVfMiJdLCJleHAiOjE1MjYzNTExMzYsImF1dGhvcml0aWVzIjpbIndyaXRlIiwicmVhZCJdLCJqdGkiOiJhMDkxZTE1NC1jZWI0LTRiNDctODZiMi02ZWQ0MWRjNmE2YWIiLCJjbGllbnRfaWQiOiJjbGllbnRfMiJ9.LUsnv4FAPHtpRcQ-EnXNaerE6T-U45xcBuFzpQErwNsk0jFkt76K0ug4nF2-y0CgCXwdRlddFd9DNCHECRZBMWnRhOBZsSaZtCHueGVp89NIZbGGMauvNDbZqTfMLuzXYgsjYV4Y11t5GD7U3DYo0VaKqHi0-0G9OZoIpkm2SPIuNqojdGpsSTboG2cSsZMHBdL4alz633Au1NAeCZvUM-Ml8k2vA7ZZnFhhqpYUS0_kjYqPuSuWFpW4EQ99HiH0FQtrGdgDdxn1d1ZKaYxsQAnJCnPiTofWr-1nJwNX7epbxJmt7GkfBQYeIc-CyW-uAjzgp8abbwLu3RApC58QYA",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "scope_2",
    "test": "hahaha",
    "jti": "a091e154-ceb4-4b47-86b2-6ed41dc6a6ab"
}
```
```
{
  "test": "hahaha",
  "scope": [
    "scope_2"
  ],
  "exp": 1526351136,
  "authorities": [
    "write",
    "read"
  ],
  "jti": "a091e154-ceb4-4b47-86b2-6ed41dc6a6ab",
  "client_id": "client_2"
}
```

https://github.com/spring-cloud/spring-cloud-security/blob/master/spring-cloud-security/src/main/java/org/springframework/cloud/security/oauth2/proxy/OAuth2TokenRelayFilter.java

https://stackoverflow.com/questions/40936900/how-to-trigger-oauth2-authentication-in-zuul-api-gateway-if-a-downstream-service?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
