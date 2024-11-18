# Product Manager API - Documentation

---
## Overview
The Product Manager API is a Spring Boot application that demonstrates 
the implementation of a RESTful API for managing product data. 

It supports CRUD operations (Create, Read, Update, Delete) for product resources. 

This document provides a step-by-step guide to building and 
testing the application, along with its features.
---
## Sections
1. [Project Setup and Initialization](#project-setup-and-initialization)
2. [Building the Basic Application](#building-the-basic-application)
3. [Customizing the Startup Experience](#customizing-the-startup-experience)
4. Enhancing the API for Products
5. Implementing Full CRUD Operations

---

### Project Setup and Initialization

   * Project Configuration

           Project: Maven
           Language: Java
           Dependencies: Spring Web

### Building the Basic Application
 - `@SpringBootApplication` annotated main clas [ProductManagerApiApplication](./src/main/java/frank/productmanagerapi/ProductManagerApiApplication.java)
 - `GET` request (e.g., /hello) and return a greeting message.
 - Run and Test

```bash
# run
mvn spring-boot:run

# test
curl -X GET --location "http://localhost/hello"

```

### Customizing the Startup Experience
 - Modified the [application.properties](./src/main/resources/application.properties)

       
