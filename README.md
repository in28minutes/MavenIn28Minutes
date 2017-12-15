# Maven Tutorial for Beginners - with Examples In28Minutes
## Caption for the course.

* [Course Overview](#course-overview)
  - [Course Steps](#step-list)
  - [Expectations](#expectations)
  - [Running examples](#running-examples)
* [About in28Minutes](#about-in28minutes)
  - [Our Beliefs](#our-beliefs)
  - [Our Approach](#our-approach)
  - [Find Us](#useful-links)
  - [Other Courses](#other-courses)

## Installing Eclipse and Java
https://github.com/in28minutes/SpringIn28Minutes/blob/master/InstallationGuide-JavaEclipseAndMaven_v2.pdf

## Todo
- Profiles
- Surefire Plugin Reports 
- Automation Testing (Selenium) Reports

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

## Conclusion
- Thats a lot of ground we covered over the last so and so..
- To find out more about *** use these References  
- We had fun creating this course and we are sure you had some fun too.
- Good Luck and Bye from the team here at in28Minutes
- Do not forget to leave us a review.

## About in28Minutes
- At in28Minutes, we ask ourselves one question everyday. How do we create more effective trainings?
- We use Problem-Solution based Step-By-Step Hands-on Approach With Practical, Real World Application Examples. 
- Our success on Udemy and Youtube (2 Million Views & 12K Subscribers) speaks volumes about the success of our approach.
- While our primary expertise is on Development, Design & Architecture Java & Related Frameworks (Spring, Struts, Hibernate) we are expanding into the front-end world (Bootstrap, JQuery, Angular JS). 

### Our Beliefs
- Best Course are interactive and fun.
- Foundations for building high quality applications are best laid down while learning.

### Our Approach
- Problem Solution based Step by Step Hands-on Learning
- Practical, Real World Application Examples.
- We use 80-20 Rule. We discuss 20% things used 80% of time in depth. We touch upon other things briefly equipping you with enough knowledge to find out more on your own. 
- We will be developing a demo application in the course, which could be reused in your projects, saving hours of your effort.
- All the code is available on Github, for most steps.

### Other Courses

- [Check out all our courses with 100,000 Students](https://courses.in28minutes.com/courses)
- [25 Videos and Articles for Beginners on Spring Boot](http://www.springboottutorial.com/spring-boot-tutorials-for-beginners)
- Our Best Courses with 66,000 Students and 4,000 5-Star Ratings
  * [Java Interview Guide : 200+ Interview Questions and Answers](https://www.udemy.com/java-interview-questions-and-answers/?couponCode=JAVA_INTER_GIT)
  * [First Web Application with Spring Boot](https://www.udemy.com/spring-boot-first-web-application/?couponCode=SPRING-BOOT-1-GIT)
  * [Spring Boot Tutorial For Beginners](https://www.udemy.com/spring-boot-tutorial-for-beginners/?couponCode=SPRING-BOOT-GIT)
  * [Mockito Tutorial : Learn mocking with 25 Junit Examples](https://www.udemy.com/mockito-tutorial-with-junit-examples/?couponCode=MOCKITO_GIT)
  * [Java EE Made Easy - Patterns, Architecture and Frameworks](https://www.udemy.com/java-ee-design-patterns-architecture-and-frameworks/?couponCode=EEPATTERNS-GIT)
  * [Spring MVC For Beginners : Build Java Web App in 25 Steps](https://www.udemy.com/spring-mvc-tutorial-for-beginners-step-by-step/?couponCode=SPRINGMVC-GIT)
  * [JSP Servlets For Beginners : Build Java Web App in 25 Steps](https://www.udemy.com/learn-java-servlets-and-jsp-web-application-in-25-steps/?couponCode=JSPSRVLT-GIT)
  * [Java OOPS in 1 Hours](https://www.udemy.com/learn-object-oriented-programming-in-java/?couponCode=OOPS-GIT)
  * [C Puzzle for Interview](https://www.udemy.com/c-puzzles-for-beginners/?couponCode=CPUZZLES-GIT)
  
### Useful Links
- [Our Website](http://www.in28minutes.com)
- [Facebook](http://facebook.com/in28minutes)
- [Twitter](http://twitter.com/in28minutes)
- [Google Plus](https://plus.google.com/u/3/110861829188024231119)
