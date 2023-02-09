package lld.ratelimiter;

public class Client {
    public static void main(String[] args){
        RateLimiterAbstractFactory raf = new BucketRateLimiterFactory(5,3, BucketRateLimiterFactory.RefillUnits.seconds);
        RateLimitFactory rf= RateLimiter.getRateLimiter(raf);
        System.out.println(rf.canServeRequest());
        System.out.println(rf.update());
        System.out.println(rf.update());
        System.out.println(rf.update());
        System.out.println(rf.canServeRequest());
    }
}
