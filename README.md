# API REST - Gestión de Personas 👥⚙️

Este proyecto es una API RESTful desarrollada con Java y Spring Boot para la gestión de un registro de personas. Permite realizar operaciones completas de CRUD (Crear, Leer, Actualizar, Borrar) y consultas personalizadas sobre una base de datos relacional.

Es un proyecto puramente de Backend (sin interfaz gráfica), diseñado para que aplicaciones cliente (como webs en JS o apps móviles) puedan consumir y gestionar estos datos en formato JSON.

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3
* **Acceso a Datos:** Spring Data JPA (Hibernate)
* **Base de Datos:** MySQL
* **Gestor de Dependencias:** Maven

## 🚀 Rutas de la API (Endpoints)

La API expone los siguientes endpoints bajo la ruta principal `/personas`:

### Operaciones Básicas (CRUD)
* `GET /personas` - Devuelve la lista de todas las personas registradas.
* `GET /personas/{id}` - Obtiene los detalles de una persona específica por su ID.
* `POST /personas` - Crea un nuevo registro de persona.
* `POST /personas/crearlista` - Permite insertar múltiples personas de golpe enviando una lista en JSON.
* `PUT /personas/{id}` - Actualiza los datos (nombre, apellidos, edad) de una persona existente.
* `DELETE /personas/{id}` - Elimina una persona de la base de datos.

### Consultas Personalizadas (Filtros)
* `GET /personas/nombre/{nombre}` - Busca y devuelve personas que coincidan exactamente con el nombre indicado.
* `GET /personas/apellidos/{apellidos}` - Busca personas por sus apellidos.
* `GET /personas/mayores` - Devuelve una lista de las personas mayores de edad (>18 años).
* `GET /personas/menores` - Devuelve una lista de las personas menores de edad (<18 años).

## ⚙️ Instalación y Configuración

Para ejecutar este proyecto en tu entorno local:

1. Clona este repositorio.
2. Asegúrate de tener un servidor MySQL en ejecución.
3. Configura las credenciales de tu base de datos en el archivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
