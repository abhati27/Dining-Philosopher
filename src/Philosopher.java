import java.util.concurrent.locks.Lock;


public class Philosopher extends Thread {
    private Lock chopstick1;
    private Lock chopstick2;

    public Philosopher(Lock chopstick1, Lock chopstick2) {
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                chopstick1.lock();
                chopstick2.lock();
                eat();
                chopstick2.unlock();
                chopstick1.unlock();
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


