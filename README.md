# MavenIn28Minutes
Code for our maven tutorial

Maven in28Minutes

0. What is Maven?
	Every Day Developer
		Build a jar or a war or an ear
		Run the application locally - Tomcat or Jetty
		Deploy to a T environment
		Add new dependencies to a project
		Run Unit Tests
	Maven helps us do all these and more...
		Generate Projects
		Create Eclipse Workspace

1. Beginner Maven Project
	What is the power of Maven?
	Project Object Model (POM)
		Name
		Version
		Packaging
		Dependencies
		Plugins
	Build LifeCycle
		Validate
		Compile
		Test
		Package
		Integration Test
		Verify
		Install
		Deploy

2. Intermediate Maven Project
	Dependency Management
		Scope
		Transitive Dependencies
		Excluding Dependency
		Dependency Versions
	Sample Project Object Model
		Maven Plugins
		Convention over configuration
			Source Code
				${basedir}/src/main/java
				${basedir}/src/main/resources
			Test Code
				${basedir}/src/test
	Hierarchy of POMS
		Super POM

3. Multi Module Maven Project
	Dependency Management in Parent POM
Installation Guide

4. Maven Web Application
	Packaging
		War
		Ear
	Running application in Tomcat	5. Tip and Tricks
	Important Commands
		help:effective-settings
		help:effective-pom
		dependency:tree
		dependency:sources
		--debug
	Maven Archetypes
		archetype:generate
