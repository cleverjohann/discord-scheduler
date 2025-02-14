# 🚀 Generador de Mensajes Automáticos para Discord

## 📌 Descripción
Este proyecto es un backend en **Java Spring Boot** que permite programar y enviar mensajes automáticos a un servidor de **Discord**, sin depender de bots de terceros.

## ⚙️ Tecnologías Usadas
- **Java 17**
- **Spring Boot**
- **PostgreSQL** (Base de Datos)
- **Docker** (Para PostgreSQL)
- **Quartz Scheduler** (Para ejecutar tareas programadas)
- **JDA (Java Discord API)** (Opcional para integración con Discord)
- **SpringDoc OpenAPI** (Documentación Swagger)

## 🏗️ Instalación y Configuración
### 🔹 1. Clonar el repositorio
```bash
git clone https://github.com/cleverjohann/discord-scheduler.git
cd discord-scheduler
```
### 🔹 2. Configurar la Base de Datos
Asegúrate de tener Docker instalado y ejecutando. Luego, inicia el contenedor de PostgreSQL:
```bash
  docker-compose up -d
```
### 🔹 3. Configurar las Variables de Entorno
Crea un archivo .env en la raíz del proyecto y añade la siguiente configuración:
```bash
DISCORD_TOKEN=your_discord_bot_token
DISCORD_CHANNEL_ID=your_discord_channel_id
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/discord_db
SPRING_DATASOURCE_USERNAME=admin
SPRING_DATASOURCE_PASSWORD=admin123
```
### 🔹 4. Configurar application.properties
Edita src/main/resources/application.properties para usar variables de entorno:
```bash
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

discord.token=${DISCORD_TOKEN}
discord.channel.id=${DISCORD_CHANNEL_ID}
```
## 🛠️ Endpoints de la API
### 🔹 Crear un Mensaje Programado
Endpoint: `POST /api/message`

Request Body:
```bash
{
  "text": "Tu mensaje aquí",
  "scheduledDate": "2025-02-15T10:00:00"
}
```
Response:
```bash
{
  "id": 1,
  "text": "Tu mensaje aquí",
  "scheduledDate": "2025-02-15T10:00:00"
}
```
### 🔹 Obtener Mensajes Programados
Endpoint: `GET /api/messages`

Response:
```bash
[
  {
    "id": 1,
    "text": "Tu mensaje aquí",
    "scheduledDate": "2025-02-15T10:00:00"
  }
]
```
### 🔹 Eliminar un Mensaje Programado

Endpoint: `DELETE /api/message/{id}`

Response:
```bash
{}
```
## 🚀 Despliegue
Para desplegar la aplicación en un entorno de producción, asegúrate de configurar adecuadamente las variables de entorno y las configuraciones de la base de datos.