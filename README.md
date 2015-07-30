# Service Generator

> Generate a skeleton service with a one line command 

## Motivation

This project aims to minimize the time taken to deploy a Dropwizard service to production. Running the generate command
will copy most of this project into a new GitHub repository. The new project will contain a sample service with build
tasks to compile, unit test, package, deploy and acceptance test the service. The only thing it won't do (currently) is
create a new build pipeline for you.

## Requirements

* [Python](https://www.python.org/downloads/)
* [Vagrant](https://www.vagrantup.com/)
* [VirtualBox](https://www.virtualbox.org/wiki/Downloads)

## Usage

    Usage: ./generate <repo-name>
    
## Author

Jen Scobie (jenscobie@gmail.com)