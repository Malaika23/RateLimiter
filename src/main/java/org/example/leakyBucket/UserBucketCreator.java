package org.example.leakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer,LeakyBucket> bucket;
    public UserBucketCreator(int id){
        this.bucket = new HashMap<>();
        bucket.put(id,new LeakyBucket(10));
    }
    public void accessApplication(int id){
        if( bucket.get(id).grantAccess()){
            System.out.println(" Able to access , the application");
        }else{
            System.out.println(" Too many request , Please try after sometime");
        }
    }
}
