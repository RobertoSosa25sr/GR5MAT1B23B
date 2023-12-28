# Utiliza la imagen base de Tomcat con la versión específica
FROM tomcat:10.1.15-jre21

# Copia el archivo WAR desde la carpeta local a la carpeta webapps del contenedor
COPY ./target/GR5MAT1B23B-1.0.war /usr/local/tomcat/webapps/GR5MAT1B23B-1.0.war

# Expone el puerto 8081 para acceder a la aplicación
EXPOSE 8081

# Inicia el servidor Tomcat
CMD ["catalina.sh", "run"]

# Ejecutar los siguientes comandos en la consola
# Desde la ubicación donde se encuentra tu Dockerfile
# docker build -t taskmaker .
# Ejecutar el contenedor exponiendo el puerto 8081
# docker run -p 8081:8080 taskmaker
# En el navegador colocar http://localhost:8081/GR5MAT1B23B-1.0
