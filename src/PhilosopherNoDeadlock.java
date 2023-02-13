import java.util.concurrent.locks.Lock;


public class PhilosopherNoDeadlock extends Thread {
    private Lock chopstick1;
    private Lock chopstick2;
    private int id;

    public PhilosopherNoDeadlock(Lock chopstick1, Lock chopstick2, int id) {
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                if (id % 2 == 0) {
                    chopstick1.lock();
                    chopstick2.lock();
                } else {
                    chopstick2.lock();
                    chopstick1.lock();
                }
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

