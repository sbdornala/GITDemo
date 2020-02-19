Feature: Registration Testing

Scenario Outline: Member login function-valid details
Given user is on "http://qaclickacademy.com" page and click on registration link
When member enter username <username> email  <emailaddress>  password <password> confirm password <confirmpassword> credentials and click submit
Then member is registerred sucessfully 

Examples:
|username	|emailaddress	|password	|confirmpassword	|
|sharath	|sharu777@gmail.com	|rakshash	|rakshash	|
|karuna	|karu@gmail.com	|rakshash	|rakshash	|


