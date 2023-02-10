package lld.ratelimiter;

public class TokenBucketRateLimiter implements RateLimitFactory{
    long bucketSize;
    long refillCount;
    long refillBaseCount;
    TokenBucketRateLimiterFactory.RefillUnits refillUnits;
    public TokenBucketRateLimiter(long bucketSize, long refillCount, TokenBucketRateLimiterFactory.RefillUnits refillUnits) {
        this.bucketSize=bucketSize;
        this.refillCount=refillCount;
        this.refillBaseCount=refillCount;
        this.refillUnits=refillUnits;
        this.initRefillEngine();
    }

    @Override
    public boolean update() {
        if(refillCount==0)
            return false;
        refillCount--;
        return true;
    }

    @Override
    public boolean canServeRequest() {
        return refillCount>0;
    }

    private void initRefillEngine(){
        //Todo: some timer/ forever loop which refills the count based on the units provided
    }
}
