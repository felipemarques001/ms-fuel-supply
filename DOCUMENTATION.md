# Available methods in the API:
**OBS: As this API is not in production, the domain of the URLS that are being shown below is as "domain_name", if this API is for production level, I will change these images to put the URLS with the production domain .**
## 1 - USER entity methods:

### 1.1 - Create (POST) a User:

#### 1.1.1 - Request URL:
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/b6d32739-049c-4bc9-98d1-4b57a83f193e)


#### 1.1.2 - Request body: The body request is of JSON type, below there is an example it. Also, to create a new user, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify the permissions of user. <br />
The idsGroups represents the groups which the new user will have. These ID's are at database of ms-authentication.
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/cf001bd9-3dd4-4bd0-b785-771066abc095)


#### 1.1.3 - Response: The response has the 201 status and its body contains the JWT Token of the new user: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/e97e4bd1-bd32-439f-af90-fb8e78de5896)


If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)



### 1.2 - LOGIN User:

#### 1.2.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/2e1af6e1-9bc8-4328-a860-50956ce0b712)

#### 1.2.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/47578d7e-5ef1-44a4-bf05-ca3cfe7b973d)

#### 1.2.3 - Response: The response has the 200 status and its body contains the JWT Token of the new user: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/9aa17690-4b9b-4095-893a-bf425aae9bbc)

If there is an invalid credential, you will receive a response with the 401 status and empty body. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/6187aeb3-9464-49e1-9d23-e0065aa285f8)

<br />

## 2 - VEHICLE entity methods:
