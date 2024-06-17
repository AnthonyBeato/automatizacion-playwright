# Practica 2 - Playwright

## Proyecto de Automatización de Pruebas con Playwright y Frameworks Web
Este proyecto es una práctica de aseguramiento de calidad de software utilizando el framework Vaadin y la herramienta Playwright para automatizar pruebas de una aplicación web.

### Requisitos
- Java 21
- Maven
- Node.js (requerido por Playwright)

### Configuración del Entorno
Clonar el Repositorio
git clone https://github.com/AnthonyBeato/automatizacion-playwright.git

### Credenciales para loguearse
- Nombre: anthonybeato
- Contraseña: 1234 

### Para poder ejecutar las pruebas unitarias 
"mvn test"

### Estructura del proyecto
- InicioView: Es una galería de fotos, basándose en la famosa página Unsplash
- LoginView: Es el formulario para iniciar sesión
- ContactoView: Es el formulario de contacto para problemas o sugerencias 

### Configuracion de base de datos
En este caso, se utilizó la base de datos en memoria de H2. Los datos se cargan en cada inicio desde el archivo
data.sql

### Ejecución del proyecto
Se ejecuta el proyecto en localhost:8080 