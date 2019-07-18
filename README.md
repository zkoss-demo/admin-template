# Overview

This project integrates with the following 3rd party frameworks/resources:
* [Bootstrap 4.3.1](https://getbootstrap.com/)
* [Font Awesome·4.7.0.](https://fontawesome.com/v4.7.0/icons/): bundled with ZK framework (since 8.5.2)

It includes above client-side libraries with [Webjars](https://www.webjars.org/).


# How to Run
## No Maven installed
You can run the project with maven wrapper by the command below (it will automatically download required maven):

### Linux/Mac
`./mvnw jetty:run`
### Windows
`mvnw jetty:run`

## Maven installed
With the command below:

`mvn jetty:run`

After the jetty started
visit [http://localhost:8080](http://localhost:8080)

# Layout Guide

* sidebar fixed width
* container includes sidebar

# Browser compatibility
* Chrome 49
* Edge 15
* Firefox 31
* Opera 36
* Safari
* All mobile browsers