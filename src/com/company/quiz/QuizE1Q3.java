package com.company.quiz;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class QuizE1Q3 {
    private static class ALAdderTask implements Runnable {
        private final CountDownLatch latch;
        private AtomicLong atomicLong;

        public ALAdderTask(CountDownLatch latch, AtomicLong atomicLong) {
            this.latch = latch;
            this.atomicLong = atomicLong;
        }

        @Override
        public void run() {
            try {
                latch.await();
                atomicLong.incrementAndGet();
            } catch (InterruptedException ignore) {

            }
        }

        private static class LongAdderTask implements Runnable {
            private final CountDownLatch latch;
            private final LongAdder longAdder;

            public LongAdderTask(CountDownLatch latch, LongAdder longAdder) {
                this.latch = latch;
                this.longAdder = longAdder;
            }

            @Override
            public void run() {
                try {
                    latch.await();
                    longAdder.increment();
                } catch (InterruptedException ignore) {

                }
            }
        }

        public static void main(String[] args) {
            int nThread = 200;
            int iterations = 10000;
            ExecutorService executorService = Executors.newFixedThreadPool(nThread);
            CountDownLatch latch = new CountDownLatch(iterations);
            LongAdder longAdder = new LongAdder();
            AtomicLong atomicLong = new AtomicLong();
            long start = System.currentTimeMillis();
            for (int i = 0; i < iterations; i++) {
                System.out.println(i);
                //               executorService.submit(new LongAdderTask(latch, longAdder));
                executorService.submit(new ALAdderTask(latch, atomicLong));
                latch.countDown();
            }
            long stop = System.currentTimeMillis();

            System.out.println(stop - start);
        }
    }
}
