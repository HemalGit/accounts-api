# Instruction to run application.

* Open Eclipse IDE
* Go to File -> Import -> Maven -> Existing Maven Projects
* Go to source file com.accounts.AccountsApplicationMain
* Right click and select Run As -> Java Application
* Once the server is started, open web browser and run below
    - http://localhost:8080/accounts/U001 (this request will return all the accounts for user 'U001')
    - http://localhost:8080/account/1023-4343-444/transactions (this request uses an accountNo from above response and retrieves all the transaction for specified account no.) 
      

