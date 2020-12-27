package com.beginnerlevel.coding;

/* 
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1
Example 2:

Input: grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

public int numIslands(char[][] grid) {

 */

public class Solution2 {

	public static void main(String[] args) {
		char[][] grid = new char[][] {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		};
		System.out.println(numIslands(grid));

		grid = new char[][] {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}
		};
		System.out.println(numIslands(grid));
		
		grid = new char[][] {
			{'1','1','1','1','1'},
			{'1','1','1','1','1'},
			{'1','1','1','1','1'},
			{'1','1','1','1','1'}
		};
		System.out.println(numIslands(grid));
		
	}
	
	public static int numIslands(char[][] grid) {
		int island = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]=='1') {
					island += dfs(grid, i , j);
				}
			}
		}
		return island;
	}

	private static int dfs(char[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0')
			return 0;
		
		grid[i][j] = '0';
		
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
		
		return 1;
	}
}
