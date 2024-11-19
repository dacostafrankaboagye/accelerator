## Features

- **Role-based Access Control**: Users can be assigned different roles: ADMIN, STAFF, and REGULAR.
- **Public Access**: Some endpoints are available to all users.
- **Security**: Passwords are encoded using BCrypt for secure authentication.
- **Method-level Security**: Enabled to secure specific methods.
- **Custom Exception Handling**: Graceful error responses with customized exceptions.

## Endpoints

The following table summarizes the available endpoints in the SecureShop application:

| HTTP Method | Endpoint                  | Role Required     | Description                                      |
|-------------|---------------------------|-------------------|--------------------------------------------------|
| `GET`       | `/admin/**`                | ADMIN             | Accessible only by Admin users.                  |
| `GET`       | `/staff/**`                | STAFF             | Accessible only by Staff users.                  |
| `GET`       | `/regular-user/**`         | REGULAR           | Accessible only by Regular users.                |
| `GET`       | `/public/**`               | PUBLIC            | Accessible by everyone, no authentication required.|
| `GET`       | `/api/**`                  | PUBLIC            | Accessible by everyone, no authentication required.|
| `GET`       | `/admin/getInfo`           | ADMIN             | Get details of the current logged-in Admin user. |
| `GET`       | `/admin/get-all-users`     | ADMIN             | Get details of all users in the system.          |
| `GET`       | `/regular-user/**`         | REGULAR           | Accessible only by Regular users.                |
| `GET`       | `/staff/**`                | STAFF             | Accessible only by Staff users.                  |


## Default Users

The following table outlines the default users created in the system:

| Username | Password  | Role  |
|----------|-----------|-------|
| Jordan   | Admin123  | ADMIN |
| Taylor   | Staff123  | STAFF |
| Alexis   | Alex123   | REGULAR |


## Lessons
 - roles are prefixed with `ROLE_` when using `@Secured`.
    - enable method security
 - set the profiles in the `application.properties`