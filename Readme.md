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


## Reto 2:
En la raíz del proyecto se encuentra la carpeta postman, en la cual agrega la collección exportada desde postman.

En esta se consumen las siguientes APIs:

### **API Earth** Imagenes satelitales
```bathc
curl --location 'https://api.nasa.gov/planetary/earth/assets?lat=6.200191&lon=-75.578561&date=2024-09-01&dim=0.1&api_key=pfPbpRLijLdzA0PJ8yRb7Im8mmogydBygkIcUTTf' 
```
**Pruebas:**

Este conjunto de pruebas se ejecuta para verificar la correcta respuesta de la API de imágenes satelitales de NASA Earth, basada en la latitud, longitud y fecha proporcionadas. Las pruebas incluyen las siguientes validaciones:

- Código de estado de la respuesta (200 OK):
    Se comprueba que el código de estado HTTP sea 200, lo que indica que la solicitud fue procesada correctamente por el servidor.
    
- Validación de la URL en el cuerpo de la respuesta:
    Se verifica que el cuerpo de la respuesta contenga una URL válida que apunte a los recursos de Google Earth Engine.
  
- Validación del campo 'id' en el cuerpo de la respuesta:
    Se asegura que el campo "id" esté presente en el cuerpo de la respuesta, lo cual es fundamental para identificar el recurso solicitado.
    
- Validación del tiempo de respuesta (menor de 5 segundos):
    Se garantiza que el tiempo de respuesta de la API sea inferior a 5 segundos, comprobando el rendimiento del servicio.


### **API APOD** Imagen astronómica del día
```bathc
curl --location 'https://api.nasa.gov/planetary/apod?date=2024-01-01&api_key=pfPbpRLijLdzA0PJ8yRb7Im8mmogydBygkIcUTTf' 
```

**Pruebas:**

Estas se enfocan en validar la respuesta de la API de la "Astronomy Picture of the Day" (APOD) de la NASA, utilizando una fecha específica y una clave de API. Las validaciones que se realizan son las siguientes:

- Código de estado de la respuesta (200 OK):
    Se verifica que la API responda con un código de estado 200, lo que indica que la solicitud fue procesada exitosamente.
- Validación de la URL en el cuerpo de la respuesta:
    Se comprueba que el cuerpo de la respuesta incluya la URL de la imagen del día, asegurándose de que provenga del dominio correcto de NASA APOD.
    
- Validación del parámetro de fecha:
    Se valida que la fecha solicitada esté correctamente reflejada en la respuesta, garantizando que se reciba la imagen del día correspondiente.

- Validación del tiempo de respuesta (menor de 5 segundos):
    Se asegura que el tiempo de respuesta de la API sea inferior a 5 segundos, lo que garantiza que el servicio está respondiendo con buen rendimiento.

### **Mars Rover Photos** Imagenes recopiladas por los rovers en Marte
```bathc
curl --location 'https://api.nasa.gov/mars-photos/api/v1/rovers/Perseverance/photos?earth_date=2024-10-20&page=2&camera=NAVCAM_LEFT&api_key=pfPbpRLijLdzA0PJ8yRb7Im8mmogydBygkIcUTTf' 
```

**Pruebas:**

Estas pruebas se centra en verificar la respuesta de la API que proporciona imágenes capturadas por el rover Perseverance en Marte. 
Las pruebas se ejecutan utilizando una fecha, una página específica y la cámara NAVCAM_LEFT como parámetros de consulta. Las validaciones que se realizan son las siguientes:

- Código de estado de la respuesta (200 OK):
    Se asegura que el servidor responda con un código de estado 200, lo que indica que la solicitud fue exitosa.
- Validación de la URL de la imagen en el cuerpo de la respuesta:
    Se comprueba que el cuerpo de la respuesta contenga una URL válida que apunte a la ubicación de las imágenes en el dominio de NASA.
- Validación del parámetro de fecha:
    Se verifica que la fecha solicitada (earth_date) esté presente y coincida con la fecha proporcionada en la solicitud.
- Validación del tiempo de respuesta (menor de 25 segundos):
  Se asegura que el tiempo de respuesta de la API sea menor a 25 segundos, lo que garantiza la eficiencia del servicio.