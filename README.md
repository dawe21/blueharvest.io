# Blueharvest Bank app

This files contains information on this projects.

## Versioning

GitHub: https://github.com/dawe21/blueharvest.io

Find the repo
https://github.com/dawe21/blueharvest.io

Clone the repo
git clone https://github.com/dawe21/blueharvest.io.git

Add file(s)
git add .
Commit the changes
git commit -m "Add existing file"

Switch branch
git fetch
git checkout development

Push the changes in your local repository to GitHub
git push origin your-branch

## Building

This project uses Maven for building. Common commands:

From the root directory, run ``mvn clean install`` to build

## Deploy and Run the Application

### Run
java -jar target/accounts-1.0.0-SNAPSHOT-jar-with-dependencies.jar

http://localhost:7000/index.html (static file)
http://localhost:7000/index

## Add static files to the project

If you do app.enableStaticFiles("/classpath-folder"). Your index.html file at /classpath-folder/index.html will be available at http://{host}:{port}/index.html and http://{host}:{port}/.

Static files are placed under:

src/main/resources/public/index.html

Start page is here : http://localhost:7000/index.html

Step 3. Make static file present data from rest service

Step 4. Deploy to heruko
Open a terminal and navigate to your project root, then enter:
heroku create blueharvest.io
then to deploy
mvn heroku:deploy

---

## GitHub

Clone the repo
git clone https://user@github.com/dawe21/blueharvest.io.git

Add file(s)
git add .
Commit the changes
git commit -m "Add existing file"

Switch branch
git fetch
git checkout development

1. Push the changes in your local repository to GitHub
git push origin master
(git push https://user@bgithub.com/dawe21/blueharvest.io.git origin master)

---
***
Step 2. and 3. not needed since build automatic when pushing to GitHub
***

2. Push to remote heroku
git push heroku master

3. Deploy on heroku
mvn heroku:deploy
---
ck **Clone**.
4. Open the directory you just created to see your repository’s files.

Now that you're more familiar with your Bitbucket repository, go ahead and add a new file locally. You can [push your change back to Bitbucket with SourceTree](https://confluence.atlassian.com/x/iqyBMg), or you can [add, commit,](https://confluence.atlassian.com/x/8QhODQ) and [push from the command line](https://confluence.atlassian.com/x/NQ0zDQ).

---
