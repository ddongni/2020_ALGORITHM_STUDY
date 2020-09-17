package week05_05_테트로미노_14500;

import java.util.Scanner;

public class Main {
	static int[][][] blocks = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } },
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } }, { { 0, 0 }, { -2, 1 }, { -1, 1 }, { 0, 1 } },
			{ { 0, 0 }, { -1, 0 }, { 0, 1 }, { 0, 2 } }, { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } }, { { 0, 0 }, { 1, -1 }, { 2, -1 }, { 1, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
			{ { 0, 0 }, { -1, 1 }, { -1, 2 }, { 0, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, -1 } }, { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < blocks.length; k++) {
					int sum = 0;
					for (int l = 0; l < 4; l++) {
						int x = i + blocks[k][l][0];
						int y = j + blocks[k][l][1];
						if (x < 0 || y < 0 || x >= n || y >= m)
							continue;
						sum += map[x][y];
					}
					answer = Math.max(answer, sum);
				}
			}
		}
		System.out.println(answer);
	}
}
