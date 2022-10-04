# JavaSeleniumClocksoftware

### Import the project in eclipse as Maven project
### To run, Right-click on Runner class and select Run as JUnit
### Html report can be found under target/index.html
 
# Further Improvements:
### Parallel execution for distributed execution
### Multiple browsers handling for cross-browser testing
### Extent report for better reporting
### JIRA API integration to update the results in JIRA after the test execution


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
