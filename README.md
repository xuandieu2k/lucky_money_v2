# Android MVVM Architecture - Project Structure

This project follows the **Model-View-ViewModel (MVVM)** architecture, which divides the application into three layers: **Data**, **Domain**, and **Presentation**. This structure improves separation of concerns, testability, and maintainability.

## Project Structure
├── data/
│   ├── local/
│   │   ├── AppDatabase.kt
│   │   ├── MainDao.kt
│   ├── remote/
│   │   ├── ApiService.kt
│   ├── repository/
│   │   ├── MainRepositoryImpl.kt
├── domain/
│   ├── model/
│   │   ├── MainItem.kt
│   ├── repository/
│   │   ├── MainRepository.kt
│   ├── usecase/
│   │   ├── GetMainItemsUseCase.kt
├── presentation/
│   ├── ui/
│   │   ├── main/
│   │   │   ├── MainFragment.kt
│   │   │   ├── MainViewModel.kt
│   ├── di/
│   │   ├── AppModule.kt
├── utils/
│   ├── Resource.kt
├── BaseApplication.kt

---

### 1. `data/` - **Data Layer**
The **Data Layer** is responsible for managing the application's data. It provides the sources of data, whether local or remote, and interacts with the domain layer.

#### - `local/`
Contains the **local data sources**, such as:
- **AppDatabase.kt**: The configuration class for the Room database.
- **MainDao.kt**: The DAO (Data Access Object) interface, defining database operations for the `MainItem` entity.

#### - `remote/`
Contains the **remote data sources**, such as:
- **ApiService.kt**: Defines the Retrofit service for interacting with external APIs.

#### - `repository/`
This folder contains the implementation of the **Repository pattern**:
- **MainRepositoryImpl.kt**: Implementation of `MainRepository` which provides data from both local and remote sources. It acts as a mediator between the data layer and the domain layer.

---

### 2. `domain/` - **Domain Layer**
The **Domain Layer** handles the core business logic of the application. This layer is independent of Android frameworks and serves as the middle layer between the data and presentation layers.

#### - `model/`
Contains the **domain models**:
- **MainItem.kt**: The domain model representing the data of the main item.

#### - `repository/`
Contains the **repository interfaces**:
- **MainRepository.kt**: Interface defining the data operations for `MainItem`. This is implemented in the data layer.

#### - `usecase/`
Contains **UseCases**, which handle specific pieces of business logic:
- **GetMainItemsUseCase.kt**: UseCase responsible for fetching the list of `MainItem`s. It interacts with the repository to obtain the data and execute business rules.

---

### 3. `presentation/` - **Presentation Layer**
The **Presentation Layer** manages the UI and user interaction logic. It consists of UI components such as Activities, Fragments, and their corresponding ViewModels.

#### - `ui/`
This folder contains the UI elements:
- **MainActivity.kt**: The main UI screen of the application.
- **MainViewModel.kt**: The ViewModel responsible for holding the UI-related data for the `MainActivity`. The ViewModel interacts with the UseCases to fetch and manage data for the UI.

#### - `di/`
Contains **Dependency Injection** setup using **Hilt**:
- **AppModule.kt**: Provides necessary dependencies such as Repository implementations, UseCases, and Retrofit instances for the whole application.

---

### 4. `utils/` - **Utilities**
The **utils** folder contains reusable utility classes that can be shared across different layers of the application:
- **Resource.kt**: A wrapper class for managing data states such as loading, success, and error. This is commonly used in the ViewModel to represent the current state of the data being fetched.

---

### 5. `BaseApplication.kt`
The `BaseApplication.kt` class extends the `Application` class. It serves as the entry point of the app and is used to set up global application-level configurations like initializing Hilt for dependency injection.

---

## Key Advantages of MVVM Architecture

- **Separation of Concerns**: By separating data, domain, and UI layers, each part of the codebase focuses on specific responsibilities, making it easier to maintain and scale.
- **Testability**: The separation of the business logic into UseCases and repositories makes the application more testable, as each component can be tested in isolation.
- **Lifecycle Awareness**: ViewModels in the MVVM architecture are lifecycle-aware, ensuring that the data is retained across configuration changes like screen rotations.
- **Reusability**: Business logic inside UseCases can be reused across different ViewModels or UI components.

---

## How It Works

1. **User Interaction**: The user interacts with the UI (e.g., `MainActivity`), and the UI communicates with the `MainViewModel`.
2. **ViewModel Logic**: The `MainViewModel` calls the `GetMainItemsUseCase` to fetch data.
3. **UseCase Execution**: The `GetMainItemsUseCase` interacts with the `MainRepository`, which either fetches the data from the local database (`MainDao`) or from a remote API (`ApiService`).
4. **Data Flow**: Once the data is fetched, it is wrapped in a `Resource` object to represent its state (loading, success, error) and then passed back to the UI to be displayed.
