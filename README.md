# RESTASSURED-FOR-STUDIES

![QA CI/CD](https://github.com/uLucasFraga/restassured_for_studies/workflows/QA%20CI/CD/badge.svg?branch=master)

Repository with automated test for API using the frameworks: restassured and junit

> Testing and validating REST services in Java with [RESTASSURED:](https://github.com/rest-assured/rest-assured)

---

## Table of Contents

> Índice `README`.

- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Installation](#installation)
- [How to test](#how-to-test)
- [Support](#support)

---

## Prerequisites

- [Install JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Install Maven](https://maven.apache.org/install.html)
- [Install IntelliJ or another IDE](https://www.jetbrains.com/idea/download/)
- [Starting with RestAssured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

## Configuration

> environment variables and bash_profile - example:

###### java: `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home`

###### maven: `export PATH=/opt/apache-maven-3.5.3/bin:$PATH`

##### Install Java
- Mac, Windows and Linux: https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos

##### Install Maven
- Mac, Windows and Linux: https://www.baeldung.com/install-maven-on-windows-linux-mac

Create a _maven_ project or use the _pom.xml_ file already created to download/install its dependencies

## Installation

> Clone project

- Clone this repo to your local machine using http or ssh, for example:

`git clone https://github.com/uLucasFraga/restassured_for_studies.git`

- Install all dependencies (pom.xml) mvn install and run tests:

`cd /your_project`

`mvn install`

![Download dependencies via Maven](http://g.recordit.co/vCNaZgadVu.gif)

> Tips

- Use pom.xml to download your new libs and keep the project running via terminal

## How to test

Before running the tests we will need:

- Create a `config.properties` file inside the resources folder and insert valid values
- Follow the pre-established pattern in the `config.properties.example` file

The valid values are below:

##### example_values:
```
APP_URL=http://localhost:3000
ENDPOINT_LOGIN=/login
ENDPOINT_USERS=/usuarios
ENDPOINT_CARTS=/carrinhos
ENDPOINT_PRODUCTS=/produtos
ENDPOINT_PURCHASE_CARTS=/carrinhos/concluir-compra
EMAIL_ADMIN=fulano@qa.com
EMAIL_USER=lucas.fraga@qa.com
PASSWORD_ADMIN=teste
PASSWORD_USER=teste@123
```
###### NOTE:
This data is exposed but as a good practice (security of sensitive data) it would be interesting not to upload (via .gitignore) the file `config.properties` to the project.

> UP the server_rest to perform the tests

`npx serverest -t 10000`

> Run all integration tests

`mvn -Dtest=AllIntegrationTests test `

> Run all contract tests

`mvn -Dtest=AllContractTests test `

> Run a single tests

`mvn -Dtest={your_class}#{your_test} test`

> To clean the project, install the dependencies and run all tests

`mvn clean install`

> To clean the project, install the dependencies and skip all tests

`mvn clean install -DskipTests`

> To run the tests via IDE (IntelliJ)

Right click on project/class on **restassured_for_studies > Run 'AllTests'** or **CTRL+F5**

---

## Support

- Twitter at <a href="https://twitter.com/uLucasFraga" target="_blank">`@ulucasfraga`</a>
- Facebook at <a href="https://www.facebook.com/lucass.fragaa" target="_blank">`my_facebook`</a>
- Linkedin at <a href="https://www.linkedin.com/in/ulucasfraga" target="_blank">`my_linkedin`</a>

- E-mail: `lucass.fragaa@gmail.com`
- Skype: `live:lucass.fragaa`

---

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2018 © <a href="https://www.linkedin.com/in/ulucasfraga" target="_blank">Lucas Fraga</a>.
