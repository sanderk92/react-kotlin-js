## Development

#### Deployment
In order to run this application locally, execute the following command:

```
./gradlew browserDevelopmentRun --continuous
```

<sub>*The configuration for the development server can be found in the `webpack` folder.<sub>

## Production

#### Deployment

This project contains a docker file that can be used to deploy this application. In order to run this application, 
perform the following steps:

```
./gradlew clean build
```

```
docker build -t lorem-ipsum-ui:v1 .
```

```
docker run -d -p 80:80 lorem-ipsum-ui:v1
```

## Relevant Documentation

- React
  - [React API](https://reactjs.org/docs/react-api.html)
- Kotlin-React 
  - [Hands-on](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS)
  - [Example project](https://github.com/Kotlin/full-stack-web-jetbrains-night-sample)
- Kotlin-Wrappers 
  - [Github](https://github.com/JetBrains/kotlin-wrappers) 
  - [Maven](https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers)
- Bulma CSS
  - [Docs](https://bulma.io/documentation/)
