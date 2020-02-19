Feature: Login Testing

Scenario Outline: Member login function-valid details
Given user is on "http://qaclickacademy.com" page
When member enter <username> password <password> credentials
Then member is logged in sucessfully 

Examples:
|username	|password	|
|sharu777@gmail.com	|rakshash	|
|karu@gmail.com	|rakshash	|


