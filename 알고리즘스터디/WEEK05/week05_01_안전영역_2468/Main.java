package week05_01_안전영역_2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static int[][] cmap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		cmap = new int[n][n];
		int max_height = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = cmap[i][j] = sc.nextInt();
				max_height = Math.max(max_height, map[i][j]);
			}
		}
		int answer = Integer.MIN_VALUE;
		int height = max_height;
		while (height >= 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cmap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] <= height) {
						cmap[i][j] = 0;
					}
				}
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (cmap[i][j] != 0) {
						count++;
						bfs(n, i, j);
					}
				}
			}
			answer = Math.max(answer, count);
			height--;
		}
		System.out.println(answer);
	}

	static void bfs(int n, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] k = q.poll();
			if(cmap[k[0]][k[1]]==0) continue;
			cmap[k[0]][k[1]] = 0;
		
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || cmap[nx][ny] == 0)
					continue;
				q.add(new int[] { nx, ny });
			}
		}
	}
}
