# 
## Understanding the Http-Client Project

The `http-client` project is a Java-based application built with Spring Boot and Maven. It's designed to interact with a REST API and perform CRUD operations.

### Project Structure

The project follows a typical Spring Boot project structure. The main code resides in the `src/main/java` directory, and the tests are in the `src/test/java` directory.

The `com.omersolutions.httpclient` package contains the main application class `HttpClientApplication.java` which is the entry point of the application.

The `com.omersolutions.httpclient.post` package contains the `Post` model class and the `PostClient` class. The `Post` model represents the data structure of a post, and the `PostClient` class is responsible for making HTTP requests to the REST API.

### How It Works

When you run the application, it starts a Spring Boot server on your local machine. The `PostClient` class makes HTTP requests to the `https://jsonplaceholder.typicode.com/posts` endpoint to fetch posts.

The `PostClient` uses the `RestTemplate` class provided by Spring Boot to make HTTP requests. The response from the API is deserialized into a list of `Post` objects.

### Testing

The project includes unit tests in the `src/test/java/com/omersolutions/httpclient/services` directory. The `PostClientTest` class tests the `PostClient` class. It uses `MockRestServiceServer` to mock HTTP responses from the REST API.

### Running the Project

You can run the project using Maven with the command `mvn spring-boot:run`. This will start the application on `http://localhost:8080/api/posts`.

You can also build and run the project using Docker or GraalVM as explained in the previous sections of this document.
