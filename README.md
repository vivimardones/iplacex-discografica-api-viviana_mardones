# API REST Discografías - IPLACEX

API REST Spring para administración de discografías favoritas de empleados de IPLACEX. 
Proyecto Spring Boot 
Evaluación Unidad II - Programación Web Services.

## Tecnologías
- Java 21 + Spring Boot 3.3
- MongoDB Atlas
- Gradle + Docker
- Render (despliegue)

## Estructura
- `src/`: controladores, modelos y repositorios
- `Dockerfile`: build + run
- `application.properties`: conexión MongoDB

## Enlaces
- [Repositorio GitHub](https://github.com/vivimardones/iplacex-discografica-api-viviana_mardones)
- [API en Render](https://iplacex-discografica-api-viviana_mardones.onrender.com)

## Endpoints
- `GET /discografias`
- `POST /discografia`
- `PUT /discografia/{id}`
- `DELETE /discografia/{id}`

## Notas
- IP de Render autorizada en MongoDB Atlas
- Licencia MIT
