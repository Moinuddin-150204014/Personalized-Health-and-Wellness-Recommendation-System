# Backend-Only Personalized Health and Wellness Recommendation System

![Project Logo](insert_logo_url_here)

Welcome to the Backend-Only Personalized Health and Wellness Recommendation System repository. This innovative project aims to develop a robust backend-only system using microservices, Spring Boot, JPA, API Gateway, Discovery Server, and Authentication Service. The system's primary goal is to provide users with tailored health and wellness recommendations, enable progress tracking, encourage community engagement, offer nutrition information, support mental health, utilize data analytics, and provide feedback analysis.

## Key Features and Components

### Microservices Architecture

The system employs a microservices architecture to ensure modularity and scalability. Each microservice addresses specific aspects of health and wellness recommendations and data management.

### Spring Boot

Spring Boot serves as the foundational framework for developing microservices. Its capabilities expedite the creation of robust and scalable backend services.

### JPA (Java Persistence API)

JPA facilitates data persistence and interaction with a relational database. Entities representing user profiles, health data, recommendations, feedback, and community interactions will be defined and managed using JPA.

### API Gateway

An API Gateway centralizes request routing, security, and authentication. It ensures a unified and secure API surface for client interactions.

### Discovery Server

The Discovery Server manages service registration and discovery for microservices. It enables dynamic scaling and load balancing, ensuring system reliability.

### Authentication Service

The Authentication Service handles user registration, login, and session management. Secure user authentication and access token generation will be implemented.

## Key Functionalities and API Samples

Please note that these are just samples of the functionalities and API endpoints:

### UserProfile and Health Data Management

- **User Registration**: `/users/register` - Register a new user.
- **User Login**: `/users/login` - Log in as a user.
- **Manage User Profile**: `/users/profile` - Manage user profile information.
- **Manage Personal Health Data**: `/users/health-data` - Manage personal health data.

### Health and Wellness Recommendations

- **Diet Recommendations**: `/recommendations/diet` - Get personalized diet recommendations.
- **Exercise Recommendations**: `/recommendations/exercise` - Receive exercise routines.
- **Mental Health Recommendations**: `/recommendations/mental-health` - Access mental health exercises.
- **Sleep Recommendations**: `/recommendations/sleep` - Receive sleep schedule recommendations.

### User Feedback and Progress Tracking

- **Submit Feedback**: `/feedback/submit` - Submit feedback on recommendations.
- **Track Progress**: `/progress/track` - Track health and wellness progress.
- **View Insights**: `/progress/insights` - View insights based on progress data.

### Notification Service (Optional)

- **Configure Notification Preferences**: `/notifications/preferences` - Configure notification preferences.
- **Send Notifications**: `/notifications/send` - Send personalized recommendations via notifications.

### Community and Social Integration

- **Create/Join Wellness Groups**: `/community/groups` - Create or join wellness groups.
- **Share Achievements and Updates**: `/community/posts` - Share achievements and wellness updates.
- **Interact with Posts**: `/community/interactions` - Like, comment, and follow other users' posts.

### Nutrition Information Service

- **Search for Foods and Recipes**: `/nutrition/search` - Search for foods and recipes.
- **Retrieve Nutritional Facts**: `/nutrition/details` - Retrieve nutritional facts for specific foods.
- **Receive Dietary Recommendations**: `/nutrition/recommendations` - Receive dietary recommendations.

### Mental Health and Stress Management

- **Access Mental Health Exercises**: `/mental-health/exercises` - Access mental health exercises.
- **Log and Track Mood Data**: `/mental-health/mood-tracking` - Log and track mood data.
- **Receive Mental Health Recommendations**: `/mental-health/recommendations` - Receive mental health recommendations.

### Data Analysis (Optional)

- **Analyze Data**: `/ml/analyze` - Analyze data from the database directly.
- **Get Personalized Predictions**: `/ml/predictions` - Get personalized predictions and insights.
- **Update Recommendations**: `/ml/update-recommendations` - Adjust recommendations based on insights.

### Feedback Analysis Dashboard

- **View User Feedback**: `/dashboard/feedback` - View user feedback and satisfaction.
- **Monitor User Progress**: `/dashboard/progress` - Monitor user progress and trends.
- **Make Data-Driven Decisions**: `/dashboard/recommendations` - Make data-driven decisions to improve recommendations.

## Project Goals

1. Develop a comprehensive backend-only system for personalized health and wellness recommendations.
2. Ensure data privacy and security through user authentication and secure data handling.
3. Provide a wide range of features for health tracking, community engagement, and advanced data analysis.
4. Implement efficient data storage and retrieval using JPA for user profiles, recommendations, and feedback, etc.
5. Leverage a microservices architecture for modularity, scalability, and maintainability.

## Deliverables and Instructions

1. The project is implemented and uploaded on GitHub. You can find the project repository [here](https://github.com/BJITAcademy2021/YSD_B03_MidTerm_DragonWarriors).
2. For more details about the project, refer to the repository's README file.

Feel free to explore the repository and get involved in the project. Your contributions and feedback are highly appreciated!
