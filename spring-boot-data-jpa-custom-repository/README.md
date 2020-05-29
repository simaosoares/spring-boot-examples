# Spring Boot Data Jpa Custom Repository

Sample application featuring Spring Boot Data Jpa custom repositories.

Table of contents:
* [Test the application](#test-the-application)
* [Run the application](#run-the-application)
* [References](#references)

## Test the application

Type the following command to run the unit and the integration tests.

```
mvn verify
```

## Run the application 

In order to launch the application just type:
```
mvn spring-boot:run 
```

Access the `user` resource and the custom repository search URL's on the links below: 

* http://localhost:8080/user
* http://localhost:8080/user/findAllDistinctNames

# References

* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.custom-implementations