# Available methods in the API:
**OBS: As this API is not in production, the domain of the URLS that are being shown below is as "domain_name", if this API is for production level, I will change these images to put the URLS with the production domain .**
## 1 - USER entity methods:

### 1.1 - Create (POST) a User:

#### 1.1.1 - Request URL:
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/b6d32739-049c-4bc9-98d1-4b57a83f193e)

#### 1.1.2 - Request body: The body request is of JSON type, below there is an example it. Also, to create a new user, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify the permissions of user. <br />
The groupIds field represents the groups which the new user will have. These ID's are at database of ms-authentication.
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bf6ed4f6-7d24-48c7-b7e7-91b1f33ac0c3)


#### 1.1.3 - Response: The response has the 201 status and its body contains the JWT Token of the new user: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/67648e66-be41-4bb1-8582-1582e3695ae5)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: 
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/fa908571-7981-408d-8590-d2c670a9f2b2)


### 1.2 - LOGIN User:

#### 1.2.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/2e1af6e1-9bc8-4328-a860-50956ce0b712)

#### 1.2.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/87da27d6-9f32-497e-985d-b8241861cf0e)

#### 1.2.3 - Response: The response has the 200 status and its body contains the JWT Token of the new user: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/e7ed4f12-54b4-4a86-b3c4-e2ae1044fbfb)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the token belongs to a non-administrator user, you will receive a response with 401 status.
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: 
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/355b9ffa-15c2-4d53-8117-ea8cd02d0017)

<br />


## 2 - VEHICLE entity methods:

#### 2.1 - Create (POST) Vehicle:  

#### 2.1.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/6352bca8-c446-4c85-9bbb-8f9f6aa800f6)

#### 2.1.2 - Request body: The body request is of JSON type, below there is an example it. Also, to create a new vehicle, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to create a vehicle. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/36612c43-e17d-4dcb-98d4-9017660f5e9f)

#### 2.1.3 - Response: If all goes well, you will receive a response like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd8e541d-2ba5-4a06-8d77-d888c3eb4feb)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the token belongs to a non-administrator user, you will receive a response with 401 status.

- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: 
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/1f693286-8cd0-4ea8-92ea-56f604917ed6)


#### 2.2 - READ (GET) All Vehicles:

#### 2.2.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/6352bca8-c446-4c85-9bbb-8f9f6aa800f6)

#### 2.2.2: - Request body: This request does not requires a body, but to call it, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to read all vehicles. Any authenticated user can call this method. <br />

#### 2.1.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/2543de9e-cf3b-4d07-aecd-3647f74ec776)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)


#### 2.3 - READ (GET) One Vehicle:

#### 2.3.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/e2438e5a-004b-4980-a384-7e9b80a04092)

#### 2.3.2: - Request body: This request does not requires a body, you will need only pass the vehicle ID at URI. But to call it, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to read a vehicle. Any authenticated user can call this method. <br />

#### 2.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/0579d376-8b75-4768-a94c-f934fde7518e)

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

- If the ID is not associated with any vehicle. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/053df17c-c3c3-4479-ad7f-88b7d407ffef)


#### 2.4 - UPDATE (PUT) Vehicle:

#### 2.4.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/5767ab29-d7a3-467a-b9d1-dfbdceeba847)

#### 2.4.2 - Request body: The body request is of JSON type, below there is an example it. Also, to update a vehicle, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to update a vehicle. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/ba26361c-b5f4-4065-ac19-35dc699ef7eb)

#### 2.4.3 - Response: If all goes well, you will receive a response like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/39a76493-636b-4571-86e1-78ca4249aeb5)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the token belongs to a non-administrator user, you will receive a response with 401 status.

- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/1f693286-8cd0-4ea8-92ea-56f604917ed6)

- If the ID is not associated with any vehicle. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/053df17c-c3c3-4479-ad7f-88b7d407ffef)


#### 2.5 - DELETE (DEL) Vehicle:

#### 2.5.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/7b423b78-5314-486d-aafb-0fa5356f5b21)

#### 2.5.2: - Request body: This request does not requires a body, you will need only pass the vehicle ID at URI. Also, to delete a vehicle, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to delete a vehicle. <br />

#### 2.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

- If the ID is not associated with any vehicle. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/053df17c-c3c3-4479-ad7f-88b7d407ffef)



## 3 - GAS STATION entity methods:

#### 3.1 - Create (POST) Gas Station:  

#### 3.1.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/c419a123-a40b-4cf6-9ce6-791accaae20c)

#### 3.1.2 - Request body: The body request is of JSON type, below there is an example it. Also, to create a new gas station, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to create a gas station. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/099d8a9a-11dd-4d15-886d-e4655676bcca)

#### 3.1.3 - Response: If all goes well, you will receive a response with 201 status and a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/f9eb841c-bec0-4465-9bd3-d41c5f82a6fe)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the token belongs to a non-administrator user, you will receive a response with 401 status.

- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/da358f0f-5d04-4e86-898e-63de9d35ac57)


#### 3.2 - READ (GET) All Gas Stations:

#### 3.2.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/b85587da-1567-4f80-89e3-13b8f27ef1e3)

#### 3.2.2: - Request body: This request does not requires a body, but to call it, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to read all gas stations. Any authenticated user can call this method. <br />

