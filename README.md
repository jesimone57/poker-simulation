# Poker Simulation to Compute the Various Probabilities of Drawing 5-card hands

### Description
>This Java console application is a simulation of drawing N random 5-card hands from a standard 52 card deck.
Each hand, drawn from the top of a shuffled deck, is evaluated to see if we have a flush, straight, two-pair etc. hand.
Each type of hand is counted
with the results displayed for both the actual probability and the expected (theoretical) probability of drawing that
type of hand.
>You can change the number of poker hands simulated by changing the HANDS variable in the PokerSimulation.java class.
The default is 100,000 hands simulated.

### To execute the code
1. git clone the repo to your local machine
2. cd out/production/poker-simulation
3. java PokerSimulation

### Sample Output

    Start simulating 100000 random poker hands:
    simulated 10000 random poker hands ...
    simulated 20000 random poker hands ...
    simulated 30000 random poker hands ...
    simulated 40000 random poker hands ...
    simulated 50000 random poker hands ...
    simulated 60000 random poker hands ...
    simulated 70000 random poker hands ...
    simulated 80000 random poker hands ...
    simulated 90000 random poker hands ...
    simulated 100000 random poker hands
    Done

Probabilities:

	Straight Flush		:   2 of  100000:  actual= 0.0019999999%    expected= 0.0015390771%   deviation= 29.948%
	Straight		:   392 of  100000:  actual= 0.39200002%    expected= 0.3924647%   deviation= -0.11840133%
	Flush		:   206 of  100000:  actual= 0.20600002%    expected= 0.19654015%   deviation= 4.813196%
	Four-of-a-Kind		:   31 of  100000:  actual= 0.031%    expected= 0.024009604%   deviation= 29.115004%
	Full House		:   159 of  100000:  actual= 0.159%    expected= 0.14405763%   deviation= 10.372497%
	Three-of-a-Kind		:   2092 of  100000:  actual= 2.092%    expected= 2.1128452%   deviation= -0.98659545%
	Two Pair		:   4731 of  100000:  actual= 4.731%    expected= 4.7539015%   deviation= -0.48174313%
	One Pair		:   42234 of  100000:  actual= 42.234%    expected= 42.256905%   deviation= -0.05419963%

A full description is available here:  http://en.wikipedia.org/wiki/List_of_poker_hands
