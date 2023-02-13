
import java.util.concurrent.locks.Lock;


public class NPhilosophers extends Thread {
    private Lock chopstick1;
    private Lock chopstick2;
    private int id;
    private static int turn = 0;
    private static int numPhilosophers;

    public NPhilosophers(Lock chopstick1, Lock chopstick2, int id, int numPhilosophers) {
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
        this.id = id;
        this.numPhilosophers = numPhilosophers;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (Philosopher.class) {
                    while (turn != id) {
                        Philosopher.class.wait();
                    }
                }
                chopstick1.lock();
                chopstick2.lock();
                eat();
                chopstick2.unlock();
                chopstick1.unlock();
                synchronized (Philosopher.class) {
                    turn = (turn + 1) % numPhilosophers;
                    Philosopher.class.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            // handle interruption
        }
    }

    private void think() throws InterruptedException {
        System.out.println(getName() + " is thinking");
        Thread.sleep((int) (Math.random() * 1000));
    }

    private void eat() {
        System.out.println(getName() + " is eating");
    }
}