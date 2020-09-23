package week06_01_À¯±â³ó¹èÃß_1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] r = { 0, 0, -1, 1 }, c = { -1, 1, 0, 0 };
	static int n, m, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			m = sc.nextInt();
			n = sc.nextInt();
			map = new int[n][m];
			answer = 0;
			int k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[x][y] = 1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		map[x][y] = -1;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[nx][ny] == -1 || map[nx][ny] == 0)
					continue;
				map[nx][ny] = -1;
				q.add(new int[] { nx, ny });
			}
		}
	}
}
