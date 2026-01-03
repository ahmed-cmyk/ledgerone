# LedgerOne

LedgerOne is a backend service designed to help users manage their personal finances effectively. It provides a robust set of features for tracking expenses, managing budgets, and receiving timely notifications.

## Features

*   **Expense Tracking**: Users can easily track their personal expenses.
*   **Budget Creation**: Create and manage budgets to control spending.
*   **Threshold Notifications**: Receive notifications when spending exceeds predefined thresholds.
*   **Monthly Rollovers**: Automated scheduled monthly rollovers for budgets.
*   **Analytics**: View comprehensive analytics including monthly totals and category breakdowns.

## Technology Stack

This project leverages the full Spring stack to deliver a scalable and maintainable backend service:

*   **API Layer**: Built with `spring-web` for robust RESTful API endpoints.
*   **Data Persistence**: Utilizes `spring-data-jpa` with `PostgreSQL` as the relational database.
*   **Authentication/Authorization**: Secured with `spring-security` and `JWT` (JSON Web Tokens).
*   **Background Jobs**: Implements background tasks using Spring Scheduling.
*   **Data Validation & Exception Handling**: Comprehensive validation and error handling mechanisms are in place.
*   **DTO Mapping Strategies**: Efficient data transfer object mapping using either MapStruct or Kotlin extension mappers.
*   **Architectural Patterns**: Follows standard architectural patterns including service layer, domain layer, and repository layer.
*   **Configuration Management**: Proper application configuration managed through `application.yml` profiles.