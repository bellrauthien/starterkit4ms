# starterkit4ms
## Spring Boot
### Demo
Proyecto demo para la creación de un servicio REST usando Spring Boot y Gradle.

Clonar repositorio:
`git clone https://github.com/bellrauthien/starterkit4ms.git`

Ruta de la aplicacion demo:
code/java/microservices/springboot/demo

Ejecutar la aplicación con Gradle:
`gradle bootRun`

Probar los recursos expuestos con HTTPie:
1. Get All (JSON por default): `http :8080/entities`
2. Get All (XML): `http :8080/entities Accept:'application.xml'`
3. Get By Id: `http :8080/entities/1`
4. Create: `http POST :8080/entities description='Entidad 4'`
5. Update: `http PUT :8080/entities/4 description='Entidad 4-v2'`
6. Delete: `http DELETE :8080/entities/4`