#### 3.2.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/2402fd56-0d33-4e17-8024-305a9de8b5d1)

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)


#### 3.3 - READ (GET) One Gas Station:

#### 3.3.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/5a0defa0-771e-4d8f-ac1c-8d6c7fa78542)

#### 3.3.2: - Request body: This request does not requires a body, you will need only pass the gas station ID at URI. But to call it, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to read a gas station. Any authenticated user can call this method. <br />

#### 3.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/de07d97c-0ab4-42b0-a2b4-4cad3da94b34)

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

- If the ID is not associated with any gas station. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3940f0e4-a1f4-436a-85b5-457725e4ba31)


#### 3.4 - UPDATE (PUT) Gas Station:

#### 3.4.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/b863152a-66a4-42f1-8a8c-31055924f798)

#### 3.4.2 - Request body: The body request is of JSON type, below there is an example it. Also, to update a gas station, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to update a gas station. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/0fb4a742-3943-403f-8ca3-24bc462debc6)

#### 3.4.3 - Response: If all goes well, you will receive a response like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3ba37381-a055-4db1-9e0b-04fc9e0bbca5)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the token belongs to a non-administrator user, you will receive a response with 401 status.

- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3940f0e4-a1f4-436a-85b5-457725e4ba31)

- If the user sent invalid values, he will receive a response with 400 status. Example: 
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/da358f0f-5d04-4e86-898e-63de9d35ac57)


#### 3.5 - DELETE (DEL) Gas Station:

#### 3.5.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3bdf33f9-079a-4be5-80ba-c65a67fc52f0)

#### 3.5.2: - Request body: This request does not requires a body, you will need only pass the gas station ID at URI. Also, to delete a gas station, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to delete a gas station. <br />

#### 3.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

- If the ID is not associated with any gas station. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3940f0e4-a1f4-436a-85b5-457725e4ba31)



## 4 - SUPPLY entity methods:

#### 4.1 - Create (POST) Supply:  

#### 4.1.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/5f510dce-c0b8-4cc6-ab2d-a589c1fb5a75)

#### 4.1.2 - Request body: The body request is of JSON type, below there is an example it. Any authenticated user can call this method. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to create a supplie. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/9c632098-3d62-44d6-99f4-ab0042aa0286)

#### 4.1.3 - Response: If all goes well, you will receive a response with 201 status and a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/8f515115-53cf-4d10-997b-8ba49489aa9f)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Examples: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/5ec06417-956e-4803-8afb-18dd2ba2cf08)
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/2ce44fbe-bb9a-448e-8e6e-6a0e6e705908)


#### 4.2 - READ (GET) All Supplies:

#### 4.2.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/45343b81-0f48-43da-aaac-67ea30e98d5f)

#### 4.2.2: - Request body: This request does not requires a body, but to call it, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to get all supplies. Any authenticated user can call this method. <br />

#### 4.2.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/b2998e7f-8d14-499a-8b6a-f80b9c2b9567)

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)


#### 4.3 - READ (GET) One Gas Station:

#### 4.3.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3c6bf8dd-6c0b-4b70-8053-608654504435)

#### 4.3.2: - Request body: This request does not requires a body, you will need only pass the supply ID at URI. But to call it, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to get a supply. Any authenticated user can call this method. <br />

#### 4.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/3c7dbc20-7994-40c8-8f53-f90df2613228)

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

- If the ID is not associated with any supply. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/5de1fe35-1c22-4960-b53b-feec884afae4)


#### 4.4 - UPDATE (PUT) Supply:

#### 4.4.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/dea4ab8c-d330-45e1-b8d2-879d62515df5)

#### 4.4.2 - Request body: The body request is of JSON type, below there is an example it. Also, to update a supply, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to update a supply. <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/009c929d-15ec-4b57-abb9-dc1ad44d574d)

#### 4.4.3 - Response: If all goes well, you will receive a response like this: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/7329fb29-9c31-468b-9847-0a99194ac957)

If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

#### Warnings:
- If the token belongs to a non-administrator user, you will receive a response with 401 status.

- If the ID is not associated with any supply. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/4283b66d-0477-4b8e-86b4-096bce90f8d8)

- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Examples: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/5ec06417-956e-4803-8afb-18dd2ba2cf08)
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/2ce44fbe-bb9a-448e-8e6e-6a0e6e705908)



#### 4.5 - DELETE (DEL) Gas Station:

#### 4.5.1 - Request URL: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/fddbd352-2fff-4d82-85b1-6a9b8cec0179)

#### 4.5.2: - Request body: This request does not requires a body, you will need only pass the supply ID at URI. Also, to delete a supply, the user who calls method need be a admin. To call this method, a JWT token is necessary in order to ms-authenticate perform authenticatation and verify if the user has permission to delete a supply. <br />

#### 4.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the JWT token is not sent, you will receive the following response with the 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/bd1dd335-e9da-4477-9fb3-d7d68fd203d9)

- If the ID is not associated with any supply. You will receive the following response with 400 status: <br />
![image](https://github.com/felipemarques001/ms-fuel-supply/assets/82411791/4283b66d-0477-4b8e-86b4-096bce90f8d8)
