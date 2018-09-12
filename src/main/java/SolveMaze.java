import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze = new Maze(10, 10);

        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        maze.startAtZero();
        maze.endAtTopRight();
        System.out.println(maze);

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        for (int step = 0; step < 1000; step++) {
            // Implement your maze solving algorithm here
            boolean canmoveforward = false;
            boolean canmoveleft = false;
            boolean canmoveright = false;
            if (!maze.isFinished()) {
                if (maze.canMove()) {
                    canmoveforward = true;
                }
                maze.turnRight();
                if (maze.canMove()) {
                    canmoveright = true;
                }
                maze.turnLeft();
                maze.turnLeft();
                if (maze.canMove()) {
                    canmoveleft = true;
                }
                maze.turnRight();
                if (canmoveleft) {
                    maze.turnLeft();
                    maze.move();
                    System.out.println(maze.getCurrentLocation());
                } else if (canmoveforward) {
                    maze.move();
                    System.out.println(maze.getCurrentLocation());
                } else if (canmoveright) {
                    maze.turnRight();
                    maze.move();
                    System.out.println(maze.getCurrentLocation());
                } else {
                    maze.turnRight();
                    maze.turnRight();
                    maze.move();
                    System.out.println(maze.getCurrentLocation());
                }

            }
        }

        if (maze.isFinished()) {
            System.out.println("You solved the maze!");
        } else {
            System.out.println("Try again!");
        }
    }
}