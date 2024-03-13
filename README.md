Add User Validation Rule:
This rule ensures that all required fields (age, email, password, username) are provided in the AddUserRequest object. If any of these fields are missing, it generates an AddUserResponse object with an error status and message indicating incomplete data.

Encrypt Password Rule:
This rule encrypts the password provided in the AddUserRequest object using the encryptionService.encrypt() method. If encryption fails, it sets the error status and message in the AddUserResponse object accordingly.

User Add Success Rule:
When a new user is successfully added to the database (Users table), this rule creates an AddUserResponse object with a success status and includes the user's information in the response.

User Not Found Rule:
If a user is not found in the database when searching by user ID, this rule sets the error status and message in the AddUserResponse object to indicate that the user was not found.

User Found Rule:
When a user is found in the database by user ID, this rule creates an AddUserResponse object with a success status and includes the user's information in the response.

Invalid Email Format Rule:
This rule checks if the email provided in the AddUserRequest object follows a valid email format. If the email format is invalid, it sets the error status and message in the AddUserResponse object accordingly.
