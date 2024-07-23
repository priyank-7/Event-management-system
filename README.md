# Event-management-system

### Prerequisites:

* Java 17
* MySql server

### Project Setup:


**Installation:**

1. Clone the repository:

```bash
git clone https://github.com/priyank-7/Event-management-system/
```

```bash
cd Event-management-system
```
##
3. Database Configuration: Update the <code>application.properties</code> file
##

**Running the application:**

```bash
mvn clean install
```
```bash
mvn spring-boot:run
```
In case of maven is not installed, can use the maven wrapper:
```bash
./mvnw clean install
```
The application will be running on port: 8080.

#

### Tech Stack

* **Spring Boot:** Streamlines development by offering autoconfiguration and dependency injection, allowing you to focus on the core functionalities of the application. It also reduces boilerplate code associated with server setup and configuration management.
* **Spring Data JPA:** Simplifies database interactions by eliminating the need for manual, low-level SQL queries for CRUD (Create, Read, Update, Delete) operations. This improves code readability and maintainability by centralizing data access logic within dedicated repositories.
* **MySQL:** A mature and dependable open-source RDBMS (Relational Database Management System) offering excellent performance for handling structured data and queries. It boasts a proven track record and scales horizontally to accommodate growing demands. NoSQL databases might be a better fit for specific use cases.
* **ULIDs (Universally Unique Lexicographically Sortable Identifiers):** Compared to UUIDs (Universally Unique Identifiers), ULIDs provide faster generation, particularly within MySQL environments. This translates to improved database write performance by reducing insertion times by up to 50%.

### Challenges

**Asynchronous API Calls and Performance:**

* **Uneven Response Times:** External APIs might return responses at varying rates, introducing unpredictable delays. The application must wait for all responses before proceeding, potentially leading to performance bottlenecks.
* **Data Synchronization:** Waiting for all API responses before processing data can negate the performance advantages of asynchronous requests.
* **Partial Failures:** The application needs to be designed to gracefully handle scenarios where one or more API calls fail.

**Concurrent Data Access and Thread Safety:**

* **Race Conditions:** When multiple threads attempt to modify the same data object simultaneously, race conditions can arise, causing unexpected application behaviour.
* **Error Handling:** It's crucial to design the application to gracefully handle potential errors that might occur during concurrent operations, such as timeouts or exceptions encountered during API calls.

### Documentation

[Documentation](https://documenter.getpostman.com/view/27597906/2sA35G534s)
