package L2025.L01.L1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author 王强
 * @since 2025/1/15
 */
public class Main {
    public static void main(String[] args) {
        IntConsumer printNumber = System.out::print;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class ZeroEvenOdd {

    private int n;

    private final Semaphore zeroSemaphore = new Semaphore(0);
    private final Semaphore evenSemaphore = new Semaphore(0);
    private final Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSemaphore.release();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}
