# yostocks_auth
## Application selling fractions of stocks.

### Microservice responsible for sign up, sign in, JWT token issuing and validation.
### Build with implementation of Netflix's Zuul Gateway.
### Utilizing Eureka Discovery Server this gateway routes messages to the right receiver,
### based on microservice name not particular service address. This approach facilitates scalability if needed.
### Additionaly Zuul Gateway acts as a filter and/or load balancer.
