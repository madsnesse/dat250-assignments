# DAT250: Software Technology Experiment Assignment 5

Didn't have many issues with this assignment, one thing was that
some weird stuff happened when trying to add the actuator dependency, but after trying to install maven dependencies
a while I got it working, still don't know what the issue was...
Another thing was when creating HelloControllerTest I could not get spring to find a qualifying bean for MockMvc, turns out 
the issue was that I was having two spring applications defined, solved it by commenting out some lines in AccessingDataJpaApplication so 
that it is not a spring application at the moment.