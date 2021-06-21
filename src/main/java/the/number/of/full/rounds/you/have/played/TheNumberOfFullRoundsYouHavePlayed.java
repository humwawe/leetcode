package the.number.of.full.rounds.you.have.played;

/**
 * @author hum
 */
public class TheNumberOfFullRoundsYouHavePlayed {
    public int numberOfRounds(String startTime, String finishTime) {
        int startM = Integer.parseInt(startTime.substring(0, 2)) * 60 + Integer.parseInt(startTime.substring(3));
        int finishM = Integer.parseInt(finishTime.substring(0, 2)) * 60 + Integer.parseInt(finishTime.substring(3));
        if (startM > finishM) {
            finishM += 1440;
        }
        finishM = finishM / 15 * 15;
        return Math.max(0, finishM - startM) / 15;
    }
}
