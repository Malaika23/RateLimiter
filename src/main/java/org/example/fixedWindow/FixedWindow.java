package org.example.fixedWindow;

import org.example.RateLimiter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FixedWindow implements RateLimiter {
    private long rateLimit;
    private int windowSize;
    private List<Long> window;

    public FixedWindow(long rateLimit,int windowSize) {
        this.rateLimit = rateLimit;
        this.windowSize=windowSize;
        this.window = new ArrayList<>();
    }
    @Override
    public boolean grantAccess( ) {
        //fetch current timestamps
        long currentTime = System.currentTimeMillis()/1000; //convert to seconds
        //remove old timestamps that are outside the window
        window.removeIf(window -> window < (currentTime - windowSize));
        if (window.size() < rateLimit) {
            window.add(currentTime);
            return true;
        }
        return false;
    }
        }


