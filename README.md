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
docker build -t kotlin-js-react:v1 .
```

```
docker run -d -p 80:80 kotlin-js-react:v1
```

## Relevant Documentation

  - [React](https://reactjs.org/docs/react-api.html)
  - [Kotlin-JS](https://kotlinlang.org/docs/js-get-started.html)
  - [Kotlin Wrappers](https://github.com/JetBrains/kotlin-wrappers) 
  - [Docs](https://bulma.io/documentation/)
