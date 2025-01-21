# Proyecto Web: API Servlet - Cabeceras HTTP
## Java | Maven | JakartaEE | HTML | JSP/Servlet

<p>Este proyecto es un ejemplo práctico desarrollado como parte de un curso de que he realizado de Java, con el objetivo de aprender a construir aplicaciones web utilizando Java Servlets.</p>
<p>Se centra en mostrar y manipular cabeceras HTTP, gestionar productos, y permitir diversas interacciones a través de formularios y exportación de datos en diferentes formatos (HTML, XLS, JSON). La aplicación implementa varios endpoints que demuestran el uso de cabeceras HTTP, peticiones y respuestas, y maneja sesiones de usuario.</p>

**Características**

- Cabeceras HTTP Request:
Muestra las cabeceras de la solicitud HTTP, incluyendo información como el método HTTP, URI, URL, IP del cliente y otras propiedades relacionadas con la solicitud.
- Productos:
Mostrar Productos en HTML: Lista de productos disponible en formato HTML.
Exportar Productos a XLS: Los productos pueden ser exportados a un archivo de Excel (XLS).
Mostrar Productos en JSON: Los productos también se pueden obtener en formato JSON para su uso en aplicaciones o APIs.
- Hora Actualizada:
Muestra la hora actualizada en tiempo real. La página se refresca automáticamente cada segundo para mostrar la hora actual.
- Login:
Implementa un formulario de login que permite al usuario autenticarse con un nombre de usuario y contraseña predefinidos (admin/1234). Si las credenciales son correctas, se muestra un mensaje de bienvenida. Si no, se devuelve un error de autorización.
- Redirección y Despacho:
Redirección: Redirige al usuario a una nueva URL.
Despacho: Redirige la solicitud interna a otra página dentro de la misma aplicación, sin que el cliente lo perciba como un cambio de URL.
- Buscar Producto:
Permite realizar una búsqueda de productos por nombre. Si el producto es encontrado, se muestra un mensaje con los detalles del producto, de lo contrario, se muestra un mensaje de error.

**Estructura del proyecto**

src/

 ├── org/
 
 │    └── juanbrenes/
 
 │         └── apiservlet/
 
 │             └── webapp/
 
 │                 └── headers/
 
 │                     ├── controllers/      # Contiene los servlets que manejan las peticiones HTTP
 
 │                     ├── models/            # Modelos que representan las entidades (Producto)
 
 │                     ├── services/          # Servicios que proporcionan lógica de negocio
 
 │                     └── webapp-headers/    # Archivos HTML y recursos estáticos

 ** Tecnologías utilizadas **

- Java con Jakarta Servlet
- Tomcat (o cualquier servidor compatible con Servlets)
- HTML
- JSON y XLS para la exportación de datos
- JSP/Servlets para la creación de páginas dinámicas
