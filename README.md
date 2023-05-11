# Tenisu

Test Technique L’Atelier - Backend 🕷

## Installation

Clone project

```bash
git clone https://github.com/JeremTer/tenisu.git
```

Run maven install

```bash
mvn install
```

## Usage

Start the API with the command line

```bash
mvn spring-boot:run
```

Then go to http://localhost:8080/api/swagger-ui/ to test the routes.

## Cloud

You can also test the API via these deployed routes :

### Task 1

- https://tev9z2nuye.execute-api.us-east-1.amazonaws.com/Prod/players

### Task 2

- https://tev9z2nuye.execute-api.us-east-1.amazonaws.com/Prod/players/{id}

### Task 3

- https://tev9z2nuye.execute-api.us-east-1.amazonaws.com/Prod/countries/best-win-ratio
- https://tev9z2nuye.execute-api.us-east-1.amazonaws.com/Prod/players/average-bmi
- https://tev9z2nuye.execute-api.us-east-1.amazonaws.com/Prod/players/median-height
