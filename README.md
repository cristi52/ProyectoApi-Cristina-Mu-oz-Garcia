# ProyectoApi1

Este proyecto consiste en el desarrollo de una **API REST** utilizando **Spring Boot** y **MySQL** para la gestión de proyectos, tecnologías y desarrolladores.  
La aplicación sigue el patrón de diseño **Controlador – Servicio – Repositorio (MVC)** y permite realizar operaciones CRUD completas sobre las tablas de la base de datos.

---

##  Tecnologías utilizadas
- Java 17  
- Spring Boot 3.x  
- Spring Data JPA (Hibernate)  
- MySQL 8  
- Maven  
- Postman (para pruebas de los endpoints)  

---

##  Configuración

### 1. Base de datos
La API se conecta a una base de datos MySQL. En el archivo `application.yaml` se configuran las credenciales:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/proyecto_db
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
