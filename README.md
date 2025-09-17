## API de Reservas Turísticas - Spring Boot

Este proyecto es una API RESTful desarrollada con Spring Boot para gestionar la búsqueda y reserva de hoteles y vuelos para una agencia de turismo. La aplicación permite a los usuarios consultar la disponibilidad y realizar reservas de manera eficiente.




## Acknowledgements

- Gestión de Hoteles
Obtener un listado completo de hoteles.
Filtrar hoteles disponibles por rango de fechas y destino.
Realizar reservas de habitaciones, calculando el monto total de la estadía.

- Gestión de Vuelo
Obtener un listado completo de vuelos.
Filtrar vuelos disponibles por fechas, origen y destino.
Realizar reservas de vuelos para múltiples pasajeros.

## Arquitectura

- API RESTful con endpoints claros y definidos para cada funcionalidad.
- Arquitectura en capas (Controlador, Servicio, Repositorio) para separar responsabilidades.
- Uso de DTOs (Data Transfer Objects) y Mappers (MapStruct) para una comunicación segura y eficiente entre las capas.

## Tecnologías Utilizadas

Backend: Java (17+) y Spring Boot

Base de Datos: H2 (Base de datos en memoria para desarrollo)

Gestión de dependencias: Maven

Librerías clave:

Spring Web

Spring Data JPA

Lombok

MapStruct

Swagger / OpenAPI 3 (para documentación de API)

## Entorno de Desarrollo 
IDE: Visual Studio Code

Extensiones Clave en VS Code:

Extension Pack for Java (Microsoft)

Spring Boot Extension Pack (VMware)

Spring Initializr Java Support (Microsoft)



## API Reference

#### Get all items

```http
  GET /api/v1/hotels
```



#### Get item

```http
  GET /api/items/hotels?dateFrom={availableFrom}&dateTo={availableTo}&destination={place}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `availableFrom`      | `fecha desde` | Agregar fecha desde |
| `availableTo`      | `fecha hasta` | Agregar fecha hasta |
| `place`      | `lugar` | Agregar el lugar, ciudad destino |


```http
  POST /api/v1/booking
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `content-type` | `application/json` | JSON |

JSON:
   ```json
{
  "userName": "PRUEBATEST",
  "booking": {
    "dateFrom": "2025-09-11",
    "dateTo": "2025-09-11",
    "destination": "La Plata",
    "codeHotel": "CH-1900",
    "peopleAmount": 2,
    "roomType": "Doble",
    "people": [
      {
        "dni": 1073741824,
        "name": "Prueba",
        "lastname": "Test",
        "birthDate": "2025-09-11",
        "mail": "pruebats@mail.com"
      }
    ],
    "paymentMethod": [
      {
        "type": "credito",
        "number": "5456789668456789",
        "dues": 3
      }
    ]
  }
}

```http
  GET /api/v1/flights
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `content-type` | `application/json` |  |

```http
  GET /api/v1/flight-reservation
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `content-type` | `application/json` | JSON |

```json
{
  "userName": "mari",
  "flightReservation": {
    "dateFrom": "2025-09-12",
    "dateTo": "2025-09-13",
    "origin": "Buenos Aires",
    "destination": "Bogotá",
    "flightNumber": "CUCI-8989",
    "seats": 26,
    "seatType": "Economy",
    "people": [
      {
        "dni": 1073741824,
        "name": "mari",
        "lastname": "james",
        "birthDate": "2000-09-12",
        "mail": "@mar"
      }
    ],
    "paymentMethod": [
      {
        "type": "credito",
        "number": "76345678998",
        "dues": 3
      }
    ]
  }
}
