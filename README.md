
# Test Application
## Overview
This Test Application is a demonstration of using modern Android development tools with Jetpack Compose to create a responsive and dynamic user interface. The application showcases a list of individuals, where users can select an individual to view detailed information in a modal bottom sheet.

## Features
- Animated Navigation: Utilizes Jetpack Compose's navigation capabilities to transition between screens with smooth animations.
- Dynamic Data Fetching: Integrates with a GraphQL API using Apollo Client to fetch and display data.
- Detail View: Displays detailed information about an individual in a modal bottom sheet, including attributes like homeworld, height, and more.
- Responsive Layout: Adapts to various device sizes and orientations.

## Architecture
The application follows a simple yet robust architecture:

- UI Components: Composables for UI elements such as PersonItem, PersonList, and PersonDetailSheet.
- Navigation: Managed by AnimatedNavigation which handles transitions and routing between the main and detail screens.
- Data Management: Uses Apollo GraphQL for data management and network calls.
## Technologies Used
- Jetpack Compose: For building the UI.
- Apollo GraphQL: For handling data fetching and management.
- Android Material3: For modern material design components and theming.
## Setup
To run this project, follow these steps:

1. Clone the repository:


```bash
git clone git@github.com:AnastasiiaDudarieva/Test-Application-Jetpack-Compose-GraphQL.git
```
2. Open the project in Android Studio.

3. Sync the project with Gradle.

4. Run the application on an emulator or physical device.