package lld.ratelimiter;

public class Client {
    public static void main(String[] args){
        RateLimiterAbstractFactory raf = new TokenBucketRateLimiterFactory(5,3, TokenBucketRateLimiterFactory.RefillUnits.seconds);
        RateLimitFactory rf= RateLimiter.getRateLimiter(raf);
        System.out.println(rf.canServeRequest());
        System.out.println(rf.update());
        System.out.println(rf.update());
        System.out.println(rf.update());
        System.out.println(rf.canServeRequest());
    }
}
