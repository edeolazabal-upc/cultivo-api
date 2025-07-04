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

    # Comando para ejecutar el jar generado
    CMD ["java", "-jar", "target/cultivo-api-0.0.1-SNAPSHOT.jar"]
