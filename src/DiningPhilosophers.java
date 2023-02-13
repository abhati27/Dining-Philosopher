import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter 1, 2, or 3: ");
        int input = inp.nextInt();
//        inp.close();
        if(input==3){
//            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of philosophers: ");
            numPhilosophers = inp.nextInt();
            inp.close();

            Lock[] chopsticks = new ReentrantLock[numPhilosophers];
            for (int i = 0; i < numPhilosophers; i++) {
                chopsticks[i] = new ReentrantLock();
            }

            NPhilosophers[] philosophers = new NPhilosophers[numPhilosophers];
            for (int i = 0; i < numPhilosophers; i++) {
                philosophers[i] = new NPhilosophers(chopsticks[i], chopsticks[(i + 1) % numPhilosophers], i, numPhilosophers);
                philosophers[i].start();
            }
        } else if(input ==2){
            Lock[] chopsticks = new ReentrantLock[numPhilosophers];
            for (int i = 0; i < numPhilosophers; i++) {
                chopsticks[i] = new ReentrantLock();
            }

            PhilosopherNoDeadlock[] philosophers = new PhilosopherNoDeadlock[numPhilosophers];
            for (int i = 0; i < numPhilosophers; i++) {
                philosophers[i] = new PhilosopherNoDeadlock(chopsticks[i], chopsticks[(i + 1) % numPhilosophers], i);
                philosophers[i].start();
            }
        } else {
            Lock[] chopsticks = new ReentrantLock[numPhilosophers];
            for (int i = 0; i < numPhilosophers; i++) {
                chopsticks[i] = new ReentrantLock();
            }

            Philosopher[] philosophers = new Philosopher[numPhilosophers];
            for (int i = 0; i < numPhilosophers; i++) {
                philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % numPhilosophers]);
                philosophers[i].start();
            }
        }

    }
}