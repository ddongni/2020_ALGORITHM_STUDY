package week06_05_섬의개수_4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] r = { -1, 1, 0, 0, -1, -1, 1, 1 }, c = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[][] map;
	static int w, h;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			check = new boolean[h][w];
			if (w == 0 && h == 0)
				break;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
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
		check[x][y] = true;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == 0 || check[nx][ny])
					continue;
				check[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}
	}
}
