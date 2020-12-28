package number.of.students.unable.to.eat.lunch;

/**
 * @author hum
 */
public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (count[sandwiches[i]] > 0) {
                count[sandwiches[i]]--;
            } else {
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}
