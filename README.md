# Finance Dashboard Backend

## Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Spring Data JPA
- Spring Security

## Features Implemented
- User and Role Management
- Financial Records CRUD
- Record Filtering (date, category, type)
- Dashboard Summary APIs
- Role Based Access Control
- Input Validation and Error Handling
- Data Persistence (Database)

## API Endpoints

### Roles
- POST /roles
- GET /roles

### Users
- POST /users
- GET /users
- GET /users/{id}
- PUT /users/{id}
- DELETE /users/{id}

### Records
- POST /records
- GET /records
- GET /records/{id}
- PUT /records/{id}
- DELETE /records/{id}
- GET /records/type/{type}
- GET /records/category/{category}
- GET /records/date?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD

### Dashboard
- GET /dashboard/summary

## How to Run
1. Create PostgreSQL database `finance_dashboard`
2. Update `application.properties`
3. Run Spring Boot application
4. Test APIs using Postman

## Notes
This project was built as a backend assignment for a finance data processing system with role-based access control and financial analytics.
