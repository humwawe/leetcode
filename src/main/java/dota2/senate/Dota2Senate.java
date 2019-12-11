package dota2.senate;

/**
 * @author hum
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        boolean r = true, d = true;
        char[] arr = senate.toCharArray();
        int person = 0;
        while (r && d) {
            r = false;
            d = false;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] == 'R') {
                    r = true;
                    if (person < 0) {
                        arr[i] = 'O';
                    }
                    ++person;
                } else if (arr[i] == 'D') {
                    d = true;
                    if (person > 0) {
                        arr[i] = 'O';
                    }
                    --person;
                }
            }
        }
        return person > 0 ? "Radiant" : "Dire";
    }
}
