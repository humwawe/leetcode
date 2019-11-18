package encode.and.decode.tiny.url;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyUrl {
    Map<String, String> map = new HashMap<>();
    int count = 0;

    public String encode(String longUrl) {
        map.put(String.valueOf(++count), longUrl);
        return String.valueOf(count);
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
