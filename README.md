# PetStore_Api_Automation
### *Rest Assured Framework* - The project was initiated to test [Pet Store Public Api](https://petstore3.swagger.io/). 

##  Framework Structure
- ![Load Testing (2)](https://github.com/Ninja-Cyborg/PetStore_Api_Automation/assets/66517017/995f0221-c5ff-44c5-884d-21f553954dd4)

# Pre-Requisites
# Project Feature
# Challenges and Solutions
# Test Execution
# Test Reports

# Pre-Requisites
- Java 8
- Itellij (IDE)
- Maven (build tool)
- Jenkins (CI pipeline)
- Git (version control system)

# Project Feature
- Data Driven testing, tests read data from excel sheets
- Ran 14 unique requests over 3 Api Models
- Generate Logs and Extent Reports

# Challenges and Solutions
- These problems were specific to this Api
##  Low Load handling
- Public server cann't hande large number of requests
- Requests will get 500 error, on server load
- To get over this, run tests in smaller chunks, that is run by class, instead of whole test suite
##  Complex Data Models
- The actual Api structure had larger amount of models, interfaces and other services
- The tests did not required all of that data
- To keeps test simple, models were merge and some components are skipped which does not impact of testing

# Test Execution
##  Terminal execution
- To run tests from terminal 
- Open the project directory
- Run the command, mvn clean tests
##  XML file execution
- Run testng.xml file from IDE

# Test Reports
- HTML Reports from local test execution ![image](https://github.com/Ninja-Cyborg/PetStore_Api_Automation/assets/66517017/99b9d490-4000-42c2-813b-b1b4668254f5)
*Most of the failure occures due to server load, not because of bad tests or api path. Failure's logged in log file*
