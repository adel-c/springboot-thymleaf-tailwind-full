Sample for a spring boot app with a frontend in thymleaf + tailwind

WIP DOC

## Dependencies:
- Java
- Maven
- Docker (to use tailwind)

## Todo:
- add a sample crud
- add liquibase *
- add mapstruct?
- add a pg client
- handle uid and guid *


## Usage

Start the app form ThymleafDemoApplication.class with spring profiles local,sample_data


## info


to start tailwind image you need a ".compose.env" that contains 2 variables MY_UID and MY_GID
run mvn package to generate .compose.env
