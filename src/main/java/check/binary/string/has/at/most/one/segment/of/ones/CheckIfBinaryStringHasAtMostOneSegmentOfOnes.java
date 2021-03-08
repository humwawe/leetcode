package check.binary.string.has.at.most.one.segment.of.ones;

/**
 * @author hum
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
