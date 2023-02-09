# Rate limiter low level design

* In this design core use cases are defined below 
    * client can provide rate limiter algorithm and config
    * client can ask for the request is throttled or can pass
    * client can update the request if request can't be throttled
* Abstract factory pattern is chosen so that client can pass its rate limiting strategy like bucket, refill, leaky bucket or any custom if they want
* Another factory class is used to serve the Common abstraction Rate limiter

## Client code
```RateLimiterAbstractFactory raf = new BucketRateLimiterFactory(5,3, BucketRateLimiterFactory.RefillUnits.seconds);
        RateLimitFactory rf= RateLimiter.getRateLimiter(raf);
        rf.canServeRequest();
        rf.update();
