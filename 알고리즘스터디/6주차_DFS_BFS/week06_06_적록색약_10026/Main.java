package week06_06_적록색약_10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static String[][] map;
	static boolean[][] check;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new String[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) + "";
			}
		}
		check = new boolean[n][n];
		int nRG = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					noRG(i, j, map[i][j]);
					nRG++;
				}
			}
		}
		check = new boolean[n][n];
		int gRG = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					getRG(i, j, map[i][j]);
					gRG++;
				}
			}
		}
		System.out.println(nRG+" "+gRG);
	}

	static void noRG(int x, int y, String s) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny])
					continue;
				if (map[nx][ny].equals(s)) {
					check[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	static void getRG(int x, int y, String s) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		if (s.equals("R") || s.equals("G")) {
			while (!q.isEmpty()) {
				int[] k = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = k[0] + r[i];
					int ny = k[1] + c[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny])
						continue;

					if (map[nx][ny].equals("R") || map[nx][ny].equals("G")) {
						check[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
		} else {
			while (!q.isEmpty()) {
				int[] k = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = k[0] + r[i];
					int ny = k[1] + c[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny])
						continue;

					if (map[nx][ny].equals(s)) {
						check[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
	}
}
