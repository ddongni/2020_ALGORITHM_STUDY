package week05_0_외판원순회_2098_DP_비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, answer = Integer.MAX_VALUE;
	static int[][] w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		int[][] dp = new int[n][(1<<n)-1];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			dfs((1 << i), 0, i, i);
		}
		System.out.println(answer);

	}

	static void dfs(int s, int dis, int start, int save) { // save변수에 최초 시작 변수 저장
		if (s == (1 << n) - 1) {
			answer = Math.min(answer, dis + w[start][save]);
			return;
		}
		if (dis > answer)
			return;
		for (int i = 0; i < n; i++) {
			if ((s & (1 << i)) != 0)// 이미 존재할때
				continue;
			if (w[start][i] == 0)
				continue;
			dis += w[start][i];
			dfs(s | (1 << i), dis, i, save);
			dis -= w[start][i];
		}
	}
}
