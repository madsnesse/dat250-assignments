#DAT250: Software Technology Experiment Assignment 1
##Installation
For the installation I already had a working environment for java development set up, using Intellij as an IDE. 
Verified that it is set up correctly by running ```mvn --version``` as that not only shows me that maven is installed, 
but also which java version is being used by maven. For git I usually only use either terminal or IntelliJs built-in git 
features, but I also have sourcetree, and GitHub desktop installed if I need a more graphical tool 

##Heroku Tutorial
I went through all the steps in the tutorial. 

One of the issues I encountered was that I didn't have postgres installed locally,
but this was solved by installing postgres and appending the path ```/Applications/Postgres.app/Contents/Versions/latest/bin```
to my PATH variable.

Another issue was that when installing with maven it defaulted to pull through my workplaces own repository server, but I wanted
to just use maven central, the solution I used for this was to just temporarily remove my maven profile for work, and I
will have to establish some way to switch between the 'work-profile' and 'study-profile'

Furthermore, when I tried starting the application locally. I received an error with using port 5000 as it was already 
in use by another application, but the solution here was just to change ``application.properties`` to port 5001 instead


https://shrouded-retreat-05686.herokuapp.com/