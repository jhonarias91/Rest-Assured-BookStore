# Rest-Assured BookStore Project

Este proyecto combina el uso de **Rest-Assured** para automatizar la creación de usuarios mediante una API y **Playwright**
para la automatización de UI, ejecutando pruebas de login y eliminación de usuarios en un sistema de prueba. usando para ello: https://demoqa.com/

## Requisitos previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior.
- **Maven** 3.6 o superior.
- **Git** para clonar el repositorio.

## Clonar el repositorio

Clonar el repositorio.

```bash
git clone https://github.com/jhonarias91/Rest-Assured-BookStore.git
```

## Configuración del proyecto

1. Propiedades del proyecto
   El archivo properties.properties en src/test/resources/properties.properties contiene las propiedades necesarias 
2. para la ejecución de las pruebas, tales como la URL base de la API, credenciales de prueba y modo headless (true/false).

Crea un archivo properties.properties en src/test/resources si no existe, y agrega el siguiente contenido:
```properties

demoqa.host.base.url=https://demoqa.com/
test.password=your_password_here
login.invalid.username.error=Invalid username or password!
playwright.config.is.headless=false
```
Modifica el valor correspondientes como playwright.config.is.headless para mostrar u ocultar el navegador

2. Dependencias
   El proyecto utiliza Maven para la gestión de dependencias. Si no tienes las dependencias descargadas, 
3. ejecuta el siguiente comando para descargarlas:

```bash
mvn clean install
```
Esto descargará todas las dependencias definidas en el archivo pom.xml.

4. Ejecutar las pruebas
Una vez que hayas configurado el proyecto y descargado las dependencias, puedes ejecutar las pruebas con Maven.


1. Ejecutar todas las pruebas
   Para ejecutar todas las pruebas, simplemente usa el siguiente comando:

```bash
mvn test
```

# Estructura del proyecto
El proyecto está organizado de la siguiente manera:

```bash
bookStoreAssuredTest/
│
├── .idea/                        # Archivos de configuración de IntelliJ IDEA
├── src/
│   ├── main/
│   │   └── java/                 # Paquete principal (vacío en este proyecto)
│   └── test/                     # Contiene todas las clases de prueba
│       ├── java/
│       │   └── com/
│       │       └── bookstore/
│       │           ├── config/
│       │           │   └── ConfigLoader.java    # Clase para cargar las propiedades del archivo config
│       │           ├── model/
│       │           │   ├── Book.java            # Clase modelo para Book
│       │           │   ├── Error.java           # Clase para manejar errores
│       │           │   └── User.java            # Clase modelo para User
│       │           ├── page/
│       │           │   ├── LoginPage.java       # Clase para la página de login (Page Object Model)
│       │           │   ├── ProfilePage.java     # Clase para la página de perfil
│       │           ├── ApiUtil.java             # Clase que inicializa Playwright y maneja RestAssured
│       │           └── UserLoginTest.java       # Clase de prueba principal que valida login y eliminación de usuario
│       └── resources/
│           └── properties.properties            # Archivo de propiedades para configurar el proyecto
├── target/                       # Archivos generados por Maven
├── .gitignore                     # Ignora archivos no relevantes para el control de versiones
├── pom.xml                        # Archivo de configuración de Maven
└── README.md                      # Documentación del proyecto
```

## Explicación de la estructura:

1. ```src/test/java/com/bookstore/config/ConfigLoader.java``` Clase encargada de cargar las propiedades desde el archivo properties.properties ubicado en src/test/resources.
2. ```src/test/java/com/bookstore/model/``` Contiene las clases de modelo (por ejemplo, Book, Error, y User), que representan objetos que retorna la api al crear el usuario.
3. ```src/test/java/com/bookstore/page/``` Implementación del Page Object Model (POM), que contiene las clases LoginPage y ProfilePage, para modelar las interacciones con las páginas de la aplicación.
4. ```ApiUtil.java``` Clase que configura y maneja Playwright para la automatización de la interfaz de usuario y RestAssured para interactuar con la API.
5. ```UserLoginTest.java``` Clase de prueba principal que valida el flujo de creación de usuario, autenticación y eliminación.
6. ```src/test/resources/properties.properties``` Archivo de configuración que contiene las propiedades como URL base, credenciales de prueba y activar/desactivar modo headless.
7. ```pom.xml``` Archivo Maven para la gestión de dependencias.


## Punto 2:
En la raíz del proyecto se encuentra la carpeta postman, en la cual agrega la collección exportada desde postam.

En esta se consumen las siguientes APIs:

- **API Earth** Imagenes satelitales 
- **API APOD** Imagen astronómica del día 
- **Mars Rover Photos** Imagenes recopiladas por los rovers en Marte