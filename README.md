# junit-jpa-springboot

Example console app to show jpa (repository), junit tests, spring boot tests and code coverage wiuth JaCoCo. 

# Build

```
mvn clean install
```

# Run

```
java -Dspring.profiles.active=prod -jar target/junit-jpa-springboot-0.1.0.jar
```

# Code coverage report

Available after ```mvn clean install``` in target/site/jacoco/com.mooo.bitarus/index.source.html
