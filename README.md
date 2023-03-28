# Dining Philosopher Problem
This program demonstrates the Dining Philosopher problem, which is a classic problem in computer science that illustrates the challenges of synchronizing concurrent processes. The problem involves a group of philosophers who are sitting at a round table, with a chopstick placed between each pair of adjacent philosophers. Each philosopher needs two chopsticks to eat, one on the left and one on the right, and they can only use the chopsticks that are next to them. The challenge is to prevent the philosophers from deadlocking, where each philosopher is holding one chopstick and waiting for the other.

## Usage
To run the program, simply compile and run the Main class in the src folder. The program will ask for which type of solution you want to run depending of its efficiency, each of which will attempt to acquire their left and right chopsticks and then eat for a random amount of time. The program will run indefinitely until it is terminated.

## Conclusion
This program demonstrates the challenges of synchronizing concurrent processes and provides a simple example of how to prevent deadlocks using synchronization constructs. Feel free to modify the program and experiment with different numbers of philosophers and chopsticks to see how it affects the behavior of the program.
