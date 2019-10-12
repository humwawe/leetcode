package number.of.segments.in.astring;


/**
 * @author hum
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        return s.split("\\s+").length;
    }

}
