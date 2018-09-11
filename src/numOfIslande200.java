public class numOfIslande200 {

    /*
    200. Number of Islands
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     An island is surrounded by water and is formed by connecting adjacent lands horizontally
     or vertically. You may assume all four edges of the grid are all surrounded by water.

     Input:       Output: 1
        11110       000000
        11010       011110
        11000   =>  011010
        00000       011000
                    000000


        Input:        Output: 3
        11000
        11000
        00100
        00011


        111
        010
        010

     */

    /*
    bfs or dfs

    first approach
    */

    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //bfs
                if(grid[i][j]=='1'){
                    checkNeighbour(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private void checkNeighbour(char[][] grid, int row, int col){
        grid[row][col]='0';
        if(row>=1 && grid[row-1][col]=='1'){
            checkNeighbour(grid, row-1, col);
        }
        if(row<grid.length-1 && grid[row+1][col]=='1'){
            checkNeighbour(grid, row+1, col);
        }
        if(col>=1 && grid[row][col-1]=='1'){
            checkNeighbour(grid, row, col-1);
        }
        if(col<grid[0].length-1 && grid[row][col+1]=='1'){
            checkNeighbour(grid, row, col+1);
        }
    }

}
