package week06_02_≈‰∏∂≈‰_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] r = { 0, 0, -1, 1 }, c = { -1, 1, 0, 0 };
	static int m, n, answer = Integer.MIN_VALUE;
	static Queue<int[]> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n][m];
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					map[i][j] = Integer.MAX_VALUE;
				} else if (map[i][j] == 1) {
					q.add(new int[] { i, j, 1 });
				}
			}
		}
		bfs();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == Integer.MAX_VALUE) {
					System.out.println(-1);
					return;
				}
				if (map[i][j] != -1) {
					answer = Math.max(answer, map[i][j]);
				}
			}
		}
		System.out.println(answer - 1);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int[] k = q.poll();
			if (map[k[0]][k[1]] < k[2]) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == -1)
					continue;
				if (map[nx][ny] > k[2] + 1) {
					map[nx][ny] = k[2] + 1;
					q.add(new int[] { nx, ny, k[2] + 1 });
				}
			}
		}
	}
}
