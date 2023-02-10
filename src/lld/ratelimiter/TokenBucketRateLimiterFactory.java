package lld.ratelimiter;

public class TokenBucketRateLimiterFactory implements RateLimiterAbstractFactory{
    long bucketSize=0;
    long refillCount=0;
    RefillUnits refillUnits;
    static enum RefillUnits {
        seconds,
        minutes,
        hours
    }
    public TokenBucketRateLimiterFactory(long bucketSize, long refillCount, RefillUnits refillUnits){
        this.bucketSize=bucketSize;
        this.refillCount=refillCount;
        this.refillUnits=refillUnits;
    }
    @Override
    public RateLimitFactory createRateLimiter() {
        return new TokenBucketRateLimiter(bucketSize,refillCount,refillUnits);
    }
}
