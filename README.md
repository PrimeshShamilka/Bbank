# Bbank
A RESTFUL web service designed for a micro banking system. System is developed as a dynamic web project using Java. DAO design pattern is used to seperate the business logic from data persistence logic.

## Problem 
B is a small private bank in Sri Lanka. They are trying to attract new customers by providing
micro banking facilities. Managers are planning to do PoC for the system. The system
essentially has two components; the central server with the central database and mobile
banking device that agents take to from customer to customer.
The mobile devices contains only lightweight databases and can only handle deposit and
withdraw functionalities. To make the transactions efficient and less costly, mobile device
update the central server only after a particular number of transactions, as a batch processing
or after a certain time period depending on which comes first. An account holder is only allowed
to withdraw money from one mobile banking agent to avoid withdrawing money more than he
actually has deposited. However any account holder can make a special request and get the
facility to withdraw money from any mobile agent with a additional service cost per each
transaction. These type of withdrawal transactions are called critical transactions and they
immediately update the central server. These mobile agents provide service to joint account
holders as well and those accounts are given the multiple agent withdrawal facility by default.
All the interest calculating process are handled only by the central server. Interest rates and
minimum required balance for Savings account vary on the plan. Plans are briefly listed below,

- Children - 12%, no minimum
- Teen - 11%, 500 minimum
- Adult (18+) - 10%, 1000 minimum
- Senior (60+) - 13%, 1000 minimum
- Joint - 7%, 5000 minimum

Apart from these, customer could start a Fixed Deposit (FD) with the bank by going to their
main station. For a FB to function, a customer must have a Savings account. The FD plans
are as follows,
- 6 months, 13%
- 1 year, 14%
- 3 years, 15% 

All rates are provided per annum. FD would calculate the monthly interest and deposit it in
the linked Savings account. Months are calculated as 30 day periods starting from the FD
opening date.
Apart from these requirements, the bank need to see some basic monthly reports from the
system. Some of the reports include,
- 1. Agent wise total transaction report
- 2. Account wise total transaction report Only bank management
can view these reports.

## Task

Your task is to model the database design to encapsulate these requirement. It should
consider all entities and relationships given in the description. Moreover you need to identify
the places where procedures, functions and triggers can be employed to guarantee ACID
properties. Foreign keys and primary keys must be set to maintain consistency. Indexing
should be done when necessary.
Additionally, you must get a domain idea by reading related material and take assumptions
when not explicitly provided. (Ex: Account types, interest rates etc.) The database must be
populated with dummy data before presentation. There is no need to implement UI control to
specifically input data. SQL queries can be used to manually input the dummy data

## Libraries used
- Jersey - RESTful web services in java

## DAO design pattern
<img src="https://github.com/PrimeshShamilka/Bbank/blob/master/images/DAO.png" width="400">
<img src="https://github.com/PrimeshShamilka/Bbank/blob/master/images/DAO_imp.png" width="400">


## Database ERD

<img src="https://github.com/PrimeshShamilka/Bbank/blob/master/images/BbankFinal_modified.jpg" width="600">

## Authentication API

<img src="https://github.com/PrimeshShamilka/Bbank/blob/master/images/authentication%20API.png" width="600">

## mDeposit API

<img src="https://github.com/PrimeshShamilka/Bbank/blob/master/images/mDeposit%20API.png" width="600">

## mWithdraw API

<img src="https://github.com/PrimeshShamilka/Bbank/blob/master/images/mWithdraw%20API.png" width="600">

