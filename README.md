<h1 align="center">Reto alura latam (Hotel)</h1>

El proyecto consiste en desarrollar un sistema de reserva para el Hotel Alura. El hotel necesita ayuda para gestionar reservas, gestión de huéspedes y cálculos automáticos de costos.
El link del Trello es: https://trello.com/b/EXQ4nVF2/hotel-alura

## Comenzando 🚀

* Clonar el repositorio
* Crear la base de datos
* Renombrar el archivo flywayExample.properties a flyway.properties y agrege las credenciales de su base de datos
* Configurar flyway en su IDE (Se recomienda eclipse)
* Renombrar el archivo configExample.properties a config.properties y agrege las credenciales de su base de datos


### Pre-requisitos 📋

* Java 11
* IDE eclipse
* MySQL
* Scene Builder

### Instalación 🔧

Configurar flyway
Crear nuevos Maven Build en eclipse
* Click derecho al proyecto --> Run As --> Run configurations --> click derecho en Maven Build --> New configuration
* Buscar Goals y agregar lo siguiente:

```
flyway:clean
```

Repetir los pasos anteriores y agregar lo siguiente:

```
flyway:migrate
```

De esta manera podrá usar flyway y crear las tablas que se necesitan automáticamente

## Autor ✒️

* **John Angarita** - [johnangarita](https://github.com/Jnangarita)
