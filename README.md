## Introduction
BankingApp is a basic banking system REST API built with Spring Boot. It allows users to perform basic banking operations such as creating an account, depositing money, withdrawing money, and deleting an account.

## Getting Started

### Prerequisites
- Java 17 or later
- Maven 3.6.3 or later
- A relational database (e.g., MySQL, PostgreSQL)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/aribadev/BankingApp.git
   cd BankingApp
   ```

2. Configure the database:
Update the application.properties file located in src/main/resources with your database configuration.
application properties
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/bankingapp
  spring.datasource.username=root
  spring.datasource.password=root
  spring.jpa.hibernate.ddl-auto=update
  ```

3. Build and run the application:
  ```bash
  mvn clean install
  mvn spring-boot:run
  ```

Project Structure
BankingappApplication.java
This is the main class that bootstraps the Spring Boot application.

models/Account.java
This is the JPA entity class that maps to the accounts table in the database.

models/AccountDetails.java
This is a simple POJO used to transfer account data between layers.

models/AccountMapper.java
This class contains methods to map between Account and AccountDetails.

service/AccountService.java
This is the service interface that defines the business logic for account operations.

service/implementation/AccountServiceImplementation.java
This class implements the AccountService interface and contains the actual business logic.

repository/AccountRepository.java
This is the JPA repository interface for Account entities.

controller/AccountController.java
This is the REST controller that handles HTTP requests and responses.

Conclusion
This basic banking system provides a foundation for further development and enhancement. Feel free to fork the repository and add more features. Contributions are welcome!
