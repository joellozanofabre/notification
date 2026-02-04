# Despription

The application is implemented as a modular monolith using Hexagonal Architecture and Domain-Driven Design principles.

This approach allows fast development while keeping clear boundaries between domain, application, and infrastructure
layers.

Event-driven communication using Apache Kafka is used to decouple notification creation from delivery, enabling future
scalability and easy evolution into microservices if required.

# Explicación de la Navegabilidad y Flujo

El flujo sigue el Principio de Inversión de Dependencia:

## Entrada (Input Adapter): El NotificationController recibe un DTO. Llama a la interfaz CreateNotificationUseCase (puerto de entrada).

Lógica (Application Service): La implementación en application.service coordina:
Usa el NotificationRepository (puerto de salida) para guardar en la DB.
Usa el NotificationEventPublisher (puerto de salida) para enviar un mensaje a Kafka.

## Procesamiento Asíncrono (Kafka):

Un NotificationKafkaConsumer (en infrastructure.input.kafka) escucha ese mensaje.
Llama al caso de uso SendNotificationUseCase.
Salida Final (Output Adapter):
Este caso de uso utiliza el Patrón Strategy para elegir el adaptador correcto en infrastructure.output.external (Email,
SMS o Push) y realizar el "envío" simulado.



“Used ddl-auto=update for simplicity in this challenge.”


# Requerimientos funcionales-------------------------

1. Autenticación de Usuarios 
   2. Registro de usuario con email y contraseña.
   3. Inicio de sesión que devuelva un token de  acceso.
   4. Los endpoints deberán requerir token válido para ser accedidos.
2. Gestión de Notificaciones 
   3. Crear una notificación (campos: título, contenido, canal).
   4. Modificar una notificación existente.
   5. Eliminar una notificación.
   6. Consultar todas las notificaciones propias.
3. Envío de Notificación
   1. Cada vez que una notificación sea creada, deberá ejecutarse el "envío" de la misma por el
         canal  especificado.
   2. Los canales disponibles son:
         - Email
         - SMS
         - Push Notification
   3. Cada canal debe requerir una lógica de envío distinta, simulando pasos específicos por canal.
   Por   ejemplo:
  - Email: Validar el formato del destinatario, generar un template, registrar el envío.
  - SMS: Limitar el contenido a 160 caracteres, registrar número y fecha de envío.
  - Push Notification: Validar el token de dispositivo, formatear el payload, registrar el estado del
    envío.- La lógica debe estar preparada para que agregar un nuevo canal no implique modificar la lógica
    existente.

  ## Requerimientos técnicos------------------------ 
  - Base de datos relacional (PostgreSQL, MySQL, SQLite, etc.).
  - API RESTful utilizando la tecnología de backend que prefieras.
  - El candidato puede optar por agregar un frontend  simple para consumir los endpoints, pero no es
    obligatorio.

##  Criterios de evaluación----------------------
  -  Se evaluará:- La claridad y organización del código.- 
  - La arquitectura elegida para manejar los distintos canales  de notificación y sus lógicas. 
  - La correcta implementación de la autenticación y autorización.
  - La escalabilidad y  mantenibilidad del sistema.
  - El uso adecuado de la base de datos.
  - El proyecto debe ser entregado aplicando las mejores prácticas que el candidato considere
    adecuadas, tanto a nivel de código, arquitectura, seguridad y documentación.

##  Entrega------
  - Incluí un README con: 
    - Instrucciones de instalación y ejecución.
    - Breve descripción de las decisiones técnicas  tomadas
  

unit testing: testear las partes
debe ser atomico y no probar nada externo, para eso se mockea
que o sea rigido

integration test

