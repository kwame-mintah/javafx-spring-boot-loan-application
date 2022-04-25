## BSS202 Library System

## Description

The Library System is a lightweight application, that allow users to loan out any items from books to toys.
This application aims to allow users to loan out any item they desire, as long as they return it on time - or 
else they will incur a fee!

## Development

### Prerequisites

The Library System uses the following software and frameworks:

* [JavaFX 18](https://openjfx.io/)
* [Scene builder](https://gluonhq.com/products/scene-builder/)
* [Docker for desktop](https://www.docker.com/products/docker-desktop/)
* [Postgres 14](https://www.postgresql.org/about/news/postgresql-14-released-2318/)
* [Springboot](https://spring.io/)

If you would like to develop this application on your local machine, please ensure you have the above installed
and configured.

### Controllers

TBA

### Class Diagram

TBA

### Usage

In order to run the application locally, you will first need to have the database running:

1. Navigate to the directory that 'bs2202librarysystem' is stored,
2. Type `docker-compose -up -d` in the root directory to start the postgres container.

This should start up the database and populate the 'library-system-db' with initial data for local usage.

After the database has been started, you can then start the local application, for IntelliJ users,
you can perform the following:

1. Right-click the 'JavaFXApplication' and click on 'Run JavaFxApplication .. Main()',
2. The first attempt may fail due to
3. Edit the 'JavaFXApplication' configuration in IntelliJ and add the following VM options:
   ```
   --module-path /your/path/to/javafx-sdk-18/lib --add-modules=javafx.controls,javafx.fxml
    ```
4. Run the application again and the application should start.

**Note**: You can use the following users to access the application: johnny.test OR ben.tennyson

## Troubleshooting

__Application throws JDBCConnectionException / PSQLException on start-up?__

Ensure that the database is up and running, the application will attempt to connect to hostname: localhost on port: 5432.
Using the username: postgres and password: password on the 'library-system-db' database. If you're running on a different 
port or the user 'postgres' does not exist. Please update the `application.properties` to reflect any of these changes.
You can either use environment variables to change the values or update the file itself.

__Unable to start application due to: 'JavaFX runtime components are missing'__

If you get this error, double check you have provided the correct path to your [javafx-sdk](https://gluonhq.com/products/javafx/) files in your VM arguments
for 'JavaFXApplication' configuration in IntelliJ.

## Contribute

TBA