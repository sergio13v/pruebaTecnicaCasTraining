# pruebaTecnicaCasTraining
Proyecto Java que se conecta a una DB MySQL y genera un archivo de texto plano. Utiliza Maven y la dependencia mysql-connector-j

En este repositorio GitHub está el proyecto en sí, el script de creación de la DB y el .jar ejecutable.

El script.sql debe importarse en una DB llamada prueba_tecnica puesto que en el código se hace referencia a ese nombre de DB. La DB deberá estar en localhost:8889. Todo esto puede modificarse en la linea 16 de la clase DbConexionUtil

El archivo de texto plano se genera en C:\ Se puede cambiar la ruta en la linea 19 de la clase proveedoresController.

El programa debe ejecutarse desde la línea de comandos mediantes java -jar pruebaTecnica.jar "id del cliente, por ejemplo 5".