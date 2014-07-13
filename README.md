TweetyPi
========

This project was developed as an entry to Swansea University Computer Science Department's undergraduate programming competition. The aim of the competition was to produce an exciting project using physical computing elements including a Raspberry Pi and Arduino.

More information can be found at : http://cs.swan.ac.uk/makercomp/

Our project involved one Raspberry Pi and an Arduino with a 16X2 LED screen attached. The aim of the program was to find the users location, pull the top ten trends from twitter at that location and use these trending topics to find the news stories that accompanied these trends. To do this we used twitter4j to allow us to connect to twitters API and get the trends at a locaton. Open JSSC to allow for a serial connection from the raspberry PI's USB port to the arduino USB port. And the geobytes library to acquire the users location from their IP address. The result of the program running can be seen at :

https://www.youtube.com/watch?v=Kw0jQoLpWzA

https://www.youtube.com/watch?v=rglNNtj4aCo

YT("Kw0jQoLpWzA", print = TRUE)
YT("rglNNtj4aCo", print = TRUE)

PyTwitterLocation and PyTwitterRandom are the original code used for the competition which provide the users location or select a location from a pre entered list respectively. PyTwitterPC is an extension to the original program to include a PC interface.
