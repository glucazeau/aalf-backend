# AALF Backend API
## Development
Use [git-flow](http://danielkummer.github.io/git-flow-cheatsheet/index.fr_FR.html)

## Build and run
`./gradlew bootRun`

## MySQL database
Use this Dockerfile:
```
FROM mysql
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE aalf
ENV MYSQL_USER aalf
ENV MYSQL_PASSWORD aalf
# MySQL dump from production
COPY aalf.sql /docker-entrypoint-initdb.d/
```
Build: `docker build -t mysql_aalf . `
Run: `docker run -it -p 3306:3306 mysql_aalf`

## Security
Username: `user`

Password: look for this line in startup logs:
> Using generated security password: 97b388d0-1064-4388-b439-a2401f76246f

## API documentation
### List of generated endpoints
http://localhost:8080

### OpenAPI endpoints
* http://localhost:8080/swagger-ui.html
* http://localhost:8080/v3/api-docs
* http://localhost:8080/v3/api-docs.yml