# RESTASSURED-FOR-STUDIES

![QA CI/CD](https://github.com/uLucasFraga/restassured_for_studies/workflows/QA%20CI/CD/badge.svg)
[![ServeRest API](https://img.shields.io/badge/API-ServeRest-green)](https://github.com/PauloGoncalvesBH/ServeRest/)

Repository with automated tests for API using the frameworks: restassured and junit

> Testing and validating REST services in Java with [RESTASSURED:](https://github.com/rest-assured/rest-assured)

---

## Table of Contents

> Índice `README`.

- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Installation](#installation)
- [How to tests](#how-to-test)
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

## How to tests

Before running the tests we will need:

- Create a `config.properties` file inside the *resources folder* and insert valid values
- For example: `config.properties.example`

The valid values are below:

##### example_values:
```
APP_URL=http://localhost:3000
EMAIL_ADMIN=fulano@qa.com
EMAIL_USER=lucas.fraga@qa.com
EMAIL_INVALID=invalid
PASSWORD_INVALID=passinvalid
PASSWORD_ADMIN=teste
PASSWORD_USER=teste@123
```
###### NOTE:
This data is exposed but as a good practice (security of sensitive data) it would be interesting not to upload (via .gitignore) the file `config.properties` to the project.

> UP the ServeRest to perform the tests

`npx serverest -t 10000`

> Run all integration tests

`mvn -Dtest=AllIntegrationIT tests `

> Run all contract tests

`mvn -Dtest=AllContractIT tests `

> Run a single tests

`mvn -Dtest={your_class}#{your_test} tests`

> To clean the project, install the dependencies and skip all tests

`mvn clean install -DskipUTs=true -DskipITs=true`

> To run the tests via IDE (IntelliJ)

Right click on project/class on **restassured_for_studies > Run 'AllIT'** or **CTRL+F5**

###### IMPORTANT:
As the repository is **only for studies**,

the tests only pass with the serverest (empty/clean),

if there is new data, the tests will break.

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
