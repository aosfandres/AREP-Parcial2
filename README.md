# AREP-Parcial2

Diseñé, construya y despliegue los siguientes servicios en un microcontenedor docker desplegado en una instancei a EC2 de AWS y otro desplegador en AWS lambda con AWS gateway. Cada estudiante debe seleccionar para desarrollar dos funciones matemáticas de acuerdo a los dos últimos dígitos de su cédula como se especifica en la lista (Si sus dos últimos dígitos de su cédula son el mismo use el siguiente dígito que sea diferente). Todas las funciones reciben un solo parámetro de tipo "Double" y retornan una parámetro de tipo "Double".


0. log

1. ln

2. sin

3. cos

4. tan

5. acos

6. asin

7. atan

8. sqrt

9. exp (el número de eauler elevado ala potendia del parámetro)


Implemente los servicios para responder al método de solicitud HTTP GET. Deben usar el nombre de la función especificado en la lista y el parámetro debe ser pasado en la variable de query con nombre "value".


Ejemplo de una llamado:

EC2
https://amazonxxx.x.xxx.x.xxx:{port}/cos?value=3.141592

Lambda + API Gateway
https://amazonxxx.x.xxx.x.xxx/sin?value=3.141592


Salida. El formato de la salida y la respuesta debe ser un JSON con el siguiente formato

{

 "operation": "cos",

 "input":  3.141592,

 "output":  -0.999999

}
 
# VIDEO

https://github.com/aosfandres/AREP-Parcial2/blob/main/video.mp4

# EVIDENCIAS

## Prueba local

Se implemento el codigo correspondiente y se prueba localcmente su funcionamiento

- Pagina principal

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/1.PNG)

- Prueba TAN

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/2.PNG)

- Prueba ASIN

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/3.PNG)

## Prueba docker y aws

Una vez el codigo sirve se creo el Dockerfile y se procedio a crear la imagen, una vez creada se desplego en un contenedor que referencia al repositorio creado en DockerHub, posterior a esto se creo una instancia Ec2 de aws y se cambiaron sus grupos de seguridad para permitir el acceso por el puerto 4567 que fue elegido para correr el servicio. Una vez creada la instancia se instalo docker, se creo la instancia traida de dockerHub y se corrio con el comando run de docker. Posterior a esto ya se pudo probar como se muestra en las siguientes imagenes.

- Repo creado y listo para despliege

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/4.PNG)

- En este punto se desplego en intacia AWS http://ec2-54-144-238-170.compute-1.amazonaws.com:4567/

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/5.PNG)

- Prueba Tan en aws

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/6.PNG)

- Prueba Asin aws

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/7.PNG)

## Prueba AWS Lambda y API Gateway

Para la implemtetacion lambda se creo una nueva clase llamada Lambda, que contiene las dos operaciones necesarias. Se compilo el proyecto para que generar el .jar correspondiente y se crearon dos servicios de Lambda donde se se subio el .jar del proyecto y se refencio a la clase Lambda a cada uno de lo metodos. Posterior a esto se crea el API Gateway que referencia a esos dos servicios de Lambda con metodo GET.

- Se crean los servicios Lambda que contienen Tan y Asin respectivamente

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/9.PNG)

- Se crean los metodos y recursos correspondientes 

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/8.PNG)

- Se implementa el API y se prueba y ademas permite ser consultada una vez implemntada por esta direection: https://q71uuwsz9k.execute-api.us-east-1.amazonaws.com/parcial2/asin?value=-1 aca podemos cambiar el valor y la fincion antes del valor es decir /tan?value=1 o /asin?value=-1 

- Prueba para Asin desde el API

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/10.PNG)

- Prueba para Tan desde el API

![](https://github.com/aosfandres/AREP-Parcial2/blob/main/images/11.PNG)

# AUTOR

ANDRES ORLANDO SOTELO FAJARDO

# DOCUMENTACION

https://github.com/aosfandres/AREP-Parcial2/tree/main/doc

# LICENCIA

https://github.com/aosfandres/AREP-Parcial2/blob/main/LICENSE

