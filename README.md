# Code test - Mortgage plan

I decided to use the Spring framework to build the mortgage calculator application. The application parses the input CSV
file located in the project's root directory at startup and prints the results to the terminal.

Using Spring Web and Thymeleaf, it also hosts a page on localhost port 8080 where all the loaded data can be viewed.
There is also a form to add an estimate to the list.

The application currently does not save the added estimates anywhere but in memory, I hope this is ok.

## Running the application

The project requires Java version 17. The gradle wrapper "./gradlew" can be used to run the application locally, use
the following command:

```
./gradlew bootRun
```

If everything works correctly, you should after it's built see the programs output, in the end it should print out all
the calculations. The web server should also be on and accessible at localhost:8080.

### Docker
A Dockerfile is also provided so the application can be run using Docker or Podman. To create a container use the following
command:

```
docker build . --tag mortgage-plan
```

You can then for example run the container interactively with this command:

```
docker run -it -p 8080:8080 localhost/mortgage-plan
```