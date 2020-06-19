package rank.teams.by.votes;

import java.util.Arrays;

/**
 * @author hum
 */
public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        int[][] t = new int[26][26];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                t[vote.charAt(i) - 'A'][i]++;

            }
        }
        Integer[] idx = new Integer[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            for (int i = 0; i < 26; i++) {
                if (t[a][i] == t[b][i]) {
                    continue;
                }
                return t[b][i] - t[a][i];
            }
            return 0;
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            result.append((char) (idx[i] + 'A'));
        }
        return result.toString();
    }
}
