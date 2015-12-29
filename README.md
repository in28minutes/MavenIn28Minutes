# Maven Tutorial for Beginners - with Examples In28Minutes

Video for this tutorial : https://www.youtube.com/watch?v=0CFWeVgzsqY

Code for our maven tutorial

Maven in28Minutes

In this course, we will use Handson Real World Examples to understand what Maven can do. We will understand how Maven makes the life of an application developer easy. We will learn how Maven helps us to automate things like compilation, running unit tests, creating a war, creating an ear, running a web application in tomcat. We will learn how to use Maven effectively in combination of an IDE like Eclipse. 

Lets now look at the steps in this tutorial. 
- Step 1 to 4 we will learn about the basics of Maven : Project Object Model and Build LifeCycle
- Steps 5 and 6 we will learn about dependency management and transitive dependencies
- Step 7 we will learn about a maven project with multiple layers. Typical projects have a web layer, data layer, external interface layer. We will learn how to create such projects using maven. Multi Module Maven Project.
- Step 8 : We will learn how to create a war, deploy to tomcat.

#0. What is Maven?
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

#1. Beginner Maven Project
##	First Project : My aim is to create a Spring.jar. Think as if you are developing Spring. Some other developers want to use the framework you are developing. Steps in creating a JAr
- App.Java -> App.class
- AppTest.Java -> AppTest.class
- Run Unit Tests
- Package in a particular format
- Earlier this was done using long tedious ant scripts
##	What is the power of Maven?
##	Project Object Model (POM)
		Name
		Version
		Packaging
		Dependencies
		Plugins
##	Build LifeCycle
		Validate
		Compile
		Test
		Package
		Integration Test
		Verify
		Install
		Deploy

#2. Intermediate Maven Project
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

#3. Multi Module Maven Project
	Dependency Management in Parent POM
##Installation Guide

#4. Maven Web Application
##	Packaging
		War
		Ear
##	Running application in Tomcat	

#5. Tip and Tricks
##	Important Commands
		help:effective-settings
		help:effective-pom
		dependency:tree
		dependency:sources
		--debug
##	Maven Archetypes
		archetype:generate

#6. Missing (To Discuss)
## Plugins
		Show in super pom.xml
