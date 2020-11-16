# ADMINISTRADOR DE EMPLEADOS
---
## PRECONDICIONES
- Debe estar instalado docker
- Debe estar instalado mvn 
- Debe estar instalado java
- En caso de ejecutarse en windows
    1. Ir a docker settings
    2. Resources
    3. File sharing
    4. Poner la ruta: 
        - C:\
    5. apply and restart
- Crear volumen en docker con comando: **docker volume create --name=postgresql-volume**
---
## EJECUCIÓN
1. Ubicarse en la carpeta donde se clona el proyecto
2. Ejecutar comando: **docker-compose up -d**
3. Ejecutar comando: **mvn clean install**
4. Moverse a la carpeta target
5. Ejecutar comando: **java -jar AdministradorEmpleados-1.0.0.jar** 
---
**NOTA:**
El datasource en la app esta configurado para que siempre recree las tablas, si se va ejecutar por una segunda vez y quiere mantenerse la data anterior descomentar la linea #13 del properties y comentar la #12.
---
###### Elaborado por JUAN C. ACEVEDO O.