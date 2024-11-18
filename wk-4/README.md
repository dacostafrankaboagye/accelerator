# WEEK - 3
- [Exercises](#exercises) 
- [Solution](#solution) 💡


## Exercises
- [Part 1: Spring Boot Introduction](#part-1-spring-boot-introduction)
- [Part 2: Building a Spring Boot Application](#part-2-building-a-spring-boot-application)
- [Part 3: Spring Boot Configuration & Profiles](#part-3-spring-boot-configuration--profiles)
- Part 4
- Part 4 (Continued)

## Solution
- [Project Documentation](./ProductManagerAPI/README.md)

---

#### Part 1: Spring Boot Introduction
* Set up a new Spring Boot project using Spring Initializr [https://start.spring.io/](https://start.spring.io/)
* Explore the generated project structure and identify key components (e.g., `main` `class`, `configuration files`, `controller classes`).

#### Part 2: Building a Spring Boot Application
* Create a Spring Boot application with a `@SpringBootApplication` annotated class (main entry point).
* Define a simple controller class annotated with `@RestController`:
    * Implement a method to handle a `GET` request (e.g., /hello) and return a greeting message.
* Run your Spring Boot application and access the defined endpoint using a tool like `Postman` or `curl`.  
* Verify that the application responds with the expected message.

#### Part 3: Spring Boot Configuration & Profiles
* Modify your application to display a welcome message on startup using `application.properties`.
* Create a new configuration profile named `"dev"` and define a different welcome message for development environments.
* Run your application with the `"dev"` profile activated and verify that the appropriate welcome message is displayed.

#### Part 4: Spring Boot Web Development
* Enhance your existing controller to handle a `GET` request for a specific resource (e.g., `/api/v1/products`).
* Implement logic to return a list of dummy product objects (simulated data).
* Use `@PathVariable` annotation to capture dynamic values from the request URL (e.g., `product ID`).
* Run your application and test the new API endpoint using tools like Postman, sending various HTTP requests and verifying the responses.



