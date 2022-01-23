Feature: add new customer
Scenario: validate user able to add new customers
Given user launch the browser
When user open the url as "https://admin-demo.nopcommerce.com/login"
And  user enter valid Username as "admin@yourstore.com" and password as "admin"
Then validate user is on dashboard page
When User click on customers menu option
And user click on customers submenu
Then validate user is navigate to customerslistPage
When user click on Add new button
Then validate User is add new customers Page
When user enter customer info
And click on Save button
Then verify sucess message is displayed as "The new customer has been added successfully."
