## Endpoints

## Endpoints
The following table summarizes the endpoints and their access roles:

| Endpoint              | HTTP Method | Role Access     | Description                  |
|-----------------------|-------------|-----------------|------------------------------|
| `/admin/**`           | GET         | ADMIN           | Access for admin users only. |
| `/staff/**`           | GET         | STAFF           | Access for staff users only. |
| `/regular-user/**`    | GET         | REGULAR         | Access for regular users.    |
| `/public/**`          | GET         | PUBLIC (ALL)    | Accessible by everyone.      |


## CRUD Endpoints

## Users
The application uses **in-memory user storage** and also **database-user-storage**. Below are the predefined users:

| Username  | Password   | Role     |
|-----------|------------|----------|
| Alexis    | Alex123    | REGULAR  |
| Jordan    | Admin123   | ADMIN    |
| Taylor    | Staff123   | STAFF    |


## Lessons
 - roles are prefixed with `ROLE_` when using `@Secured`.
    - enable method security
 - set the profiles in the `application.properties`