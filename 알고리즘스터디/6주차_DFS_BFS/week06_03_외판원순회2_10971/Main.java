package week06_03_외판원순회2_10971;

import java.util.Scanner;

public class Main {
	static int[][] cost;
	static int n, first_num;
	static long answer = Long.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			first_num = i;
			int s = (1 << i);
			dfs(i, 0, s);
		}
		System.out.println(answer);
	}

	static void dfs(int start, long sum, int s) {
		if (s == (1 << n) - 1) {
			if (cost[start][first_num] != 0) {
				answer = Math.min(answer, sum + cost[start][first_num]);
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((s & (1 << i)) != 0 || cost[start][i] == 0)
				continue;
			dfs(i, sum + cost[start][i], s | (1 << i));
		}
	}
}
