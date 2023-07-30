package org.example.fixedWindow;


import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
        Map<Integer, FixedWindow> bucket;
        public UserBucketCreator(int id){
            this.bucket = new HashMap<>();
            bucket.put(id,new FixedWindow(1,3));
        }
        public void accessApplication(int id){
            if( bucket.get(id).grantAccess()){
                System.out.println(Thread.currentThread().getName() + " Able to access , the application");
            }else{
                System.out.println(Thread.currentThread().getName() + " Too many request , Please try after sometime");
            }
        }
    }


