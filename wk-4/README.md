# WEEK - 3
- [Exercises](#exercises) 
- [Solution](#solution)
- [Lessons and Takeaways]() 💡


## Exercises
- [Part 1: Spring Boot Introduction](#part-1-spring-boot-introduction)
- [Part 2: Building a Spring Boot Application](#part-2-building-a-spring-boot-application)
- [Part 3: Spring Boot Configuration & Profiles](#part-3-spring-boot-configuration--profiles)
- [Part 4: Spring Boot Web Development]()
- [Part 4 (Continued): Develop a Simple RESTful API using Spring Boot](#part-4-continued-develop-a-simple-restful-api-using-spring-boot)


## Solution
- [Project Documentation](./ProductManagerAPI/README.md) - (ProductManagerAPI/README.md)


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

#### Part 4 (Continued): Develop a Simple RESTful API using Spring Boot

* Design and implement additional API endpoints for your chosen resource (e.g., products) using appropriate HTTP methods:
    1. `POST` /api/v1/products: Create a new product.
    2. `GET` /api/v1/products/{id}: Retrieve a specific product by ID. 
    3. `PUT` /api/v1/products/{id}: Update an existing product. 
    4. `DELETE` /api/v1/products/{id}: Delete a product by ID.
* Implement logic within your controller methods to handle these requests:
* Use request body data for creating and updating products (e.g., using `@RequestBody` annotation).
* Implement error handling and return appropriate HTTP status codes (e.g., `201 Created`, `404 Not Found`).
* Test your newly implemented API endpoints using various HTTP requests with different data and scenarios. Verify that the API behaves as expected for each action (`create`, `read`, `update`, `delete`).

---

## Lessons and Takeways
- RESTful API Best Practices
- Spring Boot Annotations
- Immutable Collections
- UUID for Unique IDs
- Handling JSON Data


