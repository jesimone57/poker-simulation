# Poker Simulation to compute the various probalities of drawing 5-card hands

### Description
>The Java console application is a simulation of drawing N random 5-card hands from a standard 52 card deck.
Each hand is then scored to see of we have a flush, straight, two-pair etc. hand.  Each type of hand is counted
with the results displayed and both the actual probability and the expected (theoretical) probability.

### To execute the code
1. git clone the report to your local machine
2. cd out/production/poker-simulation
3. java PokerSimulation

### Partial Sample Output
Probabilities:

	Straight Flush		:   1528 of  100000000:  actual=0.001528%    expected=0.0015390771%   deviation=-0.71972346%
	Flush		:   197044 of  100000000:  actual=0.19704399%    expected=0.19654015%   deviation=0.25635755%
	Straight		:   392179 of  100000000:  actual=0.392179%    expected=0.3924647%   deviation=-0.07279208%
	Four of a Kind		:   24172 of  100000000:  actual=0.024172%    expected=0.024009604%   deviation=0.6763813%
	Three of a Kind		:   2110897 of  100000000:  actual=2.110897%    expected=2.1128452%   deviation=-0.09220461%
	Two Pair		:   4751484 of  100000000:  actual=4.751484%    expected=4.7539015%   deviation=-0.05084962%
	One Pair		:   42252820 of  100000000:  actual=42.25282%    expected=42.256905%   deviation=-0.009662133%
	Full House		:   144171 of  100000000:  actual=0.144171%    expected=0.14405763%   deviation=0.07870245%

A full description is available here:  http://en.wikipedia.org/wiki/List_of_poker_hands
