package lld.ratelimiter;

public class BucketRateLimiterFactory implements RateLimiterAbstractFactory{
    long bucketSize=0;
    long refillCount=0;
    RefillUnits refillUnits;
    static enum RefillUnits {
        seconds,
        minutes,
        hours
    }
    public BucketRateLimiterFactory(long bucketSize,long refillCount,RefillUnits refillUnits){
        this.bucketSize=bucketSize;
        this.refillCount=refillCount;
        this.refillUnits=refillUnits;
    }
    @Override
    public RateLimitFactory createRateLimiter() {
        return new BucketRateLimiter(bucketSize,refillCount,refillUnits);
    }
}
