Feature: login feature
Scenario: validate user able to login with valid credentils
Given user launch the browser
When user open the url as "https://admin-demo.nopcommerce.com/login"
And  user enter valid Username as "admin@yourstore.com" and password as "admin"
Then validate user is on dashboard page
When User click logout link 
Then validate user is on log in page
And close the browser
