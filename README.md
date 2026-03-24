# Math service
Problema:
Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para computar las funciones numéricas.  El servicio de las funciones numéricas debe estar desplegado en al menos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes  y se las delegue a las dos instancias del servicio numérico usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2. Asegúrese de poder configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba el valor y de manera asíncrona invoke el servicio en el PROXY. Puede hacer un formulario para cada una de las funciones. El cliente debe ser escrito en HTML y JS.

 <img width="1288" height="674" alt="image" src="https://github.com/user-attachments/assets/28621a75-5c8c-41e4-bb0d-97da7c880be7" />

 
Detalles adicionales de la arquitectura y del API
Construya una aplicación web para investigar este problema. La aplicación debe tener esta arquitectura:
Cliente asíncrono que corra en el browser escrito en HTML5 y JS (No use librerías, solo html JS básico). 
El cliente NO COMPUTA LA SECUENCIA DIRECTAMENTE, sino que la delega a un servicio REST corriendo en AWS.
El servicio REST puede ser GET o POST.
Se debe construir la aplicación usando Spring Boot y desplegarla en un contenedor corriendo en AWS.
Cree un solo repositorio en github para toda la aplicación
Use los mejores estándares de diseño, arquitectura y programación.




Fibonacci con ventana (suma móvil K=3)
Su servicio matemático debe incluir una función:

fibwin(n) retorna un JSON con la serie de Fibonacci desde F_0 hasta F_n y la suma móvil de ventana K=3 aplicada a esa serie. (Recibe enteros n ≥ 2).
Definición
Fibonacci: F_0=0, F_1=1, F_n=F_{n-1}+F_{n-2} para n ≥ 2.
Ventana K=3: para la lista [a0, a1, …, am], la suma móvil es [a0+a1+a2, a1+a2+a3, …].

Implementación requerida
(1) Genere Fibonacci de forma iterativa. (2) Calcule la suma móvil recorriendo la lista y sumando tramos contiguos de longitud 3. No use funciones de librería que implementen rolling windows.

Detalles de API

Responda a HTTP GET. Nombre del endpoint: /fibwin. Parámetro en query: value.

Ejemplo de llamado (EC2)

https://amazonxxx.x.xxx.x.xxx:{port}/fibwin?value=10

Salida (JSON)

{


## INSTRUCCIONES PARA DESPLEGAR EN EC2
Aqui
  "operation": "Fibonacci con ventana K=3",
  "input": 10,
  "output": "serie: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 | ventana: 2, 4, 6, 10, 16, 26, 42, 68, 110"
}
