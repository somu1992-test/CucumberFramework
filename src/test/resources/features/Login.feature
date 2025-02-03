Feature: Login functionality

Scenario: Login with valid credentials

Given user navigates to login page
When user enters valid email adress 'somu.12@gmail.com' into email field
And user enters valid pwd "12345" into pwd field
And user clicks on login button
Then user should get successfully logged in

Scenario: Login with invalid credentials

Given user navigates to login page
When user enters invalid email adress  into email field
And user enters invalid pwd '54321' into pwd field
And user clicks on login button
Then user should get warning msg about credentials mismatch

Scenario: Login with valid email and invalid pwd

Given user navigates to login page
When user enters valid email adress "amotooricap1@gmail.com" into email field
And user enters invalid pwd "98706" into pwd field
And user clicks on login button
Then user should get warning msg about credentials mismatch

Scenario: Login with invalid email and valid pwd

Given  user navigates to login page
When user enters invalid email adress  into email field
And user enters valid pwd "12345" into pwd field
And user clicks on login button
Then user should get warning msg about credentials mismatch

Scenario: Login without providing any credentials

Given user navigates to login page 
When user dont enter any email adress  into email feild
And user dont enter any pwd  into pwd field
And user clicks on login button
Then user should get warning msg about credentials mismatch


