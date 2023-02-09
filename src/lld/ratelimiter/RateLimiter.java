package lld.ratelimiter;

public class RateLimiter {
    public static RateLimitFactory getRateLimiter(RateLimiterAbstractFactory rlf){
        return rlf.createRateLimiter();
    }
}
