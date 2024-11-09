# CityScape Site

CityScape Site is a web application built using Java and Spring Boot. It provides a login and contact functionality with a visually appealing design.

## Technologies Used

- **Java**: The primary programming language used for the backend.
- **Spring Boot**: A framework used to create stand-alone, production-grade Spring-based applications.
- **Thymeleaf**: A modern server-side Java template engine for web and standalone environments.
- **Spring Security**: A framework that focuses on providing both authentication and authorization to Java applications.
- **Maven**: A build automation tool used primarily for Java projects.
- **Bootstrap**: A front-end framework for developing responsive and mobile-first websites.

## Features

- **User Authentication**: Users can log in using their credentials. The login page is styled with Bootstrap and includes a gradient background, icons, and subtle animations.
- **Contact Form**: Users can send their contact information and issues through a form. The contact page is also styled with Bootstrap and includes a background image and improved input field visibility.
- **Responsive Design**: The application uses Bootstrap to ensure that the pages are responsive and look good on all devices.

## Setup and Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/cityscape-site.git
    cd cityscape-site
    ```

2. **Build the project using Maven**:
    ```sh
    mvn clean install
    ```

3. **Run the application**:
    ```sh
    mvn spring-boot:run
    ```

4. **Access the application**:
   Open your web browser and go to `http://localhost:8080`.

## Access the Public Site

To access the public site, please visit: `http://cityscape.vpsgh.it:8080`.

## Project Structure

- `src/main/java/com/naado/cityscapesite/config`: Contains the configuration files for Spring Security.
- `src/main/java/com/naado/cityscapesite/model`: Contains the model classes.
- `src/main/java/com/naado/cityscapesite/repository`: Contains the repository interfaces.
- `src/main/resources/templates`: Contains the Thymeleaf templates for the login and contact pages.
- `src/main/resources/static/images`: Contains the static images used in the application.

## Security Configuration

The security configuration is handled in the `WebSecurityConfig` class. It uses Spring Security to manage user authentication and authorization. The configuration allows access to the home, contact, and images pages without authentication, while other pages require the user to be authenticated.

## Styling

The application uses Bootstrap for styling. The login and contact pages include:

- **Gradient Background**: A linear gradient background for a modern look.
- **Input Group Components**: Bootstrap's input group components are used to add icons to the input fields.
- **Background Image**: A background image with a blur effect to enhance the visual appeal.
- **Responsive Design**: Ensures that the pages are responsive and look good on all devices.

## Contact

For any issues or inquiries, please contact us through the contact form on the website.

---

This project is licensed under the MIT License.