# Ejercicios de Programación Avanzada

## Creación del contendor de PostgreSQL del ejercicio JPA-EJEMPLO1
`docker run --name postgres-container -e POSTGRES_USER=sa -e POSTGRES_PASSWORD=yourpassword -e POSTGRES_DB=books_db -p 5432:5432 -d postgres:latest`

### SQLite Database Configuration
```java
jdbc.url=jdbc:sqlite:/path/to/database.db
jdbc.driver=org.sqlite.JDBC
jdbc.username=
jdbc.password=
```

### MySQL Database Configuration
```
jdbc.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.username=your_username
jdbc.password=your_password
```

### PostgreSQL Database Configuration
```java
jdbc.url=jdbc:postgresql://localhost:5432/your_database_name
jdbc.driver=org.postgresql.Driver
jdbc.username=your_username
jdbc.password=your_password
```


