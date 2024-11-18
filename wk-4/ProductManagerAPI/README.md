# Product Manager API - Documentation

---
## Overview
The Product Manager API is a Spring Boot application that demonstrates 
the implementation of a RESTful API for managing product data. 

It supports CRUD operations (`Create`, `Read`, `Update`, `Delete`) for product resources. 

This document provides a step-by-step guide to building and 
testing the application, along with its features.
---
## Sections
1. [Project Setup and Initialization](#project-setup-and-initialization)
2. [Building the Basic Application](#building-the-basic-application)
3. [Customizing the Startup Experience](#customizing-the-startup-experience)
4. [Enhancing the API for Products](#enhancing-the-api-for-products)
5. [Implementing Full CRUD Operations](#implementing-full-crud-operations)

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
 - New configuration profile [application-dev.properties](./src/main/resources/application-dev.properties)


### Enhancing the API for Products
 - [ProductController](./src/main/java/frank/productmanagerapi/controller/ProductController.java) with dummy data 
   - Test API Endpoints

            GET /api/v1/products: Returns all products.
            GET /api/v1/products/1: Returns product with ID 1.

```bash

curl -X GET --location "http://localhost/api/v1/products"

curl -X GET --location "http://localhost/api/v1/products/2"

```


### Implementing Full CRUD Operations
- Add endpoints for `POST`, `PUT`, and `DELETE`
- Testing Endpoints

```bash

# POST
curl -X POST http://localhost:8080/api/v1/products \
-H "Content-Type: application/json" \
-d '{"name": "Tablet", "price": "400"}'

# PUT
curl -X PUT http://localhost:8080/api/v1/products/1 \
-H "Content-Type: application/json" \
-d '{"name": "Laptop-HP", "price": "1500"}'

# DELETE
curl -X DELETE http://localhost:8080/api/v1/products/1

```

### API Endpoints Summary

| HTTP Method | Endpoint                     | Description                      | Request Body Example                                                                                           | Response Example                                                                                              |
|-------------|------------------------------|----------------------------------|---------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| `GET`       | `/api/v1/products`           | Retrieve all products.           | None                                                                                                          | `[{"id": "1", "name": "Laptop", "price": "1500"}, ...]`                                                      |
| `GET`       | `/api/v1/products/{id}`      | Retrieve a product by ID.        | None                                                                                                          | `{"id": "1", "name": "Laptop", "price": "1500"}`                                                             |
| `POST`      | `/api/v1/products`           | Create a new product.            | `{"name": "Tablet", "price": "400"}`                                                                          | `{"id": "6", "name": "Tablet", "price": "400"}`                                                              |
| `PUT`       | `/api/v1/products/{id}`      | Update a product by ID.          | `{"name": "Laptop-HP", "price": "1500"}`                                                                      | `{"id": "1", "name": "Laptop-HP", "price": "1500"}`                                                          |
| `DELETE`    | `/api/v1/products/{id}`      | Delete a product by ID.          | None                                                                                                          | HTTP Status 204 (No Content)                                                                                 |

