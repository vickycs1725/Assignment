# How To Run this Script *

**Steps to run **

 -  Install Java 8.1+
 - Install Eclipse
 - Import project from github
 - Update maven project
 - Run using TestNg or Maven 
 - Extent report will be generated in AssignMent_Project/src/main/java/com/demo/report
 -Reports are generated by name of current date and Time

## Overview of Test Script tools used

 - Tools Used         : *Selenium-WebDriver , Eclipse* 
 - Language used      : *Selenese*
 - FrameWork used     : *Hybrid Framework(TestNG,Keyword driver,Method driven) with integration of Design pattern POM (Page Object model)*
 - Dependency used    : *Maven(Project management tool) reader),Log-4J(log generator),Extent report(Advanced report generator)*

## Overview Of Page Object Model
      
	 - The Page object is an object-oriented class which acts as an interface for the page of your Application under test. 
	 - Page class contains web elements and methods to interact with web elements. 
	While Automating the test cases, we create the object of these Page Classes and interact with web elements by calling the methods of these classes. 

## Advantages of POM model

 - Reusability : We can reuse the page class if required in different test cases which means we don’t need to write code for identifying the web elements and methods to interact with them for every test case.

 - Maintainability : As we can see from the above picture test case and page class are different from each other which means we can easily update the code if any new web element is added or existing one updated.

 - Readability : page code is separated form test code which helps to improve code readability.






