package week06_04_연결요소의개수_11724;

import java.util.Scanner;

public class Main {
	static boolean[] check;
	static int[][] c;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		check = new boolean[n];
		c = new int[n][n];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			c[x][y] = c[y][x] = 1;
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	static void dfs(int idx) {
		if (check[idx])
			return;
		check[idx] = true;
		for (int i = 0; i < n; i++) {
			if (c[idx][i] == 1) {
				dfs(i);
			}
		}

	}
}
