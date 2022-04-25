# Superdevs

## Enviroment
I wrote an program using Java 17. API was created with Spring Boot 3.0. Database is basen on H2 database.
To retrieve csv data I used Common CSV 1.8.

## Launching
To activate application you need import it to IntelliJ as a Maven project, set proper SDK,
clear port 9090 and run SuperdevsApplication, it should start an Spring boot application on localhost:9090.
I tested my application using Postman. This tool enables to send requests to the API and receive response.
Every endpoint is described in exported json file Superdevs.postman_collection.json that is in GitHub.
It represens whole Postman Collection.

## TEST
In file com.warehouse.superdevs.MarketEntranceRepositoryTests I create some Junit tests.

## Web app
I deployed app to heroku. It can be accessed by the URL: https://superdevs.herokuapp.com


### Things that I am not proud of:
During creation of this project I encountered a problem with quering database and getting as a result an custom object.
It would be especially useful with aggregate functions where output data must to be stored in an object. 
Even though I did everything like in a guide: https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
I was keeping errors about invalid SQL syntax. To solve this problem I store every output of aggregate function query in
class of type Object and after I retrieve it I manipulate its data.\
Unfournately I did not create an docker image of my app because of lack of time.

### Things that are valuable to run application:
When I was testing endpoint for the highest Click data I encountered an error with query string parsing.
Even though Postman is very inteligent tool it does not put correctly special characters into query string. For ecample:\
When I want to type 'RM|CSP Gadgets' for the character '|' I need to use ASCII value so the final result would be:\
'RM%7CSP Gadgets'