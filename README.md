# stewards-api



application.yml
```
server:
  port: 8081
spring:
  datasource:
    url: jdbc:postgresql://[SEU_HOST]/postgres?user=[SEU_USER]=[SUA_SENHA]
  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
    show-sql: true
```
