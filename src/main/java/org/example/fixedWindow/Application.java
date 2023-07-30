package org.example.fixedWindow;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello Customer!");
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);

        ThreadFactory threadFactory = new ThreadFactory() {
            private int count = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread - " + count++);
            }
        };
        ExecutorService executors = Executors.newFixedThreadPool(10,threadFactory);
        for(int i = 0; i < 10; i++){
            executors.execute(() -> userBucketCreator.accessApplication(1));
        }
        executors.shutdown();
    }
}
