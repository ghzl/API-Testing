# TestNG API Testing Project

This is a TestNG project for testing APIs using various HTTP methods. The project is designed to help you automate API testing and validate the functionality and performance of your APIs.

## Features

- Supports testing of APIs using GET, POST, PUT, DELETE, and other HTTP methods.
- Allows sending request parameters, headers, and body payload.
- Provides detailed test reports and logs for easy debugging.
- Supports test data-driven testing using TestNG data providers.
- Can be easily integrated into Continuous Integration (CI) pipelines.

## Prerequisites

Make sure you have the following software installed:

- Java Development Kit (JDK) version 8 or higher.
- TestNG testing framework.
- Apache Maven (for managing project dependencies).
- Git (optional, for version control).

## Getting Started

1. Clone the repository to your local machine:

   ```
   git clone https://github.com/ghzl/APITesting-TestNG.git
   ```

2. Import the project into your favorite Java IDE.

3. Install project dependencies using Maven:

   ```
   cd APITesting-TestNG
   mvn clean install
   ```

## Writing Test Cases

To create a new API test case:

1. Create a new TestNG test class.

2. Add test methods with `@Test` annotations.

3. Use the provided HTTP utility classes to send API requests and validate responses.

4. Customize your test cases based on your API requirements, including handling authentication, sending request payloads, and verifying response data.

## Test Data

To provide test data dynamically, you can use TestNG data providers. Implement a data provider method and annotate your test method with `@DataProvider`, then supply the test data as needed.

```java
@DataProvider(name = "userIds")
public Object[][] provideUserIds() {
    return new Object[][] {
        { 1 },
        { 2 },
        { 3 }
    };
}

@Test(dataProvider = "userIds")
public void testGetUser(int userId) {
    // Use the provided user ID to fetch user details
}
```

## Reporting and Logging

This project generates test reports using the TestNG default report generator. You can find the reports under the "target/surefire-reports" directory after running the tests. Additionally, logging statements are available for debugging purposes and can be viewed in the console output.

## Contributing

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please create a pull request or open an issue on the project's GitHub repository.

## Acknowledgements

- [TestNG](https://testng.org) - The testing framework used in this project.
- [Apache HttpClient](https://hc.apache.org/httpcomponents-client-ga/) - HTTP client library
