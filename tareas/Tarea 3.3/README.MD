# Depurando el código. 
La tarea consiste en depurar el código suministrado. Realizara las siguientes actividades en el depurador de Eclipse y adjunta pantallazos para demostrarlo:
1. Definido y activado el filtrado de depuración para que no entre en ninguna librería externa.
    ![Captura 1](Captura1.JPG)
2. En el paquete factorial:
   1. Punto de ruptura en la entrada del main. Avanza de forma libre para entender el funcionamiento del código.
   ![Captura 2](Captura2.1.JPG)
   2. Punto de ruptura en la salida del método Factorial.recursivo(). Avanzo con resume y muestro el estado de las variables del método.
   ![Captura 2](Captura2.2.JPG)
   3. Punto de ruptura condicional en el método Factorial.recursivo() cuando número sea menor que 9. Avanzo con resume y muestro el estado de las variables del método. ¿Cuántas veces se activa?
   ![Captura 2](Captura2.3.JPG) 
   Se activa 8 veces
   4. Pila de llamadas en la función recursiva cuando ésta es mayor
   ![Captura 2](Captura2.4.JPG)
   5. Dos puntos de observación en Factorial.iterativo: numero y resultado. Añade puntos de ruptura y muestra el cambio de los valores en distintos pantallazos
   ![Captura 2](Captura2.5.JPG)
3. En el paquete contador:
   1. En TestContador añado un punto de ruptura en cada pasada del for y visualizo el cambio de variables.
   ![Captura 3](Captura3.1.JPG)
   2. En Contador añado un punto de ruptura para la excepción MaximoContadorException (Add Java Exception Breakpoint). Pantallazo de la vista Debug con la pila. 
    ![Captura 3](Captura3.2.JPG)
   3. Código modificado para que la excepción sea capturada y se informe al usuario de forma correcta.
    ![Captura 3](Captura3.3.JPG)
4. En el paquete calculadora:
   1. Pon un punto de ruptura cuando el divisor sea 0
    ![Captura 4](Captura4.1.JPG)
   2. Añade un punto de ruptura cuando se lance la excepción java.lang.ArithmeticException. Captura la excepción para que muestre el mensaje "No se puede realizar la división por cero" 
   ![Captura 4](Captura4.2.JPG)
   3. Modifica el main para que solicite ambos números desde teclado de forma iterativa(10 veces)
   ![Captura 4](Captura4.3.JPG)
5. Vista de puntos de ruptura expandidos y agrupados por proyectos, unos habilitados y otros no
    ![Captura 5](Captura5.JPG)
6. Vista de puntos de ruptura expandidos y agrupados por ficheros y tipos, todos anulados (Skip All Breakpoints)
 ![Captura 6](Captura6.JPG)
