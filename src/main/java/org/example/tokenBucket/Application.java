package org.example.tokenBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello Customer!");
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i = 0; i < 12; i++){
            executors.execute(() -> userBucketCreator.accessApplication(1));
        }
        executors.shutdown();
    }
}
