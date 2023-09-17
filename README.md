Un gusto saludarle estimado revisor o visitante, el presente proyecto implementa un REST API para una empresa de viajes

El proyecto se ejecuta sobre docker para evitar la instalación engorrosa de dependencias, se ha utilizado el flujo
git flow, haciendo el desarrollo en una rama develop hasta culminar la feature y proceder a hacer el Pull Request a master

A continuación algunos detalles extra del proyecto

## Infraestructura:
- Backend: Java 11 + Spring Boot 2.7.9
- Base de datos: MongoDB
- Docker

## Requsitos del sistema:
- docker
- Postman (Opcional, pero muy recomendado)
- Visualizador de OpenApi 3+ (Opcional, menos recomendado que postman)
- Puertos libres del host: 8080, 27017

## Pasos para ejecutar el proyecto:
- `git clone https://github.com/DataGonza/tekbees-java-test.git`
- `cd tekbees-java-test/`
- `sudo docker compose up`
- La app se ejecuta sobre el puerto 8080

## Validar el funcionamiento:
- Para este propósito pongo a disposición una colección de postman, la tiene a su disposición en la carpeta documentation
- Otra opción es usar cualquier ejecutor de endpoints, la documentacion se encuentra en la carpeta documentation en el archivo .yml

