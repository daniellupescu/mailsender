## mailsender

Sample SpringBoot app that sends an email using Thymeleaf and MJML.

The main class implements CommandLineRunner to run a service when the app starts.
Thymeleaf is used as an html template engine with Spring's JavaMailSender interface.
The source template is defined as a MJML file, and then transformed into an html file.
The transformation is done by the exec-maven-plugin, which runs a .bat or .sh (depending on the OS) file that uses NPM to install the MJML library and run the mjml command.

Change Maven property <java.version> to match the version of your JDK.

## Why this app?

This app does not pretend to be deployed as is, as a SpringBoot app on a server.
It is only a piece of code that anyone can copy into its SpringBoot app.

## Prerequisites
- Maven
- NPM
- JDK 8+
- Configure SMTP settings in /src/main/resources/application.yml


## Build and run the app
In the root folder:

```sh
mvn clean package
```
or

```sh
mvn spring-boot:run

```
It will first transform the MJMl file into an HTML file, and then, run the app as it implements the CommandLineRunner interface.

If you just want to do the MJML to HTML conversion, just run:
```sh
mvn initialize
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
