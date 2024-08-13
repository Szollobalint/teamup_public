# Helldivers 2 Teammate and Guild Finder: TEAM UP

**TEAM UP** is a web platform designed for Helldivers 2 players to create and manage guilds, recruit members, and organize events. Players can reserve spots for upcoming events and receive notifications when the event starts, ensuring a seamless and coordinated gaming experience.

## Installation Instructions

### 1. Clone the Repository
To get started, clone the TEAM UP repository from GitHub:
```bash
git clone git@github.com:Szollobalint/TeamUp-public.git
```

### 2. Backend Setup
Ensure you have Java and Maven installed on your system.

Navigate to the backend directory:

```bash
cd TeamUp-public/backend
```

Build the Spring Boot application:

```bash
mvn clean install
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```
### 3. Frontend Setup
   Ensure you have Node.js and npm installed on your system.

   Navigate to the frontend directory:

   ```bash
   cd ../client
   ```

   Install the dependencies:

   ```bash
   npm install
   ```

   Start the React application:

   ```bash
   npm run dev
   ```

### 4. Access the Application
   Open your web browser and go to http://localhost:8080/.
   Usage Instructions

1. Register an Account
   Click on the "Sign Up" button on the homepage.
   Fill in your details and create an account.

2. Find Teammates
   Log in to your account.
   Navigate to the "Find Teammates" section.
   Use the search filters to find players based on your preferences.

3. Create or Join a Guild
   Go to the "Guilds" section.
   Browse existing guilds to join or create your own guild by filling in the required details.
   
### 5. Technologies Used

1. Backend:

- **Java**
- **Spring Boot**
- **Maven**
- **JUnit5**

2. Frontend:

- **JavaScript**
- **React / Vite**
- **TailwindCSS**
- **Axios**

3. Database:

- **PostgreSQL**
- **H2**

### 6. Contact Information
For support or inquiries, please contact:
- **Email: pzsombor.dev@gmail.com**