	# Imagen base con JDK 17
    FROM eclipse-temurin:17-jdk

    # Directorio de trabajo en el contenedor
    WORKDIR /app

    # Copiamos todos los archivos al contenedor
    COPY . .

    # Damos permisos de ejecución al wrapper de Maven
    RUN chmod +x mvnw

    # Compilamos la aplicación
    RUN ./mvnw clean package -DskipTests

    # Exponer el puerto que Render espera (por convención, 8080)
    EXPOSE 8080

    # Comando para ejecutar el jar generado
    CMD ["java", "-jar", "target/cultivo-api-0.0.1-SNAPSHOT.jar"]
