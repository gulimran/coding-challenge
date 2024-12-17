package imran.coding.challenge.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateLimiterChallenge {

    private final Map<String, Queue<Long>> userRequests;
    private final int limit;
    private final int timeWindow;

    public RateLimiterChallenge(int limit, int timeWindowSeconds) {
        this.userRequests = new HashMap<>();
        this.limit = limit;
        this.timeWindow = timeWindowSeconds * 1000;
    }

    /**
     * Implement a simple rate limiter that allows N requests per minute per user.
     * @return true if the request is allowed, false otherwise
     */
    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        userRequests.putIfAbsent(userId, new LinkedList<>());

        Queue<Long> userRequestTimes = userRequests.get(userId);

        while(!userRequestTimes.isEmpty() && userRequestTimes.peek() < currentTime - timeWindow) {
            userRequestTimes.poll();
        }

        if (userRequestTimes.size() == limit) {
            return false;
        }

        userRequestTimes.add(currentTime);
        return true;
    }
}
