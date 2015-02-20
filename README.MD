------------------------------------------------------------------------
This is the project README file.
------------------------------------------------------------------------

PROJECT TITLE: Simple Network Simulation of Bitmessage

AUTHOR: MayurM

VERSION or DATE: 0.3

Assumptions: 
1. every peer has a list of all peers. In reality this will not be true.
   This is done to make it easier to send messages.
2. POW computation time is 4 min on average.
3. protocol is simplified to exclude unnecessary steps. 
4. messages are sent with a random legal sizes to simulate legitemate traffic.
5. messages are sent from one random peer to another to simulate legitemate traffic.
    

HOW TO START THIS PROJECT:
1. extract and cd to project directory
2. make
3. Usage: java Driver [num of peers] [total messages to send]



USER INSTRUCTIONS:

1. java Driver [num of peers] [total messages to send]
   ex. java Driver 1000 100000
   
2. two files will be generated
   
   stat.txt - give stats for each peer and level of congestion in network
   log.txt - give record of each message sent          
