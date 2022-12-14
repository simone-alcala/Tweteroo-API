<p align="center">
  <img src="https://vetores.org/d/java.svg" width="100" alt="Java Logo" />
</p>

<br/>

<p align="center">
  <img src="https://seeklogo.com/images/S/spring-boot-logo-9D6125D4E7-seeklogo.com.png" width="250" alt="Spring Logo" />
</p>

<br/>

## Description

Tweteroo API with Java + SpringBoot. Data persisted in memory.

#
## Getting started with Tweteroo API

```yml 
http://localhost:8080
```

```yml 
GET /health
    - body: { }
    - response: { "I am alive!" }
```

```yml 
POST /sign-up
    - body: 
      {
        "username": "lindo_nome",
        "avatar": "http://linda_foto.jpg"
      }
    - response: { "OK" }
```

```yml 
GET /users
    - body: { }
    - response: 
      [
        { 
          "username": "lindo_nome",
          "avatar": "http://linda_foto.jpg",
        }
      ]
```

```yml 
POST /tweets
    - body: 
      {
        "username": "lindo_nome",
        "tweet": "linda mensagem"
      }
    - response: { "OK" }
```

```yml 
GET /tweets
    - body: { }
    - response: 
      [
        { 
          "username": "lindo_nome",
          "avatar": "http://linda_foto.jpg",
          "tweet": "linda mensagem"
        }
      ]
```

#