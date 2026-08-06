import java.util.*;

class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obstacleSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0;
        int x = 0;
        int y = 0;

        int maxDistance = 0;

        for (int command : commands) {

            if (command == -1) {

                dir = (dir + 1) % 4;

            } else if (command == -2) {

                dir = (dir + 3) % 4;

            } else {

                for (int step = 0; step < command; step++) {

                    int newX = x + dx[dir];
                    int newY = y + dy[dir];

                    if (obstacleSet.contains(newX + "," + newY)) {
                        break;
                    }

                    x = newX;
                    y = newY;

                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}
