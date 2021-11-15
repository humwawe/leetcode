package walking.robot.simulation.II;

/**
 * @author hum
 */
public class WalkingRobotSimulationII {
    int w, h;
    int dir;
    int x = 0;
    int y = 0;
    String[] dirs = new String[]{"East", "North", "West", "South"};
    int c;
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};


    public WalkingRobotSimulationII(int width, int height) {
        w = width;
        h = height;
        c = width * 2 + height * 2 - 4;
    }

    public void move(int num) {
        num = num % c;
        if (num == 0 && x == 0 && y == 0) {
            dir = 3;
        }
        for (int i = 0; i < num; i++) {
            int a = x + dx[dir];
            int b = y + dy[dir];
            if (a < 0 || a >= w || b < 0 || b >= h) {
                dir = (dir + 1) % 4;
                a = x + dx[dir];
                b = y + dy[dir];
            }
            x = a;
            y = b;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirs[dir];
    }
}
