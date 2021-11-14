package dynamic.programming;
/**
 * 
 * FIND AREA WHERE THE NUMBER OF 1 IS MAXIMUM AND THEY ARE ALL CONNECT IN SOME MANNER
 * EITHER VERTICALLY OR HORIZONTALY OR EITHER WITH BOTH BUT NOT DIGONALLY CONNECTED
 * 
 * 
 * 1 IS ISLAND AND 0 IS WATER
 * 
 * @author dheerajkumar02
 *
 */
public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
            	// WE WILL ONLY FIND THE 1 NUMBER PLACE IN ARRAY
                if(grid[i][j] == 1){
                	// COMAPRING THE 1 CONNECTED FROMING ISLAND HENCE THE COUNT OF 1
                	// THE MAXIMUM CONNECTED 1 AREA IS MAX AREA
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    
    private int dfs(int grid[][], int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int count = 1;
        // COUNTING ALL 1 WHICH ARE CONNECTED WITH EACH OTHER
        // COUNT WILL RETURN 1
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i, j - 1);
        return count;
    }
    
    public static void main(String[] args) {
		int grid[][] = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		MaxAreaOfIsland mai = new MaxAreaOfIsland();
		System.out.println(mai.maxAreaOfIsland(grid));
	}
}
