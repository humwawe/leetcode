package determine.color.of.a.chessboard.square;

/**
 * @author hum
 */
public class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;
    }
}
