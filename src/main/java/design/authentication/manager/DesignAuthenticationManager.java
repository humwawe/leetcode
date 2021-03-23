package design.authentication.manager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class DesignAuthenticationManager {
    int t;
    Map<String, Integer> map;

    public DesignAuthenticationManager(int timeToLive) {
        t = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) {
            return;
        }
        if (map.get(tokenId) + t <= currentTime) {
            return;
        }
        map.put(tokenId, currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (Integer value : map.values()) {
            if (value + t > currentTime && value <= currentTime) {
                res++;
            }
        }
        return res;
    }
}
