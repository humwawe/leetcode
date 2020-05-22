package print.foo.bar.alternately;

/**
 * @author hum
 */
public class PrintFooBarAlternately {
    private int n;
    private int count = 0;

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (count == 1) {
                this.wait();
            }
            printFoo.run();
            count++;
            this.notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (count == 0) {
                this.wait();
            }
            printBar.run();
            count--;
            this.notifyAll();
        }
    }
}
