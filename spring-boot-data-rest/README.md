# Spring Boot Data Rest

Sample application featuring Spring Boot Data Rest.

Table of contents:
* [Test the application](#test-the-application)
* [Run the application](#run-the-application)
* [Create new entry](#create-new-entry)
* [Search entries](#search-entries)
* [References](#references)

## Test the application

Type the following command to run the tests.

```
mvn test
```

## Run the application 

In order to launch the application just type:
```
mvn spring-boot:run 
```

Access the `user` resource and search URL's on the links below: 

* http://localhost:8080/users
* http://localhost:8080/users/search

## Create new entry
```
curl -X POST -i -H "Content-Type:application/json" -d '{"name":"Kirk Hammett", "age": 57}' http://localhost:8080/users
```

## Search entries

* http://localhost:8080/users/search/findAllByNameIn?names=Muhammed,Suiçmez


# References

* https://github.com/spring-projects/spring-data-examples