Este código forma parte de una herramienta de gestión básica de archivos desarrollada en Java.
A través de la creación, eliminación, copia y movimiento de archivos y directorios, este programa demuestra
cómo utilizar de manera eficaz las clases de java.nio.file y gestionar errores mediante bloques try-catch.
Además, la interacción con el usuario y el uso de estructuras condicionales hacen que este programa sea ideal 
para estudiantes que están aprendiendo las bases de la programación orientada a objetos y la manipulación de archivos en Java.

Lecciones Clave que se absorve de este proyecto:
Manejo de Excepciones:

El código hace uso de bloques try-catch para manejar posibles errores,
como fallos en la creación o eliminación de archivos. Esto enseña la 
importancia de manejar adecuadamente las excepciones para evitar que el programa falle abruptamente.

Manipulación de Archivos y Directorios:
Los métodos en esta clase proporcionan una excelente introducción a la 
manipulación de archivos usando la API de NIO de Java (java.nio.file), la 
cual es más robusta y flexible que la API de IO tradicional.

Interacción con el Usuario:
En el método de eliminación, se introduce el uso de la clase Scanner para 
recibir entradas del usuario. Esto enseña cómo interactuar con el usuario 
de manera sencilla.

Verificación de Existencia de Archivos:
En todos los métodos se verifica la existencia de los archivos o directorios
antes de realizar operaciones. Esto es un buen hábito a desarrollar para evitar errores
innecesarios en los programas.

Eliminación Segura:
Antes de copiar o mover un archivo, el código elimina cualquier archivo existente en
la ubicación de destino. Esto garantiza que no se presenten conflictos o errores por
archivos duplicados.

/*ten en cuenta que esto no es un crud y si es lo que buscas no recomiendo este repositorio*/
