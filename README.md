**JavaSelenium Clocksoftware**
It is a Selenium Java based test automation framework and the test scripts written for Clock Software site https://www.clock-software.com/demo-clockpms/index.html

It has following features:

-> Page object Model

-> Extent HTML Report with screenshot

-> BDD with Cucumber

-> Screenshot for both pass and fail steps

-> CI/CD configurable

Import the project in eclipse as Maven project

To run using IDE, Right-click on Runner class and select Run as JUnit

To run using command line , use command ```mvn clean verify```

To run cucumber tests with tags , use command ```mvn clean verify -D"cucumber.filter.tags=@order"```

Html report can be found under target/index.html
 
### Further Improvements:
Parallel execution for distributed execution

Multiple browsers handling for cross-browser testing

Extent report for better reporting

JIRA API integration to update the results in JIRA after the test execution


# Jenkins Setup:

**Source Code Management:** Git : https://github.com/ayosuva/SeleniumBDD

**Branches to build:** */main

**Build Triggers:** Poll SCM : * * * * *

**Build :** Execute Windows batch command : mvn -Dtest=Runner test

**E-mail Notification :** 
Manage Jenkins -> Configure System
smtp.gmail.com
Use SMTP Authentication
Use SSL
Port:465
