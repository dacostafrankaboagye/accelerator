# Spring Basics Solution

This project is a simple Spring application created as an 
exercise to demonstrate **dependency injection** and **bean configuration**. 
The application defines a `MessageService` bean and injects it into another bean, 
`MessagePrinter`, to show how Spring manages dependencies between components.

## Exercise Objectives

1. **Create a Basic Spring Application**
2. **Define a Message Service Bean**
3. **Inject the Message Service**
4. **Demonstrate Usage**


## Project Structure

- **`MessageService`**: A service class that provides a simple message (`"Hello From Frank - Spring Basic"`).
- **`MessagePrinter`**: A consumer class that depends on `MessageService`. This bean uses the service to print the message to the console.
- **`AppConfig`**: The configuration class that enables component scanning so that Spring can automatically discover beans.
- **`SpringApplication`**: The main class that initializes the Spring application context and triggers the `MessagePrinter` to display the message.

## About the Author

By [Frank Aboagye](https://github.com/frankkwabenaaboagye)
