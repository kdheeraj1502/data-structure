package _09_backtracking;

import java.util.ArrayList;

/*
link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

sol: https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/

sol(no. of ways): https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/

video: https://youtu.be/rKo9MPe0c5A
video2: https://youtu.be/bLGZhJlt4y0
*/

//-------------------------------------------------------------------- //
/*
simple using dfs or backtracking

[Depth First Search (DFS) uses the concept of backtracking at its very core.
So, in DFS, we basically try exploring all the paths from the given node
recursively until we reach the goal. After we search in a particular branch
of a tree in DFS, we can land up in two possible states.]

TC: O((N ^ 2) ^ 4)
SC: O(N * N)
*/
public class RatInMaze {
	int maze[][];

	RatInMaze(int maze[][]) {
		this.maze = maze;
	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> list = new ArrayList<>();
		dfs(m, 0, 0, "", list);
		return list;
	}

//DDRDRR DRDDRR
	private static void dfs(int[][] grid, int row, int col, String ans, ArrayList<String> list) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid.length || grid[row][col] == 0) {
			System.out.println("Return :::::::  Row " + row + " Col " + col);
			return;
		}
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			System.out.println("Row " + row + " Col " + col);
			list.add(ans);
			return;
		}
		grid[row][col] = 0;
		System.out.println("Row " + row + " Col " + col);
		dfs(grid, row - 1, col, ans + "U", list);
		dfs(grid, row, col + 1, ans + "R", list);
		dfs(grid, row + 1, col, ans + "D", list);
		dfs(grid, row, col - 1, ans + "L", list);
		grid[row][col] = 1;
	}
	
    public static ArrayList<String> findPath_1(int[][] m, int n) {
        if(m == null || m.length == 0) return null;
        ArrayList<String> list = new ArrayList<String>();
        dfs_1(m, 0, 0, "", list);
        return list;
    }
    
    private static void dfs_1(int grid[][], int row, int col, String ans, 
    ArrayList<String> list){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
        || grid[row][col] == 0)
        return;
        if(row == grid.length - 1 && col == grid[row].length - 1){
            list.add(ans);
            return;
        }
        grid[row][col] = 0;
        dfs(grid, row - 1, col, ans + "U", list);
        dfs(grid, row, col + 1, ans + "R", list);
        dfs(grid, row + 1, col, ans + "D", list);
        dfs(grid, row, col - 1, ans + "L", list);
        grid[row][col] = 1;
    }

	public static void main(String[] args) {
		int maze[][] = { 
				{ 1, 0, 0, 0 }, 
				{ 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0 }, 
				{ 0, 1, 1, 1 }
				};
		RatInMaze rm = new RatInMaze(maze);
		System.out.println(rm.findPath(maze, 0));
		System.out.println(rm.findPath_1(maze, 0));
	}
}
