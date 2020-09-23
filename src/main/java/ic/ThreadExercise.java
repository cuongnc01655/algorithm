package ic;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ThreadExercise {
    public void testCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream
                .generate(() -> new Thread(new Worker(countDownLatch)))
                .limit(5)
                .collect(toList());
        workers.forEach(Thread::start);
        countDownLatch.await();

        System.out.println("All Worker thread finished");
        System.out.println("Result: " + Worker.result);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadExercise threadExercise = new ThreadExercise();
        threadExercise.testCountDownLatch();
    }
}

class Worker implements Runnable {
    static int result = 0;
    CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Worker " + Thread.currentThread().getName() + " working");
        for (int i = 0; i < 10000; i++) {
            result++;
        }
        countDownLatch.countDown();
    }
}


class CallableImpl implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}
