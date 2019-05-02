# Blueharvest Bank app

This files contains information on this projects.

## Versioning

GitHub: https://github.com/dawe21/blueharvest.io

### Find the repo
https://github.com/dawe21/blueharvest.io

### Clone the repo
git clone https://github.com/dawe21/blueharvest.io.git

### Add file(s)
git add .
Commit the changes
git commit -m "Add existing file"

### Switch branch
git fetch
git checkout development

Push the changes in your local repository to GitHub
git push origin your-branch

## Building

### This project uses Maven for building
From the root directory, run ``mvn clean install`` to build

## Deploy and Run the Application

### Build the application
mvn clean install

### Run the application
java -jar target/bank-app-1.0.0-SNAPSHOT-jar-with-dependencies.jar

### Access GUI
http://localhost:7000/index

## To test - use curl commands (or browser for non POST requests):

### Add a new customer
curl -X POST -d '{"name":"David","sureName":"Welander"}' http://localhost:7000/api/customer

### Get all transactions and all accounts for all customers
curl http://localhost:7000/api/customers

### Add a new account to customer (with something on the account, creates an transaction also)
curl -X POST -d '{"amount":"1000","customerId":"0"}' http://localhost:7000/api/account

### Get the customer by Customer Id {0}
curl http://localhost:7000/api/customer/0

### Get the one account by Account Id {1234000000000}
curl http://localhost:7000/api/account/1234000000000

### Get all the accounts
http://localhost:7000/api/accounts

---

## GitHub

### Clone the repo
git clone https://user@github.com/dawe21/blueharvest.io.git

### Add file(s)
git add .
### Commit the changes

git commit -m "Add existing file"

### Switch branch
git fetch
git checkout development

### Push the changes in your local repository to GitHub
git push origin master
(git push https://user@bgithub.com/dawe21/blueharvest.io.git origin master)
