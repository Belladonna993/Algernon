package algernon2;
import java.util.Scanner;

public class MazeRunner {
	public static void main(String[] args) {
		Algernon mouse = new Algernon();
		Scanner in = new Scanner(System.in);

		System.out.print("=================\n");
		mouse.setupMaze(Mazes.MAZE01);
		mouse.printMaze();
		mouse.algernon();
		mouse.printMaze();
		in.nextLine();

		System.out.print("=================\n");
		mouse.setupMaze(Mazes.MAZE02);
		mouse.printMaze();
		mouse.algernon();
		mouse.printMaze();
		in.nextLine();

		System.out.print("=================\n");
		mouse.setupMaze(Mazes.MAZE03);
		mouse.printMaze();
		mouse.algernon();
		mouse.printMaze();
		in.nextLine();
	
		System.out.print("=================\n");
		mouse.setupMaze(Mazes.MAZE04);
		mouse.printMaze();
		mouse.algernon();
		mouse.printMaze();
		in.nextLine();

		System.out.print("=================\n");
		
		mouse.setupMaze(Mazes.MAZE05);
		mouse.printMaze();
		mouse.algernon();
		mouse.printMaze();
		System.out.print("=================\n");
		in.close();

	}

}
