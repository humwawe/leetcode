package minimum.hours.of.training.to.win.a.competition;

/**
 * @author hum
 */
public class MinimumHoursOfTrainingToWinACompetition {
  public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
    int n = energy.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (initialEnergy <= energy[i]) {
        int t = energy[i] - initialEnergy + 1;
        initialEnergy += t;
        res += t;
      }
      if (initialExperience <= experience[i]) {
        int t = experience[i] - initialExperience + 1;
        initialExperience += t;
        res += t;
      }
      initialEnergy -= energy[i];
      initialExperience += experience[i];
    }
    return res;
  }
}
