package algernon;

public class MazeRunner {
	static final int ROWS = 20;
	static final int COLS = 40;


	static void printMaze(MazeSpace[][] space) {
		System.out.println();
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				System.out.print(space[i][j].getSymbol());
			}
			System.out.println();
		}
		System.out.println();
	}

	
	static MazeSpace setObject(char c) {
		return MazeSpace.getMazeSpace(c);
	}

	
	static void setupMaze(MazeSpace[][] a, char[][] b) {
		for (int i = 0; i < b.length; ++i) {
			for (int j = 0; j < b[i].length; ++j) {
				a[i][j] = setObject(b[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		MazeSpace[][] maze = new MazeSpace[ROWS][COLS];
		Algernon mouse = new Algernon();

		System.out.print("=================\n");
		setupMaze(maze, Mazes.MAZE01);
		printMaze(maze);
		maze = mouse.algernon(maze);
		printMaze(maze);

		System.out.print("=================\n");
		setupMaze(maze, Mazes.MAZE02);
		printMaze(maze);
		maze = mouse.algernon(maze);
		printMaze(maze);

//		System.out.print("=================\n");
//		setupMaze(maze, Mazes.MAZE03);
//		printMaze(maze);
//		maze = mouse.algernon(maze);
//		printMaze(maze);
//	
//		System.out.print("=================\n");
//		setupMaze(maze, Mazes.MAZE04);
//		printMaze(maze);
//		maze = mouse.algernon(maze);
//		printMaze(maze);
//
//		System.out.print("=================\n");
//		setupMaze(maze, Mazes.MAZE05);
//		printMaze(maze);
//		maze = mouse.algernon(maze);
//		printMaze(maze);

		System.out.print("=================\n");

	}

}
