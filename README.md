<H1>Setting Up and Running Project with Maven</H1>
<hr>
<H3>Prerequisites:</H3>
<H5>Java Development Kit (JDK)</H5>
<H5>MySql server</H5>


<H3>Project Setup:</H3>
<hr>
<H5>*Clone or Download Project</H5>
<H5>*Navigate to the Project Directory</H5>
<H5>*Database Configuration in application.yml</H5>

<H3>Building and Running the Project:</H3>
<H5>mvn clean package</H5>
<H5>java -jar Event-management-system.jar</H5>

<H4>Bash</H4>
<H5>mvn clean package</H5>
<H5>java -jar Event-management-system.jar</H5>



<H3>Tech Stack</H3>

<p>
<b>Spring Boot:</b> Streamlines development by offering auto-configuration and dependency injection, allowing you to focus on core functionalities of the application. It also reduces boilerplate code associated with server setup and configuration management.
<b>Spring Data JPA:</b> Simplifies database interactions by eliminating the need for manual, low-level SQL queries for CRUD (Create, Read, Update, Delete) operations. This improves code readability and maintainability by centralizing data access logic within dedicated repositories.
<b>MySQL:</b> A mature and dependable open-source RDBMS (Relational Database Management System) offering excellent performance for handling structured data and queries. It boasts a proven track record and scales horizontally to accommodate growing demands. While MySQL is a suitable choice for this project, NoSQL databases might be a better fit for specific use cases.
<b>ULIDs (Universally Unique Lexicographically Sortable Identifiers):</b> Compared to UUIDs (Universally Unique Identifiers), ULIDs provide faster generation, particularly within MySQL environments. This translates to improved database write performance by reducing insertion times by up to 50%.
</p>



<H3>Challenges</H3>

<H4>Asynchronous API Calls and Performance:</H4>
<p>
<b>Uneven Response Times:</b> External APIs might return responses at varying rates, introducing unpredictable delays. The application must wait for all responses before proceeding, potentially leading to performance bottlenecks.
<b>Data Synchronization:</b> Waiting for all API responses before processing data can negate the performance advantages of asynchronous requests.
Partial Failures: The application needs to be designed to gracefully handle scenarios where one or more API calls fail.
</p>

<H4>Concurrent Data Access and Thread Safety:</H4>
<p>
<b>Race Conditions:<b> When multiple threads attempt to modify the same data object simultaneously, race conditions can arise, causing unexpected application behaviour.
<b>Error Handling:</b> It's crucial to design the application to gracefully handle potential errors that might occur during concurrent operations, such as timeouts or exceptions encountered during API calls.
</p>



<H3>Documentation</H3>
<a href="https://documenter.getpostman.com/view/27597906/2sA35G534s">https://documenter.getpostman.com/view/27597906/2sA35G534s</a>
