# Maven Tutorial for Beginners - with Examples In28Minutes

[![Image](https://www.springboottutorial.com/images/Course-Maven-Tutorial-Manage-Java-Dependencies-in-20-Steps.png "Maven Tutorial - Manage Java Dependencies in 20 Steps")](https://www.udemy.com/course/learn-maven-java-dependency-management-in-20-steps/)

## Installing Eclipse and Java
https://github.com/in28minutes/SpringIn28Minutes/blob/master/InstallationGuide-JavaEclipseAndMaven_v2.pdf

## Course Overview
- We will use Handson Real World Examples to understand what Maven can do. 
- We will understand how Maven makes the life of an application developer easy. 
- We will learn how Maven helps us to automate things like compilation, running unit tests, creating a war, creating an ear, running a web application in tomcat. 
- We will learn how to use Maven effectively in combination of an IDE like Eclipse. 
- We will use 
  - Maven for dependency management, building and running the application in tomcat.
  - Eclipse IDE.

### Step List
Lets now look at the steps in this tutorial. 
- Step 1 to 4 we will learn about the basics of Maven : Project Object Model and Build LifeCycle
- Steps 5 and 6 we will learn about dependency management and transitive dependencies
- Step 7 we will learn about a maven project with multiple layers. Typical projects have a web layer, data layer, external interface layer. We will learn how to create such projects using maven. Multi Module Maven Project.
- Step 8 : We will learn how to create a war, deploy to tomcat.

### Running Examples
- If you are downloading the zip file, unzip the file
- Open Command Prompt and Change directory to folder containing pom.xml
- Run command "mvn tomcat7:run"
- For help : user our installation guide - https://github.com/in28minutes/SpringIn28Minutes/blob/master/InstallationGuide-JavaEclipseAndMaven_v2.pdf

### Youtube Video
https://courses.in28minutes.com/p/maven-tutorial-for-beginners-in-5-steps

# 0. What is Maven?
Defining what Maven does is very difficult. 
##	Every Day Developer
		Manages Dependencies - Web Layer (Spring MVC), Data Layer (JPA - Hibernate) etc..                  
		Build a jar or a war or an ear
		Run the application locally - Tomcat or Jetty
		Deploy to a T environment
		Add new dependencies to a project
		Run Unit Tests
##	Maven helps us do all these and more...
		Generate Projects
		Create Eclipse Workspace

# 1. Beginner Maven Project
##	What is the power of Maven?
####	First Project : My aim is to create a Spring.jar. Think as if you are developing Spring. Some other developers want to use the framework you are developing. Steps in creating a JAr
- App.Java -> App.class
- AppTest.Java -> AppTest.class
- Run Unit Tests
- Package in a particular format
- Earlier this was done using long tedious ant scripts

#### Convention over Configuration
- Pre defined folder structure
- pom.xml
- mvn --version
- mvn compile (compiles source files)
- mvn test-compile (compiles test files) - one thing to observe is this also compiles source files
- mvn clean - deletes target directory
- mvn test - run unit tests

## You are ready for theory on Build Life Cycle

Pre-defined sequence of steps that are done when we run a maven command. Plugins can be attached to lifecycle stages. Default plugins are already defined in the super pom.

mvn install 
- package - creates the jar
- install - copies the created jar to local maven repository - a temp folder on my machine where maven stores the files.

###	Build LifeCycle 
		Validate
		Compile
		Test
		Package
		Integration Test
		Verify
		Install
		Deploy

## Lets understand pom.xml

###	Project Object Model (POM)
		Name (if another project want to refer to our project, how do they do it?)
		Version (Major Version, Minor Version, Incremental Version)
		Packaging 
		Dependencies
		Plugins


###  Maven repository stores all the versions of all dependencies. JUnit 4.2,4.3,4.4
###  Local Repository - all the dependencies that are downloaded for 1st time are stored.


# 2. Intermediate Maven Project

- Transtive Dependencies (add Hibernate dependency)
- Exclusions - Add an exclude
- Dependency Hierarchy - See how each dependency is coming in
- Versions [4.1,] [,4.1] [,4.1)
- Scope - Dependencies are needed only for tests. They are not part of the war or jar. we can use scope for that.
- Maven Compiler Plugin - Change source from 1.5 to 1.8.
- Effective Pom - Super Pom (Similar to Java Inheritance) - Check the build part of super pom (Convention over configuration - defaults are defined). We can change it - for example source directory. Recommended not to override defaults. Easy to move from one project to another project. Definitions of various plugins. mvn help:effective-pom

##	Dependency Management
		Scope
		Transitive Dependencies
		Excluding Dependency
		Dependency Versions
##	Sample Project Object Model
		Maven Plugins
		Convention over configuration
			Source Code
				${basedir}/src/main/java
				${basedir}/src/main/resources
			Test Code
				${basedir}/src/test
##	Hierarchy of POMS
		Super POM

# 3. Multi Module Maven Project
- Most projects have multiple layers. Each layer has its own dependencies. Also multiple layers may share same dependency. We will see the best practices in managing dependencies in a multi module maven project.
- Parent pom has type pom
- - Defines Modules
- Dependency Management Section
- Properties
- Pre-defined Variables ${project.version}
- Run from command prompt - mvn clean install

# 4. Maven Web Application
##	Packaging
		War
		Ear
##	Running application in Tomcat	

# 5. Tip and Tricks
##	Important Commands
		help:effective-settings
		help:effective-pom
		dependency:tree
		dependency:sources
		--debug
##	Maven Archetypes
		archetype:generate

# 6. Missing (To Discuss)
- Plugins : Show in super pom.xml
- Eclipse Integration
- Profiles


### Expectations
- You should know Java. 

### Running Examples
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the right project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application
- You are all Set

### Troubleshooting
- Refer our TroubleShooting Guide - https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ

## Youtube Playlists - 500+ Videos

[Click here - 30+ Playlists with 500+ Videos on Spring, Spring Boot, REST, Microservices and the Cloud](https://www.youtube.com/user/rithustutorials/playlists?view=1&sort=lad&flow=list)

## Keep Learning in28Minutes

in28Minutes is creating amazing solutions for you to learn Spring Boot, Full Stack and the Cloud - Docker, Kubernetes, AWS, React, Angular etc. - [Check out all our courses here](https://github.com/in28minutes/learn)
