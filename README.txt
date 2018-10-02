Rest API interface using Jersey , done by Poonam  Agarwal.


It uses:
1. jersey 2.27 API to expose the rest interface. 
2. maven to build
3. junit for some unit tests
4. JAX-RS
5. Used Eclipse for development
6. log4j for logging messages


How to build:
1. Download or get the whole WebRest project 
2. mvn install will build the War file and run the tests.
3. Deploy the RestAPI.war from target folder in a web container. E.g. Tomcat


--------------------------------------
Testing
--------------------------------------

The tests are very basic and use Jersey Tests  framework which provides a HttpServer in build. This helped to develop quick unit tests.

