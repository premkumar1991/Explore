package lld.ratelimiter;

public interface RateLimitFactory {
    public boolean update(); // return false if the current request throttled else true
    public boolean canServeRequest();
}
