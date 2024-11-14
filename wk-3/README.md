# WEEK - 3
- [Essentials](#essentials) 🛠️
- [Solutions](#solution) 💡
- [Concerns](#concerns) ⚠️


## Essentials

- [Part 1: Dependency Injection (DI) & Autowiring](#dependency-injection-di--autowiring)
- [Part 2: Spring Beans & Configuration](#spring-beans--configuration)
- [Part 3: Unit Testing with JUnit](#unit-testing-with-junit)
- [Part 4: Building a Spring CRUD Application](#building-a-spring-crud-application)

## Solution
- [User Application](./UserApp/src/main/java/frank/userapp/)
- [Test](./UserApp/src/test/java/frank/userapp/)

## Concerns
- [concerns.md](./concerns.md)


---

#### Dependency Injection (DI) & Autowiring

- Create two simple Java classes:
    - `UserService`: This service interacts with a user repository (simulated for now).
    - `UserController`: This controller receives user data from requests and delegates operations to the UserService.
- Implement DI in UserService:
Define a constructor that takes a  `UserRepository` dependency.
- Implement autowiring in UserController:
Annotate the UserService dependency with `@Autowired`.


#### Spring Beans & Configuration

- Create a Spring Boot application with a basic `@SpringBootApplication` annotated class.
- Define a simple UserRepository interface (simulating user data access).
- Implement a UserService class as a Spring bean using `@Service` annotation:
    - Inject the UserRepository dependency using autowiring.

#### Unit Testing with JUnit

- Create a JUnit test class for your UserService:
    - Use @RunWith(SpringRunner.class) annotation.
- Write unit tests for UserService methods (e.g., creating or finding users):
    - Use mock objects (e.g., Mockito) to simulate the UserRepository behavior.
    - Assert expected outcomes using JUnit assertions.


#### Building a Spring CRUD Application

- Implement a simple User model class with relevant attributes.
- Create an in-memory UserRepository class (simulating data access):
    - Implement methods for CRUD operations (create, read, update, delete) on user data.
- Enhance your UserService:
    - Include methods to perform CRUD operations on users, delegating to the UserRepository.
- Implement a UserController (annotated with @RestController):
    - Define REST endpoints for CRUD operations on users (e.g., using `@GetMapping`, `@PostMapping`,`@PutMapping`,`@DeleteMapping`). * UseUserService` methods to perform CRUD operations within the controller methods.
- Run your Spring Boot application and test the implemented REST endpoints using tools like Postman or curl commands. Verify that you can create, read, update, and delete user data successfully.