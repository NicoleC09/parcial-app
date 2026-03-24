# Math service
Problema:
Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para computar las funciones numéricas.  El servicio de las funciones numéricas debe estar desplegado en al menos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes  y se las delegue a las dos instancias del servicio numérico usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2. Asegúrese de poder configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba el valor y de manera asíncrona invoke el servicio en el PROXY. Puede hacer un formulario para cada una de las funciones. El cliente debe ser escrito en HTML y JS.

 
 
Detalles adicionales de la arquitectura y del API
Construya una aplicación web para investigar este problema. La aplicación debe tener esta arquitectura:
Cliente asíncrono que corra en el browser escrito en HTML5 y JS (No use librerías, solo html JS básico). 
El cliente NO COMPUTA LA SECUENCIA DIRECTAMENTE, sino que la delega a un servicio REST corriendo en AWS.
El servicio REST puede ser GET o POST.
Se debe construir la aplicación usando Spring Boot y desplegarla en un contenedor corriendo en AWS.
Cree un solo repositorio en github para toda la aplicación
Use los mejores estándares de diseño, arquitectura y programación.
