# Notepad: Simple Spring Boot App

This simple application is used for demo purposes. It exposes the `actuator` endpoints as well as the `/notes` endpoint, which creates a note when it gets a `POST` request.

## Usage

The Notepad stores the notes in a MySQL instance, so it expects the MySQL database to be up and running. The bellow command starts a MySQL container with a newly created database `notepad` in it. It also sets up the mysql root password as `root`.

`$ docker run -d --name mysql -e MYSQL_DATABASE=notepad -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:5.7`

Now, clone this repository and go into the notepad directory:

`$ git clone https://github.com/jorgeacetozi/notepad.git`
`$ cd notepad`

Once you succesfully cloned the repository, start the application the jar artifact:

`$ mvn clean install`

Wait for the unit and integration tests to run and the artifact to be generated. Eventually it will be stored in the `target/` directory.

Now, start the application:

`$ java -jar $(ls target/*.jar)`

Check that the application is up and running hitting the actuator `/health` endpoint:

`$ curl http://localhost:8080/health`

Create a new note:

`$ curl -H "Content-Type: application/json" -X POST -d '{"title":"Kubernetes","content":"Best container orchestration tool ever"}' http://localhost:8080/notes`

## Features

- `Flyway` to manage database migrations.
- `maven-surefire-plugin` to run only unit tests with `mvn test`.
- `maven-failsafe-plugin` to run unit and integrations tests with `mvn verify`.
- 1 simple unit test, 2 integrations tests (a api test to ensure that the JSON returned by the endpoint is correct) and a database test (saves a note and ensures that it was successfuly persisted in MySQL).
- `maven-release-plugin` to release new application versions in GitHub.
