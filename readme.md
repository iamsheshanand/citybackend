# City Letter Counter

## Project Structure

- **Backend** Spring Boot Java 17 with REST API to count cities by starting letter.
- **API** The API it uses `https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22`

# Prerequisites
- Java 17
- Maven for build
  https://github.com/iamsheshanand/java-8.git

# Backend
1. Clone https://github.com/iamsheshanand/citybackend.git

```
   cd citybackend
   
   mvn clean install 
   
   mvn spring-boot:run

```

Once it starts successfully navigate to http://localhost:8080
