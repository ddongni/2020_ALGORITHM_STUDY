package week05_04_nQueen_20759577;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] dir = {
			{ -1, -1 }, // ºÏ¼­
			{ -1, 0 }, // ºÏ
			{ -1, 1 }, // ºÏµ¿
			{ 0, -1 }, // ¼­
			{ 0, 1 }, // µ¿
			{ 1, -1 }, // ³²¼­
			{ 1, 0 }, // ³²
			{ 1, 1 }// ³²µ¿
	};
	static int n, answer = 0;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		check = new boolean[n];
		combi(0);
		System.out.println(answer);
	}

	static void combi(int index) {
		if (index == n) {
			answer++;
			return;
		}
		int[][] copy = new int[n][n];
		copy(map, copy);
		for (int i = 0; i < n; i++) {

		}
		for (int i = 0; i < n; i++) { // Çà ¼±ÅÃ
			if (check[i] || map[index][i] == 1)
				continue;
			check[i] = true;
			queen(index, i);
			combi(index + 1);
			check[i] = false;
			copy(copy, map);
		}
	}

	static void copy(int[][] map, int[][] cmap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cmap[i][j] = map[i][j];
			}
		}
	}

	static void queen(int x, int y) {
		map[x][y] = 1;
		for (int j = 0; j < 8; j++) {
			for (int i = 1; i < n; i++) {
				int nx = x + i * dir[j][0];
				int ny = y + i * dir[j][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					break;
				if (map[nx][ny] != 1) {
					map[nx][ny] = 1;
				}
			}

		}
	}
}
