Feature: Registration functionality

Scenario: User creates an account with mandatory fields

Given user navigates to Register Account page
When user enters details into below fields

|firstName				 |somu             |
|lastName 				 |reddy				     |
|telephone		     |1234567890       |
|password					 |12345						 |

And user selects privacy policy
And user clicks on continue button
Then user account should get created successfully

Scenario: User creates an account with All fields

Given user navigates to Register Account page
When user enters details into below fields

|firstName				 |somu             |
|lastName 				 |reddy				     |
|telephone		     |1234567890       |
|password					 |12345						 |

And user selects Yes for Newsletter
And user selects privacy policy
And user clicks on continue button
Then user account should get created successfully

Scenario: User creates a duplicate account

Given user navigates to Register Account page
When user enters details into below fields with duplicate email

|firstName				 |somu             |
|lastName 				 |reddy				     |
|email             |somu.pa@gmail.com|
|telephone		     |1234567890       |
|password					 |12345						 |

And user selects privacy policy
And user clicks on continue button
Then user should get warning msg about duplicate account

Scenario: user creates an account without filling any details

Given user navigates to Register Account page
When user dont enter any details into fields
And user clicks on continue button
Then user should get warning msg for every mandatory field