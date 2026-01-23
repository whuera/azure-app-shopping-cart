FROM openjdk:8
COPY ./target/microservices-shopping-cart.jar /app/microservices-shopping-cart.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "microservices-shopping-cart.jar"]