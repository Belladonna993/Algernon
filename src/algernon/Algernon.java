package algernon;

public class Algernon {
	private MazeSpace[][] maze;
	private boolean startFound;
	private boolean blocked;
	private int startRow, startCol;

	/*
	 * that finds the shortest path in a maze represented by a 2D array of
	 * Things (where spaces represent potential paths, walls can never be paths,
	 * and flowers mark the solution path). Also in the maze is a single start
	 * element and a single cheese element. Lastly, you can temporarily set
	 * elements of the maze to U, D, L, or R to aid in your task, but those
	 * should be removed and set to something else before returning.
	 * 
	 * No diagonal moves are allowed; only up, down, left, and right.
	 * 
	 * In your function, you are given a static 2D array of Things called
	 * maze[ROWS][COLS]. The initial maze has only spaces, walls, a single start
	 * element, and a single cheese element -- no flowers.
	 * 
	 * Additionally, all array elements around the perimeter are guaranteed to
	 * be constructed solely of walls.
	 * 
	 * Your function should replace each space element along the shortest path
	 * from start to cheese with a flower and then return.
	 * 
	 * If no path exists, the maze is to remain unaltered.
	 * 
	 * Please make good use of functions, comments, and indentation to keep your
	 * code easily readable. No errors or warnings when compiling.
	 * 
	 * What to turn in: algernon.cpp and nothing else.
	 */

	MazeSpace[][] algernon(MazeSpace[][] maze) {
		this.maze = null;
		this.maze = maze;
		startFound = false;
		blocked = false;

		growTheBlob();

		if (startFound) {
			plantTheFlowers();
			clearTheRest();
		}

		return this.maze;
	}

	private void growTheBlob() {
		while (!startFound && !blocked) {
			MazeSpace[][] temp = new MazeSpace[MazeRunner.ROWS][MazeRunner.COLS];
			
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					temp [i][j] = maze[i][j];
				}
			}
			

			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					if (maze[i][j] == MazeSpace.CHEESE || maze[i][j] == MazeSpace.DOWN_ARROW
							|| maze[i][j] == MazeSpace.UP_ARROW || maze[i][j] == MazeSpace.LEFT_ARROW
							|| maze[i][j] == MazeSpace.RIGHT_ARROW) {
						// check left
						if (maze[i][j - 1] == MazeSpace.START) {
							startFound = true;
							startRow = i;
							startCol = j - 1;
						}
						if (maze[i][j - 1] == MazeSpace.START || maze[i][j - 1] == MazeSpace.EMPTY) {
							temp[i][j - 1] = MazeSpace.RIGHT_ARROW;
						}
						// check right
						if (maze[i][j + 1] == MazeSpace.START) {
							startFound = true;
							startRow = i;
							startCol = j + 1;
						}
						if (maze[i][j + 1] == MazeSpace.START || maze[i][j + 1] == MazeSpace.EMPTY) {
							temp[i][j + 1] = MazeSpace.LEFT_ARROW;
						}
						// check up
						if (maze[i - 1][j] == MazeSpace.START) {
							startFound = true;
							startRow = i - 1;
							startCol = j;
						}
						if (maze[i - 1][j] == MazeSpace.START || maze[i - 1][j] == MazeSpace.EMPTY) {
							temp[i - 1][j] = MazeSpace.DOWN_ARROW;
						}
						// check down
						if (maze[i + 1][j] == MazeSpace.START) {
							startFound = true;
							startRow = i + 1;
							startCol = j;
						}
						if (maze[i + 1][j] == MazeSpace.START || maze[i + 1][j] == MazeSpace.EMPTY) {
							temp[i + 1][j] = MazeSpace.UP_ARROW;
						}
					}
				}
			}
			// If no changes were made in a full iteration, there are no paths
			// to start. I think? *sigh* not working. Why are there full iterations with no changes?
			// This is returning true after only one iteration, it seems. Okay. Arrays.copyOf not 
			// making a deep copy.
			
			// Okay, got it, I think. *Sigh* Well, I had it. Hm. Spinning if I do two in a row. Not getting to this code.
			
			MazeRunner.printMaze(temp);
			MazeRunner.printMaze(maze);
			
			blocked = blockCheck(temp);
			System.out.println(blocked);

			if (!blocked) {
				for (int i = 0; i < maze.length; i++) {
					for (int j = 0; j < maze[i].length; j++) {
						maze [i][j] = temp[i][j];
					}
				}
				//MazeRunner.printMaze(maze);
			}
		}

	}

	private boolean blockCheck(MazeSpace[][] temp) {

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (temp[i][j] != maze[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private void plantTheFlowers() {
		MazeSpace temp = maze[startRow][startCol];
		int newRow = startRow;
		int newCol = startCol;

		while (temp != MazeSpace.CHEESE) {
			maze[newRow][newCol] = MazeSpace.FLOWER;

			switch (temp) {
			case LEFT_ARROW:
				newCol--;
				break;
			case RIGHT_ARROW:
				newCol++;
				break;
			case UP_ARROW:
				newRow--;
				break;
			case DOWN_ARROW:
				newRow++;
				break;
			default:
				break;
			}

			temp = maze[newRow][newCol];
			// MazeRunner.printMaze(maze);
		}

	}

	private void clearTheRest() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == MazeSpace.LEFT_ARROW || maze[i][j] == MazeSpace.RIGHT_ARROW
						|| maze[i][j] == MazeSpace.UP_ARROW || maze[i][j] == MazeSpace.DOWN_ARROW) {
					maze[i][j] = MazeSpace.EMPTY;
				}
			}
		}

	}

}
