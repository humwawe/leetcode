package the.dining.philosophers;

import java.util.concurrent.Semaphore;

/**
 * @author hum
 */
public class TheDiningPhilosophers {
    volatile Semaphore[] forks = new Semaphore[]{new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};

    public TheDiningPhilosophers() {

    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {


        int rightForkNo = (philosopher + 1) % 5;

        if (philosopher % 2 == 0) {
            forks[philosopher].acquire();
            forks[rightForkNo].acquire();
        } else {
            forks[rightForkNo].acquire();
            forks[philosopher].acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[philosopher].release();
        forks[rightForkNo].release();
    }
}
