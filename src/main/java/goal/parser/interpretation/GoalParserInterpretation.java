package goal.parser.interpretation;

/**
 * @author hum
 */
public class GoalParserInterpretation {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
